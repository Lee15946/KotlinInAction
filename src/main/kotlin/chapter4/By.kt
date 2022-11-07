package chapter4

fun main() {
    val countingSet = CountingSet<Int>()
    countingSet.addAll(listOf(1, 3, 3, 4))
    println("${countingSet.objectsAdd} objects were added, ${countingSet.size} remain.")
}

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {
    var objectsAdd = 0
    override fun add(element: T): Boolean {
        objectsAdd++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdd += elements.size
        return innerSet.addAll(elements)
    }
}