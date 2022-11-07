package chapter5

fun main() {
    val persons = listOf(Person("Alice", 29), Person("Bob", 31))
    // Lambda
    println(persons.maxBy { it.age })
    // Method reference
    println(persons.maxBy(Person::age))

    val sum = { x: Int, y:
    Int ->
        println("Computing the sum of $x and $y.")
        x + y
    }
    println(sum(1, 2))

    run { println(42) }

    val names = persons.joinToString(separator = " ", transform = { person -> person.name })
    println(names)

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    run(::salute)

    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p)

    //Save lambda as instance
    fun Person.isAdult() = age >= 21
    val predicate = Person::isAdult
    println(predicate(p))

    // Bind with member
    val predicateForAlice = p::isAdult
    println(predicateForAlice())

}

data class Person(val name: String, val age: Int)

fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors.")
}

fun salute() = println("Salute!")
