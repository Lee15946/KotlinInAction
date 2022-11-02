package chapter2

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val bufferedReader = BufferedReader(StringReader("234"))
    val bufferedReader2 = BufferedReader(StringReader("Not a number"))
    readNumber(bufferedReader)
    //Nothing will be printed
    readNumber(bufferedReader2)
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: java.lang.NumberFormatException) {
        return
    }
    println(number)
}