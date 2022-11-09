package chapter6

fun main() {
    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Big Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(ceo))
    println(managerName(developer))

    val person = Person("Dmitry", null)
    println(person.countryName())

    println(foo("Hello"))

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val alice = Person("Alice", jetbrains)
    printShippingLabel(alice)

    // Will throw an IllegalArgumentException
    printShippingLabel(Person("Alexey", null))


}

fun strLenSafe(s: String?) = s?.length ?: 0

fun printAllCaps(s: String?) {
    val allCaps = s?.uppercase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String = this.company?.address?.country ?: "Unknown"

// Elvis operator
fun foo(s: String?) = s ?: ""

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city $country")
    }
}