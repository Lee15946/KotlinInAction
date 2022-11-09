package chapter6

fun main() {
    printHashCode(null)
    printHashCodeNonNull("1")
}

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T : Any> printHashCodeNonNull(t: T) {
    println(t.hashCode())
}