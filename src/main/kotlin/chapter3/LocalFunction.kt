package chapter3

class User(val id: Int, val name: String, val address: String)

fun main() {
    saveUser(User(1, "", ""))
}

fun User.validateBeforeSave() {
    fun validate(
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty())
            throw IllegalArgumentException(
                "Cannot save user ${id}: $fieldName is empty"
            )
    }
    validate(name, "name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    println("Save complete! Id is ${user.id}")
}

