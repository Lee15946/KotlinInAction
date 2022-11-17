package chapter8

import chapter1.Person


fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })
    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    lookForAlice(people)
    lookForAlice2(people)
    lookForAlice3(people)

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
}

data class SiteVisit(
    val path: String, val duration: Double, val os: OS
)

enum class OS { WINDOWS, MAC, IOS, ANDROID }

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            // Will return, only can be used in inline function
            return
        }
    }
    println("Alice is not found!")
}

fun lookForAlice2(people: List<Person>) {
    people.forEach label@{
        // Will only return from lambda
        if (it.name == "Alice") return@label
    }
    people.forEach {
        // Will only return from lambda
        if (it.name == "Alice") return@forEach
    }
    println("Alice might be somewhere")
}

fun lookForAlice3(people: List<Person>) {
    // Anonymous function can return
    people.forEach(fun(person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}