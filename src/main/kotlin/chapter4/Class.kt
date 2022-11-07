package chapter4

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()


}

interface Clickable {
    fun click()

    // default method
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")

    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    // Must override this function
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()

    }
}

//open keyword declares this class can be inherited
open class RichButton : Clickable {
    // can not override
    fun disable() {
        println("I'm disabled!")
    }

    // can override in subclass
    open fun animate() {}

    // override a function and is open as wel,
    // when it has final keyword explicitly, it can not be overridden
    final override fun click() {}
}

// Abstract class, can not be initialized
abstract class Animated {
    // Abstract method, need to override in subclass
    abstract fun animate()

    // Non-abstract method in abstract class is default final, but can be marked as open
    open fun stopAnimating() {}

    fun animateTwice() {}

}