
import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

import space.armada.vex.parsers.CalculatorParser

class CalculatorParserSpec extends Specification with ParserMatchers {

	val parsers = CalculatorParser

	"CalculatorParser.apply" should {
		"calculate the addition of two integers" >> { parsers("2 + 3") must beEqualTo(5) }
		"calculate the subtraction of two integers resulting in a positive value" >> {
			parsers("9 - 3") must beEqualTo(6)
		}
		"calculate the subtraction of two integers resulting in a negative value" >> {
			parsers("3 - 9") must beEqualTo(-6)
		}
	}

	"CalculatorParser.number" should {
		"recognize single-digit positive numbers" >> { parsers.number must succeedOn("5")  }
		"recognize multi-digit positive numbers"  >> { parsers.number must succeedOn("42") }
		// "recognize negative numbers"              >> { parsers.number must succeedOn("-9") }
	}

}
