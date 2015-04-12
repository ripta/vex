
package space.armada.vex

import parsers.CalculatorParser

object TestRunner {
  def main(args: Array[String]) = {
  	// println("Boom!")
  	val res = CalculatorParser("15 + 12")
  	println(res)
  }
}
