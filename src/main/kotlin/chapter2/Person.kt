package chapter2

class Person(
    //val: property is read-only
    val name: String,
    //var: property is writable
    var isMarried: Boolean
)

fun main() {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

    person.isMarried=false
    println(person.isMarried)
}