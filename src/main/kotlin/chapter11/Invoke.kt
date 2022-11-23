package chapter11

import java.time.LocalDate
import java.time.Period


fun main() {
    val greeter = Greeter("Hello")
    greeter("Jason")

    val i1 = Issue(
        id = "IDEA-154446",
        project = "IDEA",
        type = "Bug",
        priority = "Major",
        description = "Save settings failed"
    )
    val i2 = Issue(
        id = "KT-12183",
        project = "Kotlin",
        type = "Feature",
        priority = "Normal",
        description = "Convert several calls on the with/apply"
    )
    val issuesPredicate = ImportantIssuesPredicate("IDEA")
    for (issue in listOf(i1, i2).filter(issuesPredicate)) {
        println(issue)
    }

    val dependencyHandler = DependencyHandler()
    dependencyHandler.compile("kotlin-stdlib:1.0.0")
    dependencyHandler {
        compile("kotlin-reflect:1.0.0 ")
    }

    "Kotlin" should startWith("K")
    "Java" should start with ("J")

    println(1.days.ago)
    println(1.days.fromNow)
}

class Greeter(private val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name!")
    }
}

data class Issue(
    val id: String, val project: String, val type: String,
    val priority: String, val description: String
)

class ImportantIssuesPredicate(private val project: String) : (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type == "Bug" && (priority == "Major" || priority == "Critical")
    }
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(
        body: DependencyHandler.() -> Unit
    ) {
        body()
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)
interface Matcher<T> {
    fun test(value: T)
}

class startWith(private val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (!value.startsWith(prefix))
            throw AssertionError("String $value does not start with prefix $prefix!")
    }
}

// Not part of function, but part of grammar
object start

infix fun String.should(x: start): StartWrapper = StartWrapper(this)

class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        if (!value.startsWith(prefix))
            throw AssertionError("String $value does not start with prefix $prefix!")
    }
}

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

