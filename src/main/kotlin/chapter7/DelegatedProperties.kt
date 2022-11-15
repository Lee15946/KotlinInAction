package chapter7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {
    val p = PersonNew("Alice")
    // Will only print once
    p.email
    p.email

    val h = Human("Dimity", 34, 2000)
    h.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
    h.age = 35
    h.salary = 2100

    val h2 = Human2("Dimity", 34, 2000)
    h2.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
    h2.age = 40
    h2.salary = 3000

    val h3 = Human3("Dimity", 34, 2000)
    h3.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
    h3.age = 50
    h3.salary = 3100

    val h4 = Human4("Dimity", 34, 2000)
    h4.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
    h4.age = 60
    h4.salary = 3200

}

class PersonNew(val name: String) {
    val email by lazy { loadEmails(this) }
}

fun loadEmails(person: PersonNew): List<String> {
    println("Load emails for ${person.name}")
    return listOf("test@email.com")
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Human(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

class Human2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    private val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(newValue) {
            _age.setValue(newValue)
        }

    private val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(newValue) {
            _salary.setValue(newValue)
        }
}

class Human3(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    var age: Int by ObservableProperty2(age, changeSupport)
    var salary: Int by ObservableProperty2(salary, changeSupport)
}

class Human4(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary , observer)
}

class ObservableProperty(
    private val propName: String, private var propValue: Int,
    private val changeSupport: PropertyChangeSupport
) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class ObservableProperty2(
    private var propValue: Int, private val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Human3, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Human3, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}