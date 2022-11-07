package chapter4

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickName)
    println(SubscribingUser("test@kotlinlang.org").nickName)
    println(FacebookUser(2).nickName)
    val user = UserMutable("Alice")
    user.address = "This Street 47"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

interface UserInfo {
    val nickName: String
}

// Primary constructor for interface
class PrivateUser(override val nickName: String) : UserInfo

// Customized getter for nickName
class SubscribingUser(private val email: String) : UserInfo {
    override val nickName: String
        get() = email.substringBefore('@')
}

class FacebookUser(accountId: Int) : UserInfo {
    override val nickName: String = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "Facebook:$accountId"
    }
}

class UserMutable(private val name: String) {
    var address: String = "unspecified"
        set(value) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".
        """.trimIndent()
            )
            // Update field
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}