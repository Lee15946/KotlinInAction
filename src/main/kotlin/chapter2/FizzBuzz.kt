package chapter2

import java.util.TreeMap

fun main() {
    val oneToTen = 1..10
    for (i in oneToTen) {
        println(fizzBuzz(i))
    }
    for (i in 1..100) {
        println(fizzBuzz(i))
    }
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
    treeMap()

}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun treeMap() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter=$binary")

    }
}