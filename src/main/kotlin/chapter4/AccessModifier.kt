package chapter4

fun main() {
    println(eval(Expr.Sum(Expr.Num(1), Expr.Sum(Expr.Num(2), Expr.Num(4)))))

}

interface State : java.io.Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ButtonNew : chapter4.View {
    override fun getCurrentState(): State = ButtonState()

    // Nested Class here is static
    class ButtonState : State {}
}

class Outer {
    // Nested class with inner keyword has an outer class reference
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

// Sealed class's subclass can only be defined inside, default open
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        // No need to add else here, all possibilities are covered in sealed class
    }
