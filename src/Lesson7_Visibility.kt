/**
 * We use modifiers to define scope of class,function and variables.
 * scope tells from where a class,function or a variable can be accessed.
 *
 * In java we used to have four kind of modifiers.
 *
 *            same_class  same_package subclass universe
 *
 * default      Yes         Yes         No        No
 *
 * private      Yes         No          No        No
 *
 * protected    Yes         Yes         Yes       No
 *
 * public       Yes         Yes         Yes       Yes
 *
 * When you dont define a one. It gets a default scope.
 *
 * In kotlin
 *
 * we have exactly same scope modifiers but are with different name and rules.
 * The default modifier is public. if you don't specify then it gonna be a public scoped.
 * private and protected behaves the same. default scope of java is
 * achieved by new keyword
 *
 * "internal"
 *
 * classes can also be declared as private. You cannot use them outside the declared file
 */
fun main() {


    val myClass : MyClass = MyClass()
    // myClass.foo() cannot access private method
}

// You cannot use this class outside of this file
private class MyClass {
    val i : Int = 10

    private fun foo() {
        println("This is a private function")
    }
}


open class MyParentClass {
    private val i : Int = 10
    protected val j : Int = 20
    internal val k : Int = 30
    val l : Int = 40
}

class MySubClass : MyParentClass() {
    fun foo() {
        // We cannot access i as it is private
        println("j is $j and k is $k")
    }
}



