
package space.armada.vex.parsers

import scala.util.parsing.combinator.RegexParsers
import space.armada.vex.symbols._

object SimpleExpressionParser extends RegexParsers {
	def expr = opTier1

	def opTier1: Parser[VexExpression] = opTier2 ~ rep("+" ~ opTier2 | "-" ~ opTier2) ^^ {
		case op ~ list => list.foldLeft(op) {
			case (left, "+" ~ right) => Add(left, right)
			case (left, "-" ~ right) => Subtract(left, right)
		}
	}

	def opTier2: Parser[VexExpression] = operand ~ rep("*" ~ operand | "/" ~ operand) ^^ {
		case op ~ list => list.foldLeft(op) {
			case (left, "*" ~ right) => Multiply(left, right)
			case (left, "/" ~ right) => Divide(left, right)
		}
	}

	def operand = (literalNumber | variable)
	def variable: Parser[VexExpression] = """\w+""".r ^^ { name => Variable(name) }
	def literalNumber: Parser[VexExpression] = """-?\d+""".r ^^ { value => LiteralNumber(value.toDouble) }

	def apply(input: String): Option[VexExpression] = parseAll(expr, input) match {
		case Success(result, _) => Some(result)
		case NoSuccess(_, _)    => None
	}
}
