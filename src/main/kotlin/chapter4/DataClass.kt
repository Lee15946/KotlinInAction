package chapter4

fun main() {
    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    val bob = client1.copy(name = "Bob")
    println(client1)
    println(client1 == client2)
    println(hashSetOf(client1).contains(client1))

    println(bob)

}

class Client(private val name: String, private val postalCode: Int) {
    override fun toString(): String = "Client (name=$name, postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

// Data class will generate code for us automatically
data class ClientNew(val name: String, val postalCode: Int)
