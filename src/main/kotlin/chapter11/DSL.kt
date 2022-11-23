package chapter11

fun main() {
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    val s2 = buildStringNew {
        append("Hello, ")
        append("World!")
    }
    println(s2)

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder.toString())
    println(buildString(appendExcl))

    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" }
    with(map) {
        this[3] = "three"
    }
    println(map)
}

val appendExcl: StringBuilder.() -> Unit = { this.append("!") }

fun buildString(
    buildAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    buildAction(sb)
    return sb.toString()
}

fun buildStringNew(
    builderAction: StringBuilder.() -> Unit
): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}