package chapter8

fun main() {
    // Explicit type declaration
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println(42) }
    val canReturnNull: () -> Int? = { null }
    val funOrNull: ((Int, Int) -> Int)? = null

    println(sum(1, 3))
    action()
    println(canReturnNull())
    println(funOrNull)

    twoAndThree(sum)
    twoAndThree { x, y -> x * y }

    println("ab1c".filter { it in 'a'..'z' })

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.lowercase() })
    println(letters.joinToString(separator = "! ", postfix = "! ", transform = { it.uppercase() }))
    println(letters.joinToString(separator = "! ", postfix = "! "))

    val calculator1 = getShippingCostCalculator(Delivery.EXPEDITED)
    val calculator2 = getShippingCostCalculator(Delivery.STANDARD)
    println("Shipping costs ${calculator1(Order(3))}")
    println("Shipping costs ${calculator2(Order(3))}")

    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null)
    )
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in indices) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = " ",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = (transform?.invoke(element)
        // Use Elvis operator to handle null
            ?: element.toString())
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)

fun getShippingCostCalculator(
    delivery: Delivery
): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {
            startsWithPrefix(it) && it.phoneNumber != null
        }
    }
}

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)