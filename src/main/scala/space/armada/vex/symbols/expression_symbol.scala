
package space.armada.vex.symbols

sealed abstract class VexExpression

case class Context(name: String) extends VexExpression

case class Variable(name: String) extends VexExpression

sealed abstract class LiteralValue extends VexExpression
	case class LiteralNumber(value: Double) extends LiteralValue
	case class LiteralString(value: String) extends LiteralValue

sealed abstract class ExpressionOp extends VexExpression

sealed abstract class UnaryOp extends ExpressionOp
	case class Posite(expr: VexExpression) extends UnaryOp
	case class Negate(expr: VexExpression) extends UnaryOp
	case class Not(expr: VexExpression) extends UnaryOp

	case class Complement(expr: VexExpression) extends UnaryOp  // ~
	case class Predecessor(expr: VexExpression) extends UnaryOp // --
	case class Successor(expr: VexExpression) extends UnaryOp   // ++

	case class Quote(expr: VexExpression) extends UnaryOp
	// case class (expr: VexExpression) extends UnaryOp

sealed abstract class BinaryOp extends ExpressionOp
	case class Add(left: VexExpression, right: VexExpression) extends BinaryOp
	case class Subtract(left: VexExpression, right: VexExpression) extends BinaryOp
	case class Multiply(left: VexExpression, right: VexExpression) extends BinaryOp
	case class Divide(left: VexExpression, right: VexExpression) extends BinaryOp
	case class Power(left: VexExpression, right: VexExpression) extends BinaryOp
	case class Modulo(left: VexExpression, right: VexExpression) extends BinaryOp

	case class GT(left: VexExpression, right: VexExpression) extends BinaryOp
	case class GTE(left: VexExpression, right: VexExpression) extends BinaryOp
	case class LT(left: VexExpression, right: VexExpression) extends BinaryOp
	case class LTE(left: VexExpression, right: VexExpression) extends BinaryOp

	case class EQL(left: VexExpression, right: VexExpression) extends BinaryOp // ==
	case class NEQ(left: VexExpression, right: VexExpression) extends BinaryOp // !=
	case class EID(left: VexExpression, right: VexExpression) extends BinaryOp // ===
	case class NID(left: VexExpression, right: VexExpression) extends BinaryOp // !==
	case class CMP(left: VexExpression, right: VexExpression) extends BinaryOp // <=>

	case class Shovel(left: VexExpression, right: VexExpression) extends BinaryOp // <<
	case class Tap(left: VexExpression, right: VexExpression) extends BinaryOp    // >>

	case class Ampersand(left: VexExpression, right: VexExpression) extends BinaryOp // &
	case class Pipe(left: VexExpression, right: VexExpression) extends BinaryOp      // |
	case class Pound(left: VexExpression, right: VexExpression) extends BinaryOp     // #

	case class UnifyingAmpersand(left: VexExpression, right: VexExpression) extends BinaryOp // &&
	case class UnifyingPipe(left: VexExpression, right: VexExpression) extends BinaryOp      // ||
	case class UnifyingPound(left: VexExpression, right: VexExpression) extends BinaryOp     // ##

	case class Contains(left: VexExpression, right: VexExpression) extends BinaryOp    // @>
	case class ContainedBy(left: VexExpression, right: VexExpression) extends BinaryOp // @<

	case class With(left: VexExpression, right: VexExpression) extends BinaryOp // <-
	case class Onto(left: VexExpression, right: VexExpression) extends BinaryOp // ->

	case class Slice(left: VexExpression, right: VexExpression) extends BinaryOp // %%

	case class Squiggle(left: VexExpression, right: VexExpression) extends BinaryOp   // ~~
	case class Unsquiggle(left: VexExpression, right: VexExpression) extends BinaryOp // !~

	case class Send(left: VexExpression, right: VexExpression) extends BinaryOp    // !
	case class Unapply(left: VexExpression, right: VexExpression) extends BinaryOp // :=

	case class Dot(left: VexExpression, right: VexExpression) extends BinaryOp        // .
	case class Join(left: VexExpression, right: VexExpression) extends BinaryOp       // ++
	case class Arisdottle(left: VexExpression, right: VexExpression) extends BinaryOp // ::
	// case class (left: VexExpression, right: VexExpression) extends BinaryOp

sealed abstract class TernaryOp extends ExpressionOp
	case class IfThenElse(cond: VexExpression, near: VexExpression, far: VexExpression) extends TernaryOp

