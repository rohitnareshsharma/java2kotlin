/**
 * Lets talk about declaring basic types of variables in kotlin.
 * But before that lets learn about "var" and "val".
 *
 * var defines variables whose value can change.
 * val is used for variables which are constants. So a final one
 *
 *   var a = 10
 *   val b = 30
 *
 *   b = 40 // Will not compile
 *   a = 40 // Works perfectly
 *
 * Always prefer declaring val. They make your code more safe. Remember the advice in
 * java to declare variable as final. Kotlin took this advice seriously.
 *
 * In Java you have following types. Check their counterpart in kotlin
 * followed by --> symbol
 *
 *  Primitive
 *
 *     Integral
 *
 *        byte  --> Byte
 *        short --> Short
 *        int   --> Int
 *        long  --> Long
 *
 *     Textual
 *
 *        char --> Char
 *        String --> String
 *
 *     Logical
 *
 *        boolean --> Boolean
 *
 *     Floating
 *
 *         float --> Float
 *         double --> Double
 *
 *  Advanced
 *
 *      Class types are declared the same way as in Java.
 *      As they represents custom made classes.
 *
 *
 *  Primitive types looks like Wrapper classes of java.
 *  but kotlin is smart enough to save the autoboxing and unboxing over head.
 *
 *
 *  var variableName : variableType = defaultValue
 *
 *  As we know kotlin is a strongly typed language. From the value itself compiler can know
 *  about the type of variable. That's why its redundant to mention variableType in the variable
 *  declaration.
 *
 *  You may want to declare Arrays of these basic Types. Most importantly declaring collections
 *  primarily list, map, and sets. We will also discuss about ranges.
 *
 *  Collection are of types in kotlin. Mutable and Immutable
 *  You will have to learn about various methods of declaring
 *  collection in kotlin.
 *
 *  lets just jump in the code and see what they are doing.
 */
fun main() {

    val myInt : Int = 10
    val myByte : Byte = 10
    val myShort : Short = 10
    val myLong : Long = 10L

    val myFloat : Float = 10.0f
    val myDouble : Double = 10.0

    val myBoolean : Boolean = false
    val myChar : Char = 'A'

    val myString : String = "Hi This is a String"

    // This is cool right. No more + concatenation ugly code.
    // You can refer variable in a String by using $ symbol
    println("Hi this is $myInt and $myByte and $myBoolean")

    println(myByte)

    // We have Array class like IntArray for all supported basic types
    // IntArray, CharArray, ByteArray, LongArray, BooleanArray
    // There is also an Array class. But lets skip that for now.
    // Seems kotlin has 100 ways of defining one thing. Lets progress

    val myIntArray : IntArray = intArrayOf(1,2,3,4,5,6)
    val myCharArray : CharArray = charArrayOf('A','B','C','D')


    // Lets declare some collection now
    val myList = listOf("hello", "World")
    val mySet = setOf(1,2,3,"Hello", "World")
    val myMap = mapOf("One" to 1, "Two" to 2)


    val myMutableList = mutableListOf("hello", "World")
    val myMutableSet = mutableSetOf(1,2,3,"Hello", "World")
    val myMutableMap = mutableMapOf("One" to 1, "Two" to 2)


    //myList.add("Test") Not going to compile. Because it is immuatble object
    myMutableList.add("Test")

    println(myMutableList)

    // We also have many cool methods available with kotlin collection extensions
    // like first, last and really cool one like, filter, foreach. These are inline function
    // We will learn about them later.


    println(myMutableMap.get("One"))
    println(myMutableMap.getOrDefault("1", "test"))

    myList.forEach {
        print(it)
    }

    println()
    println(myList.filter { it.contains("hell")})

    // Ranges : We want to iterate through a specific range of an array or collection
    // It is represented by .. symbol
    for(i in 4..10) {
        print(i)
    }
}