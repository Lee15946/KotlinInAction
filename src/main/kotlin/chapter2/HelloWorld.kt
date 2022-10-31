package chapter2

fun main(args: Array<String>) {
    println("Hello, world!")
    println(max(1, 3))
    println(max2(1, 3))
    println(max3(1, 3))

    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}")
    }
    println("Hello, ${if (args.isNotEmpty()) args[0] else "someone"}")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

fun max3(a: Int, b: Int) = if (a > b) a else b