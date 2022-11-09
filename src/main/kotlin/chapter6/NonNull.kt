package chapter6

fun main() {
    // Will throw a NUllPointerException
    // ignoreNulls(null)
    ignoreNulls("Alice")

    val email: String? = "test@email.com"
    email?.let { sendEmailTo(it) }

    // Let function will never be invoked
    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.name) }

    verifyUserInput(" ")
    verifyUserInput(null)

    // Will throw an exception
    // yellAt(PersonJava(null))
    yellAtSafe(PersonJava(null))

}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun getTheBestPersonInTheWorld(): Person? = null

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields!")
    }
}

fun yellAt(person: PersonJava) {
    println(person.name.uppercase() + "!!!")
}

fun yellAtSafe(person: PersonJava) {
    println((person.name ?: "Anyone").uppercase() + "!!!")
}
