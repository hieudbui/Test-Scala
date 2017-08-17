package com.packt.chapter1.prioritymailbox

import akka.actor.ActorSystem
import akka.dispatch.{PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.Config

class MyPriorityActorMailbox(settings:
                             ActorSystem.Settings, config: Config) extends
  UnboundedPriorityMailbox(
    // Create a new PriorityGenerator, lower prio means more important
      PriorityGenerator {
      // Int Messages
      case x: Int => 1
      // String Messages
      case x: String => 0
      // Long messages
      case x: Long => 2
      // other messages
      case _ => 3
    })

