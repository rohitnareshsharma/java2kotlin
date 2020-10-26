/**
 * Inheritance - Extend existing classes.
 * Kotlin is no exception in supporting this feature.
 *
 * We will learn
 *
 * 1. How to extend classes
 * 2. Call same class other constructors
 * 3. lateinit
 * 4. init block
 *
 * it is done by ":" symbol in class header.
 * By default all classes are final. If you want it to be extended
 * you got to explicitly mention "open" in its declaration.
 *
 * constructor never get passed to child classes. Its same like java
 *
 * Sometimes you may have to do some init and do not want to create secondary constructor.
 * Primary constructor syntax may not allow you to do that.
 * init block for the rescue.
 *
 * lateinit : Kotlin do not allow you to create variable which may possibly carry null values.
 * Sometimes you would want to declare instance variables which you are sure will get initialised later.
 * You can override compiler error by lateinit keyword. Check the usage in code below.
 *
 */
fun main() {

    val engineer = Engineer("Rohit Sharma", 5000000)
    engineer.foo()

    val manager = Manager("Aman", 10000000, "Android", "Mobile")
}

open class Employee(val name : String, val salary : Int) {
    override fun toString(): String {
        return "Employee Name : $name and salary is $salary"
    }

    fun foo() {
        println("Foo")
    }
}

open class Engineer(name : String, salary: Int) : Employee(name, salary) {

    // We are overriding init checks of kotlin. We are sure we will init it later.
    // Try avoiding this as much as possible. Compiler warnings are there for some
    // strong reasons only.
    lateinit var skill : String

    constructor(name : String, salary: Int, skill : String) : this(name, salary) {
        this.skill = skill
    }

    override fun toString(): String {
        return super.toString() + "and skill is $skill"
    }
}

class Manager(name : String, salary: Int, skill : String, department : String) : Engineer(name, salary, skill) {

    // We want to do something post primary constructor.
    init {
        // As we have not appended any var or val
        println("A new manager joined the $department department")
    }

}