package chapter9

import java.util.Random

fun main() {
    val letters = ('a'..'z').toList()

    // Compiler can deduce the generic type
    println(letters.slice(0..2))

    println(listOf(1, 2, 3, 4).penultimate)

    println(listOf(1, 2, 3, 4).sum())

    println(oneHalf(3))

    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailPeriod(helloWorld)
    println(helloWorld)

    val nullableStringProcessor = Processor<String?>()
    nullableStringProcessor.process(null)

    printSum(listOf(1, 2, 3))
    printSumSafe(listOf(1, 2, 3))

    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())


    printContents(listOf("abc", "bac"))

    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)
    println(anyItems)

    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    // Star projection, be transferred to <out Any?>
    val unknownElements: MutableList<*> = if (Random().nextBoolean()) list else chars
    println(unknownElements.first())

    printFirst(listOf("Svetlana", "Dmitry"))
}

// Declare generic in extend property
val <T> List<T>.penultimate: T
    get() = this[size - 2]

// Can invoke method in Number class
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

// Declare only comparable value can call this method
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append(".")
    }
}

// Default upper bound is Any?
class Processor<T> {
    fun process(value: T) {
        value?.hashCode()
    }
}

// * is star projection
fun printSum(c: Collection<*>) {
    // unchecked cast
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

// Compiler can do the "is" checking
fun printSumSafe(c: Collection<Int>) {
    if (c is List<Int>) println(c.sum())
}

// Use inline to get the generic type
inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> Iterable<*>.filterIsInstance(): List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}