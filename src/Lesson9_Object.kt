/**
 * Sometimes you have to create objects of some class with slight modification
 * without actually creating a subclass. object expression and object declaration
 * comes in handy in this case only.
 *
 * We use object expression for creating anonymous objects and object declaration
 * for creating singleton objects when we name them.
 *
 * They are single object of a type. They are allowed to inherit other classes
 * and behave as normal classes.
 *
 * In case of singleton, they are thread safe and lazily loaded.
 * lazily loaded means, they will created on their first access.
 *
 * there is an expression "by lazy". We will learn about that later
 *
 */
fun main() {

    // Example of object expression
    val a = object : MyClickListener {
        override fun onClick() {
            println("OnClick is called")
        }
    }

    a.onClick()

    // You can refer singleton member on its class name.
    // Looks like static of java
    MySingleton.foo()
}

interface MyClickListener {
    fun onClick()
}

// Example of object declaration
object MySingleton {

    init {
        println("MySingleton got initialised")
    }

    fun foo() {
        println("This is foo from MySingleton")
    }
}