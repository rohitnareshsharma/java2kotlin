/**
 * Constructor in java as we know has the responsibility of
 *   1. Memory Allocation
 *   2. Explicit Initialisation
 *   3. Executing statements written in constructor.
 *
 * Its almost same in kotlin. But we have some syntax changes here.
 *
 * First of all kotlin divide constructors into two category
 *  1. Primary
 *  2. Secondary
 *
 * Primary constructor are defined in the class header declaration itself.
 * They do not allow you to execute any statements. But will help declare
 * some variables of the class. So you can say they help in shaping class design
 *
 * Instead of having variables defined and then define a constructor and
 * write this.myVar = var like statements. Kotlin made it easy.
 *
 * Secondary constructor are defined with keyword "constructor"
 * You can create any number of secondary constructor.
 * but Base class constructors must be called either directly or indirectly.
 *
 * When you don't declare a constructor. Kotlin adds one for you.
 * Because it has to satisfy Object class subclassing.
 *
 */

fun main() {

    val person = Person("Rohit Sharma", 34)
    val person2 = Person2("Rohit Sharma", 34, 5.7f, 76.5f)
    println(person2.toString())

}

// Class example with just a primary constructor. See, Body declaration is not mandatory.
// Short and sweet
class Person(val name : String, var age : Int)


// Class example with secondary constructor
class Person2(val name : String, val age : Int) {

    var height : Float = 0.0f
    var weight : Float = 0.0f

    constructor(name : String, age : Int, height : Float ) : this(name, age){
        this.height = height
    }

    constructor(name : String, age : Int, height : Float, weight : Float) : this(name, age, height){
        this.weight = weight
    }

    override fun toString(): String {
        return "Person name is $name and age is $age and height and weight is $height, $weight respectively"
    }
}