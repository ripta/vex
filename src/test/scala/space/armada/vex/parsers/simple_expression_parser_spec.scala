
import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

import space.armada.vex.parsers.SimpleExpressionParser

class SimpleExpressionParserSpec extends Specification with ParserMatchers {

	import space.armada.vex.parsers._

	val parsers = SimpleExpressionParser

	"SimpleExpressionParser" should {
		"parse a single-digit literal" >> { parsers("5") must beSome(LiteralNumber(5.0))     }
		"parse a multi-digit literal"  >> {
			parsers("1234")   must beSome(LiteralNumber(1234))
			parsers(" 1234 ") must beSome(LiteralNumber(1234))
		}

		"parse a 1-char variable"     >> { parsers("x") must beSome(Variable("x"))     }
		"parse a lowercase variable"  >> { parsers("abc") must beSome(Variable("abc")) }
		"parse an uppercase variable" >> { parsers("XYZ") must beSome(Variable("XYZ")) }
		"parse a mixed-case variable" >> {
			parsers("Vex")     must beSome(Variable("Vex"))
			parsers("vEX")     must beSome(Variable("vEX"))
			parsers("  Vex  ") must beSome(Variable("Vex"))
		}

		"fail to parse an invalid variable name" >> {
			parsers("5abc") must beNone
		}
		"fail to parse expressions with no operation" >> {
			parsers("5 abc") must beNone
		}

		"parse an addition" >> {
			parsers("123 + 456") must beSome(Add(LiteralNumber(123), LiteralNumber(456)))
			parsers("123 + abc") must beSome(Add(LiteralNumber(123), Variable("abc")))
			parsers("abc + def") must beSome(Add(Variable("abc"), Variable("def")))
		}

		"parse a subtraction" >> {
			parsers("123 - abc") must beSome(Subtract(LiteralNumber(123), Variable("abc")))
		}

		"parse a multiplication or division" >> {
			parsers("123 * 456") must beSome(Multiply(LiteralNumber(123), LiteralNumber(456)))
			parsers("676 / twentySix") must beSome(Divide(LiteralNumber(676), Variable("twentySix")))
		}

		"parse compound expressions" >> {
			val result = Add(LiteralNumber(1), Multiply(LiteralNumber(2), LiteralNumber(3)))
			parsers("1 + 2 * 3") must beSome(result)
		}

		"parse complex expressions" >> {
			val result: ExpressionSym = Subtract(
				Add(
					LiteralNumber(50.0),
					Multiply(Variable("abc"), LiteralNumber(3.0))
				),
				Divide(LiteralNumber(4.0), Variable("x"))
			)
			parsers("50 + abc * 3 - 4 / x") must beSome(result)
		}
	}

}
