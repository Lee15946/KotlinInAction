package chapter5

fun main() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age >= 30 })
    println(people.map { Person::name })
    println(people.filter { it.age > 30 }.map { Person::name })

    val maxAge = people.maxBy(Person::age).age
    people.filter { it.age == maxAge }

    // filterKeys, mapKeys, filterValues, mapValues
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase() })

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))

    println(people.groupBy { Person::age })

    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy(String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })
    println(listOf(listOf(1,2), listOf(3,4)).flatten())
}