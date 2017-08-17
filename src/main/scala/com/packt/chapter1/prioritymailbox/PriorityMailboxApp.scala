package com.packt.chapter1.prioritymailbox

import akka.actor.{ActorSystem, Props}

object PriorityMailBoxApp extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val myPriorityActor =
    actorSystem.actorOf(Props[MyPriorityActor].withDispatcher("prio-dispatcher"))
  myPriorityActor ! 6.0
  myPriorityActor ! 1
  myPriorityActor ! 5.0
  myPriorityActor ! 3
  myPriorityActor ! "Hello"
  myPriorityActor ! 5
  myPriorityActor ! "I am priority actor"
  myPriorityActor ! "I process string messages first,then integer, long and others"
}
