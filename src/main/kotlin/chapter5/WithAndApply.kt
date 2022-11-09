package chapter5

fun main() {
    println(alphabetByWith())
    println(alphabetByApply())
    println(alphabet())
}

private const val SENTENCE = "\nNow I know the alphabet"

fun alphabetByWith(): String =
    with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append(SENTENCE)
        this.toString()
    }

fun alphabetByApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    append(SENTENCE)
}.toString()

fun alphabet() = buildString {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    append(SENTENCE)
}