package chapter3

fun main() {
    println("12.345-6.A".split("[.\\-]".toRegex()))
    println("12.345-6.A".split(".", "-"))
    parsePath("/Users/yuhual/kotlin/String.kt")
    parsePathRegexp("/Users/yuhual/kotlin/String.kt")
    val kotlinLogo = """| //
       .|//
       .|/ \ 
    """
    println(kotlinLogo.trimMargin("."))
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePathRegexp(path: String) {
    //Triple quotations
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val result = regex.matchEntire(path)
    if (result != null) {
        val (directory, fileName, extension) = result.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}