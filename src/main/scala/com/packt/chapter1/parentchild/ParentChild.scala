package com.packt.chapter1.parentchild

import akka.actor.{ActorSystem, Props, Actor}


case object CreateChild

case class Greet(msg: String)


class ParentChild {

}
