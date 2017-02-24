package com.delprks.eff

import java.io.PrintWriter

import cats.data._
import org.atnos.eff._
import org.atnos.eff.all._
import org.atnos.eff.syntax.all._

object Main extends App {


  type S = Fx.fx1[Writer[String, ?]]

  val action: Eff[S, Int] = for {
    a <- pure[S, Int](1)
    _ <- tell("first value " + a)
    b <- pure[S, Int](2)
    _ <- tell("second value " + b)

  } yield a + b

  // define a fold to output values
  def fileFold(path: String) = new LeftFold[String, Unit] {
    type S = PrintWriter
    val init: S = new PrintWriter(path)

    def fold(a: String, s: S): S = {
      s.println(a); s
    }

    def finalize(s: S): Unit =
      s.close
  }

  action.runWriterFold(fileFold("target/log")).run
  io.Source.fromFile("target/log").getLines.toList
}
