package chapter4

import java.io.File

fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    val faceBookUser = UserNew.newFaceBookUser(2)
    val subscribingUser = UserNew.newSubscribingUser("bob@email.com")
    println(faceBookUser.nickName)
    println(subscribingUser.nickName)
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int = file1.path.compareTo(file2.path, ignoreCase = true)
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}

class UserNew private constructor(val nickName: String) {
    companion object {
        fun newSubscribingUser(email: String) = UserNew(email.substringBefore('@'))
        fun newFaceBookUser(accountId: Int) = UserNew(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String {
            return "Facebook: $accountId"
        }
    }
}

