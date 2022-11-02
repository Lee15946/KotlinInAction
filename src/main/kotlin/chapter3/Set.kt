package chapter3

fun main() {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    //to is a function here
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fify-three")
    //HashSet
    println(set.javaClass)
    //ArrayList
    println(list.javaClass)
    //HashMap
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    println(joinToString(collection = list, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(collection = list))
    println(joinToString(collection = list, separator = "; "))
    println("Kotlin".lastChar())
    println("Kotlin".lastCharNew())

    val newList = arrayListOf(1, 2, 3)
    println(newList.joinToStringNew(" "))

    val stringList = listOf("one", "two", "three")
    println(stringList.joing(" "))
}

//Generate overload function for every argument which has default value, easy for Java to invoke
@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        //No separator before first element
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this[this.length - 1]

//Can hide this
fun String.lastCharNew(): Char = get(length - 1)

fun <T> Collection<T>.joinToStringNew(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = java.lang.StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.joing(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
) = joinToStringNew(separator, prefix, postfix)


