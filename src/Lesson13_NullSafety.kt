/**
 * Null Safety was one of the largely talked about feature
 * for switching to kotlin.
 *
 * For any java developer. Perhaps this is the most difficult bridge
 * to get through for entering into the world of kotlin. As in kotlin syntax. ?. ?: ?.let
 * you name it. Some creepy expression are lurking around.
 *
 * But it turns out. They are pretty easy to understand and not only they make
 * code null safe. But also make code shorter by removing boilerplate null check codes.
 * Especially for chained checks
 *
 * We will learn about below expressions
 *
 *    ?.
 *    ?:
 *    ?.let
 *    !!.
 *    as?
 *
 * There are two types in kotlin for any variable
 *
 *  1. Non Null Types
 *  2. Nullable Types
 *
 * As the name suggests, Non null types are not allowed to receive null values.
 * By default all variable you will declare will be of non null types.
 *
 *    val name : String = null // Compiler error. String is non null type.
 *    val name : String = "Rohit Sharma" // Will work fine
 *
 *    val length = name.length // No null check required as the type is Non Null type
 *
 * We can make variable capable of receiving null values by making their type as Nullable
 * Just append "?" at the end of the Type.
 *
 *    var name : String? = null // Allowed now
 *
 * Caveat : Now as we have made this Type as a Nullable type.
 *          You have to check for NUll values before accessing it.
 *          Else compiler will throw error
 *
 *    var length = name.length // This will not compile now as name is Nullable type.
 *
 * Lets put in null checks
 *
 *    if(name != null) {
 *        var length = name.length // Compiler will allow now. As a null check has already been done
 *    }
 *
 * But its Kotlin right. There is a smart way of doing the exact above
 *
 *    ?.
 *
 * Access the member by ?. instead of standard dot. This will access member only if its non null value.
 * it will return null if name is null.
 *
 * Remember ?. is needed only for Nullable types
 *
 *    var length = name?.length
 *
 * It really helps in the chain
 *
 *    var headName = employee?.department?.head?.getName()
 *
 *
 *
 *  Elvis operator ?:
 *
 *  Instead of null if you want to return something. Use the elvis operator
 *
 *    var headName = employee?.department?.head?.getName() ?: "Headless Creature"
 *    var headName = employee?.department?.head?.getName() ?: throw RuntimeException("Head name is missing")
 *
 *  right side of the elvis operator will get executed only if left side evaluates to null.
 *
 *
 *  No we love the NPE. !!
 *
 *    var name : String? = null
 *    var length = name!!.length
 *
 *  !! make name as a non null type and will throw NPE in case name is null
 *
 *  Sometime you would want to do some stuff for non null types only.
 *  just append let{} to ?. and provide the statements in the {}
 *
 *  Safe casts
 *
 *  var aInt : Int? = a as? Int
 *
 */
fun main() {

    val a : String = "Value is mandatory as a is Non Null Type"

    val lengthOfA = a.length // No null checks needed as a is Non Null Type

    val b: String? = null // We made b as Nullable type

    val lengthOfB = b?.length ?: 0 // You have to check for null values

    val name: String? = null

    // Do some block execution in case name is carrying a non null value
    name?.let {
        println("Hello World")
        println(it) // It will refer to the name value
        println("We are done here")
    }

    // Safe cast
    var aInt : Int? = a as? Int

    println("Null Pointer Exception is intended. Do not worry")
    val lengthOfBOrNPE = b!!.length


}