package chapter6

fun main() {
    val p1 = PersonNew("Dmitry", "Jerome")
    val p2 = PersonNew("Dmitry", "Jerome")
    println(p1 == p2)
    println(p1.equals(42))
}

class PersonNew(private val firstName: String, private val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? PersonNew ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}