package com.packt.chapter1.behaviorandstate

import akka.actor.{Actor, ActorSystem, Props}

object BehaviourAndState extends App {
  val actorSystem = ActorSystem("HelloAkka")
  // creating an actor inside the actor system
  val actor = actorSystem.actorOf(Props[SummingActor], "summingactor")
  val actorwithconstructor = actorSystem.actorOf(Props(classOf[SummingActorWithConstructor], 10), "summingactorwithconstructor")
  // print actor path
  println(actor.path)
  println(actorwithconstructor.path)

  while (true) {
    Thread.sleep(1000)
    actor ! 1
    actorwithconstructor ! 1

  }
}

class SummingActor extends Actor {
  // state inside the actor
  var sum: Long = 0

  // behaviour which is applied on the state
  override def receive: Receive = {

    // receives message an integer
    case x: Int =>
      sum = sum + x
      println(Thread.currentThread().getName)
      println(s"SummingActor state as sum is $sum")
    // receives default message
    case _ => println("I don't know what are you talking about")
  }
}


class SummingActorWithConstructor(intitalSum: Int)
  extends Actor {
  // state inside the actor
  var sum = 0

  // behaviour which is applied on the state
  override def receive: Receive = {
    // receives message an integer
    case x: Int => sum = intitalSum + sum + x
      println(Thread.currentThread().getName)
      println(s"SummingActorWithConstructor state as sum is $sum")
    // receives default message
    case _ => println("I don't know what are you talking about")
  }
}




