package chapter6

fun main() {
    showProgress(146)

    println(PersonWithAge("Sam", 35).isOlderThan(PersonWithAge("Amy", 42)))
    println(PersonWithAge("Sam", 35).isOlderThan(PersonWithAge("Jane")))

    val i = 1
    val l: Long = i.toLong()
    println(l)
    println(i.toLong() in listOf(1L, 2L, 3L))

    val b: Byte = 1
    val long = b + 1L
    foo(long)
    println("42".toInt())
    // Will auto-boxing
    val answer: Any = 42
    println(answer)

    fail("Error occurred")
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

data class PersonWithAge(val name: String, val age: Int? = null) {
    fun isOlderThan(other: PersonWithAge): Boolean? {
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

fun foo(l: Long) = println(l)

fun fail(message:String):Nothing{
    throw IllegalStateException(message)
}