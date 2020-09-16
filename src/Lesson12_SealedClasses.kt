/**
 * Represent restricted set of class hierarchy. you declare a class as sealed
 * by adding sealed keyword in class header. What it basically do is now this
 * class can be subclassed by classes defined in the same file only.
 *
 * So you end up with limited possible types of an object. This comes primarily
 * handy when this object is passed in "when" expression. Compiler will make you check
 * and define cases for all possible type. So no else is required.
 *
 * They look like enums of java. But you can see them as advanced enum.
 * enums used to be singleton in nature. Where you can have multiple
 * objects of sealed subclass type with each carrying its own state,
 * own set of variables
 *
 */
fun main() {

    val operation : Operation = Increment
    val y = 20

    val result = when(operation) {
        is Addition -> y + operation.x
        is Subtraction -> y - operation.x
        is Divide -> y / operation.x
        Increment -> y + 1
        Decrement -> y - 1
    }

    println(result)

}

sealed class Operation
class Addition(val x : Int) : Operation()
class Subtraction(val x : Int) : Operation()
class Divide(val x : Int) : Operation()

// We can create singleton object as sealed object too
object Increment : Operation()

object Decrement : Operation()
