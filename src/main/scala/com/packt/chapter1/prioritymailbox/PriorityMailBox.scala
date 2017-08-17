package com.packt.chapter1.prioritymailbox

import akka.actor.Actor

class MyPriorityActor extends Actor {
  def receive: PartialFunction[Any, Unit] = {
    // Int Messages
    case x: Int => println(x)
    // String Messages
    case x: String => println(x)
    // Long messages
    case x: Long => println(x)
    // other messages
    case x => println(x)
  }
}
