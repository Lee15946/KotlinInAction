package chapter7

import java.time.LocalDate

fun main() {
    val p = Point(10, 20)
    // Will be translated to get method
    println(p[1])
    println(p[0])


    val p2 = MutablePoint(10, 20)
    // Will be translated to set method
    p2[1] = 42
    println(p2)

    val rectangle = Rectangle(Point(10, 20), Point(50, 50))
    // Will be translated to contain method
    println(Point(20, 30) in rectangle)
    println(Point(5, 5) in rectangle)

    val now = LocalDate.now()
    // Will be translated to rangeTo function
    val vocation = now..now.plusDays(10)
    println(now.plusDays(1) in vocation)

    val n = 9
    println(0..(n + 1))

    (0..n).forEach { println(it) }

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }

    // Destructuring declaration
    val (x, y) = p
    println(x)
    println(y)

    val (name, ext) = splitFileName("example.kt")
    println(name)
    println(ext)

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int) {
    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point) {
    operator fun contains(p: Point): Boolean {
        return p.x in upperLeft.x until lowerRight.x &&
                p.y in upperLeft.y until lowerRight.y
    }
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive
        override fun next(): LocalDate = current.apply { current = plusDays(1) }
    }

data class NameComponents(val name: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}
