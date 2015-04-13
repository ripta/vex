
package space.armada.vex.symbols

sealed abstract class ExpressionSym

case class Variable(name: String) extends ExpressionSym

sealed abstract class LiteralValue extends ExpressionSym
	case class LiteralNumber(value: Double) extends LiteralValue
	case class LiteralString(value: String) extends LiteralValue

sealed abstract class ExpressionOp extends ExpressionSym

sealed abstract class UnaryOp extends ExpressionOp
	case class Posite(expr: ExpressionSym) extends UnaryOp
	case class Negate(expr: ExpressionSym) extends UnaryOp
	case class Not(expr: ExpressionSym) extends UnaryOp

sealed abstract class BinaryOp extends ExpressionOp
	case class Add(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Subtract(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Multiply(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Divide(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
