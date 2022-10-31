package chapter2

import java.util.Random

class Rectangle(
    private val height: Int,
    private val width: Int
) {
    //Customised get function
    val isSquare: Boolean
        get() {
            return height == width
        }
    val area: Int
        get() = height * width
}

fun main() {
    val rectangle1 = Rectangle(41, 43)
    println(rectangle1.isSquare)
    val rectangle2 = Rectangle(41, 41)
    println(rectangle2.isSquare)
    println(rectangle2.area)
    println(createRandomRectangle().isSquare)
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}