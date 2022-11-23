package chapter10

import chapter1.Person
import kotlin.reflect.full.memberProperties


var counter = 0

fun main() {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::foo
    // Use KCallable to invoke the function
    kFunction.call(42)
    kFunction(42)
    kFunction.invoke(42)

    println(counter.javaClass.kotlin.simpleName)
    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())

    val memberProperty = Person::age
    println(memberProperty.get(person))
}

fun foo(x: Int) = println(x)

