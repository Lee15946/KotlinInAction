package chapter3

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun main() {
    val view: View = Button()
    view.click()
    //Depend on the declared type, not the running type
    view.showOff()

    val button = Button()
    button.showOff()

    println("Kotlin".lastChar)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}

//Extension function
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

//Extension properties
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) = this.setCharAt(length - 1, value)

