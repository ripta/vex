
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

	case class Complement(expr: ExpressionSym) extends UnaryOp  // ~
	case class Predecessor(expr: ExpressionSym) extends UnaryOp // --
	case class Successor(expr: ExpressionSym) extends UnaryOp   // ++

	case class Quote(expr: ExpressionSym) extends UnaryOp
	// case class (expr: ExpressionSym) extends UnaryOp

sealed abstract class BinaryOp extends ExpressionOp
	case class Add(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Subtract(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Multiply(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Divide(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Power(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class Modulo(left: ExpressionSym, right: ExpressionSym) extends BinaryOp

	case class GT(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class GTE(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class LT(left: ExpressionSym, right: ExpressionSym) extends BinaryOp
	case class LTE(left: ExpressionSym, right: ExpressionSym) extends BinaryOp

	case class EQL(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // ==
	case class NEQ(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // !=
	case class EID(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // ===
	case class NID(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // !==
	case class CMP(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // <=>

	case class Shovel(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // <<
	case class Tap(left: ExpressionSym, right: ExpressionSym) extends BinaryOp    // >>

	case class Ampersand(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // &
	case class Pipe(left: ExpressionSym, right: ExpressionSym) extends BinaryOp      // |
	case class Pound(left: ExpressionSym, right: ExpressionSym) extends BinaryOp     // #

	case class UnifyingAmpersand(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // &&
	case class UnifyingPipe(left: ExpressionSym, right: ExpressionSym) extends BinaryOp      // ||
	case class UnifyingPound(left: ExpressionSym, right: ExpressionSym) extends BinaryOp     // ##

	case class Contains(left: ExpressionSym, right: ExpressionSym) extends BinaryOp    // @>
	case class ContainedBy(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // @<

	case class With(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // <-
	case class Onto(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // ->

	case class Slice(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // %%

	case class Squiggle(left: ExpressionSym, right: ExpressionSym) extends BinaryOp   // ~~
	case class Unsquiggle(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // !~

	case class Send(left: ExpressionSym, right: ExpressionSym) extends BinaryOp    // !
	case class Unapply(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // :=

	case class Dot(left: ExpressionSym, right: ExpressionSym) extends BinaryOp        // .
	case class Join(left: ExpressionSym, right: ExpressionSym) extends BinaryOp       // ++
	case class Arisdottle(left: ExpressionSym, right: ExpressionSym) extends BinaryOp // ::
	// case class (left: ExpressionSym, right: ExpressionSym) extends BinaryOp

sealed abstract class TernaryOp extends ExpressionOp
	case class IfThenElse(cond: ExpressionSym, near: ExpressionSym, far: ExpressionSym) extends TernaryOp

