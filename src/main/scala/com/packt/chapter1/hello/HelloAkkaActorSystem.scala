package com.packt.chapter1.hello

import akka.actor.ActorSystem

/**
  * Created by user
  */
object HelloAkkaActorSystem extends App {
  val actorSystem = ActorSystem("HelloAkka")
  println(actorSystem)
}