import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Delegation : Passing responsibility to someone else.
 *
 * Lets try to learn what all you can do in kotlin using delegation
 *
 * 1. Define a class which implements an interface but delegating its method implementation
 *    to one of its object.
 *
 * 2. Change the getter and setter of any var or val defined.
 *
 * 3. Lazy load or delay computation of any property : "by lazy {}"
 *
 * 4. observe change in any property
 *
 * 5. veto change of any property
 *
 * 6. route get and set of any property to another property.
 *
 * 7. assign value to properties from a map
 *
 * 8. delay local variable initialisation.
 *
 */
fun main() {

    // Point 1
    DelegationSample(BaseImpl()).foo()

    // Point 2
    var test : String by Delegation()
    println(test)
    test = "Jhakas"
    println(test)


    // Point 3
    // Lazy is computed only after its first access
    val l : String by lazy {
        println("l is computed")
        "Hello"
    }
    println(l)
    println(l)

    // Point 4
    var i : Int by Delegates.observable(10) {
        prop, old, new ->
        println("$old is changed to $new")
    }
    println(i)
    i = 20
    println(i)

    // Point 5
    var j : Int by Delegates.vetoable(10) { prop, old, new ->
        new <= 15
    }
    println(j)
    j = 20
    println(j)

    // Point 6
    // It is not supported in my kotlin version
    // Need to upgrade
    //  var newName : String? = null
    //  var oldName : String by ::newName

    // Point 7
    val user = User(mapOf(
        "name" to "Rohit",
        "age"  to 34
    ))

    println(user.name)
    println(user.age)

    // Point8
    val myLambda : () -> Int = {
        println("Executing lambda for calculation of t")
        5
    }
    val t : Int by lazy(myLambda)

    if(j > 5) {
        println(t)
        println(t)
    }

}

interface Base {
    fun foo()
}

class BaseImpl : Base {

    override fun foo() {
        println("Foo")
    }
}

class DelegationSample(b : Base) : Base by b {
    fun shoo() {
        println("Shoo")
    }
}

class Delegation {

    var value : String? = null

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        return "$value is the value"
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, s: String) {
        value = s
        println("$s is the value assigned")
    }
}

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}
