package chapter6

fun main() {
    val letters = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
    println(fiveZeros.asList())
    println(fiveZerosToo.asList())

    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())

    mainWithArgs(arrayOf("1","2","3","4"))

}

fun mainWithArgs(args: Array<String>) {
    args.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }

}