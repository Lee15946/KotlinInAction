package chapter3

fun main() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    //"to" here is called as infix call
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map)
    //destructuring declaration
    val (number, name) = 1 to "one"
    println("$number to $name")
}

infix fun Any.to(other: Any) = Pair(this, other)
