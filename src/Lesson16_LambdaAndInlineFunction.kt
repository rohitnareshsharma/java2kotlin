/**
 *  Lambda Expression : Functions are treated as objects in kotlin.
 *  So you can pass them around. Pass as function parameter itself.
 *
 *  Function receiving function as parameters or returning Function
 *  are called as High Order function.
 *
 *  Functions can be defined in an anonymous fashion with short hand
 *  operators known as lambda. In java lambda are also used for
 *  single method interface implementation also.
 *
 *  High order function are a memory overhead. So kotlin introduced
 *  inline keyword. Its basically expanding the inline function at the call site.
 *  So helping performance.
 *
 *  Use it wisely
 *
 *  infix function are also a new thing in kotlin. It allows calling a method
 *  with . and (). Make things look more cool.
 *
 *  "Hello" and "World" where and is and is a infix function
 */
fun main() {

    val myLambda : (String,Int) -> Unit = {
        a, b ->
        println("$a is the string received")
        println("$b is the int received")
    }

    myLambda("Hello", 10)
    func(myLambda)

    println()

    // One lambda can be passed outside of parenthesis
    println(myHighOrderFunction(10) { a-> a*2})
    // More than one lambda is to be passed in parenthesis
    println(myHighOrderFunction(10, { a -> a * 2 } , { a -> a * 2 }))

    println("Hello" and "World")
}

fun func(lamda : (String, Int) -> Unit) {
    lamda("Baba", 45)
}

inline fun myHighOrderFunction(a : Int, twice : (Int) -> Int) : Int {
    return twice(a)
}

inline fun myHighOrderFunction(a : Int, twice : (Int) -> Int , thrice : (Int) -> Int) : Int {
    return twice(a) + thrice(a)
}

infix fun String.and(value : String) : String {
    return "$this $value"
}