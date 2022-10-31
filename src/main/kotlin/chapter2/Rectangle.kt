package chapter2

class Rectangle(
    private val height: Int,
    private val width: Int
) {
    //Customised get function
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
    val rectangle1 = Rectangle(41, 43)
    println(rectangle1.isSquare)
    val rectangle2 = Rectangle(41, 41)
    println(rectangle2.isSquare)

}