package chapter5

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.asSequence().map(Person::name).filter { it.startsWith("A") }.toList())

    // Will not print anything, end operation missing
    listOf(1, 2, 3, 4).asSequence().map { println("map($it)"); it * it }.filter { println("filter($it)");it % 2 == 0 }
    // Will print
    listOf(1, 2, 3, 4).asSequence().map { println("map($it)"); it * it }.filter { println("filter($it)");it % 2 == 0 }
        .toList()

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
    fun createAllDoneRunnable(): Runnable {
        return Runnable { println("All done!") }
    }
    createAllDoneRunnable().run()
}