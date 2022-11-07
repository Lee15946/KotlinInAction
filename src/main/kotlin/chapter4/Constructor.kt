package chapter4

import javax.naming.Context

fun main() {
    val alice = User("Alice")
    println(alice.isSubscribed)
    val bob = User("Bob", false)
    println(bob.isSubscribed)
}

// Primary constructor
// Can give property default value
class User(val nickName: String, val isSubscribed: Boolean = true)

class UserTwo constructor(_nickName: String) {
    val nickName: String

    // Initializer block
    init {
        nickName = _nickName
    }
}

open class UserThree constructor(_nickName: String) {
    val nickName = _nickName
}

// Need to provide constructor for super class
class TwitterUser(nickName: String) : UserThree(nickName)

// Will generate an empty default constructor
open class ButtonDefault

// This class has a private constructor
class Secretive private constructor() {}

// More common way
class SecretiveNew {
    private constructor()
}