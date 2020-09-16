/**
 * https://kotlinlang.org/docs/reference/generics.html
 *
 * Its a complex and tricky topic always. The entire fudge is around
 * the type equality and possible assignments.
 *
 * In general Generics is telling compiler the kind of data any abstraction
 * is going to hold or operate. So their retrieval and type casting can be made
 * easy and safe.
 *
 * A parent type reference can hold the reference of a child type.
 * Class and Type are two different things.
 * List<String> is not equivalent and so not assignable to List<Object>
 *
 * This may create problem at runtime. See below code
 *
 * val list : List<String> = listOf("Hello", "World")
 * val list2 : List<Object> = list // compiler not gonna allow you to avoid RTTI error.
 * list2.add(1)
 * val myString = list.get(2) // Class Cast Exception
 *
 * But its handy many a time to define supertype that can accept multiple types input.
 * Less codes.
 *
 * Java introduced <? extends T> and <? super T> wildcard qualifiers to solve this problem.
 * It comes with limitation. So it made invariant as covariant
 *
 * <? extends T> : with this you can safely read T. but not safely put.
 * So class with such declaration becomes a kind of producer of T.
 *
 * <? super T> : with this you can safely put T or its supertype. But will always get Object
 * if you try to read. So class with such declaration is kind of a consumer of T.
 *
 *            Java            kotlin
 *        <? extends T> -->   <out T>
 *        <? super T>   -->   <int T>
 *
 */
fun main() {

    val a : MyGenericClass<String> = MyGenericClass("Hello World of Generics")
    val b : MyGenericClass<Int> = MyGenericClass(20)

    //val c : MyGenericClass<Any> = a // This will not compile
    val d : MyGenericClass<Any> = MyGenericClass("String")
    val e : MyGenericClass<String> = d // This will compile as T is declated as in. So class is a consumer
}

class MyGenericClass<in T>(t : T) {
    init {
        println("Hi this is my generic object $t")
    }

    // You cant return T from this function
    fun foo(t : T) {

    }
}

