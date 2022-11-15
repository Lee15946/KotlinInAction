package chapter7

import java.math.BigDecimal

fun main() {
    val p1 = Point(20, 30)
    val p2 = Point(10, 40)

    // times,div,mod,plus,minus
    println(p1 + p2)
    println(p1 - p2)
    println(p1 * 5.0)
    println(5.0 * p1)
    println('a' * 3)

    // shl, shr, ushr≤,and, or, xor, inv
    println(0x0F and 0xF0)
    println(0x0F or 0xF0)
    println(0x1 shl 4)

    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    // plusAssign, minusAssign, timesAssign
    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    // unaryPlus, unaryMinus, not, inc, dec
    println(-point)

    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)

    println(Point(10, 20) == Point(10, 20))
    println(Point(10, 20) != Point(5, 5))
    println(null == Point(1, 2))

    val person1 = Person("Alice", "Smith")
    val person2 = Person("Bob", "Johnson")
    println(person1 < person2)
    println("abc" < "bac")
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Double.times(other: Point): Point {
    return Point((this * other.x).toInt(), (this * other.y).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

class Person(private val firstName: String, private val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}
