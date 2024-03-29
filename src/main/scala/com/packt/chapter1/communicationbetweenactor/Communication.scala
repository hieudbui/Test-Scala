package com.packt.chapter1.communicationbetweenactor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.util.Random._

object Messages {

  case class Done(randomNumber: Int)

  case object GiveMeRandomNumber

  case class Start(actorRef: ActorRef)

}

class RandomNumberGeneratorActor extends Actor {

  import Messages._

  override def receive: Receive = {
    case GiveMeRandomNumber =>
      println("received a message to generate a random integer")
      val randomNumber = nextInt
      sender ! Done(randomNumber)
  }
}

class QueryActor extends Actor {

  import Messages._

  override def receive: Receive = {
    case Start(actorRef: ActorRef) =>
      println(s"send me the next random number")
      actorRef ! GiveMeRandomNumber
    case Done(randomNumber: Int) =>
      println(s"receive a random number $randomNumber")
  }
}

object Communication extends App {

  import Messages._

  val actorSystem = ActorSystem("HelloAkka")
  val randomNumberGeneratorActor = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "randomNumberGeneratorActor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "queryActor")

  queryActor ! Start(randomNumberGeneratorActor)
}