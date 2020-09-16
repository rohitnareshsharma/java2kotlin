/**
 * static was a very handy and powerful and extensively used item in java world.
 * kotlin do not has static. But we have its replacement.
 *
 * companion object
 *
 * Its actually an object that we bind with the class.
 * So many call this as "Object Extension" too
 *
 * check the sample below.
 */
fun main() {

    val a = A()
    a.foo()
    A.shoo()
    println(A.j)
}

class A {

    companion object {

        init {
           println("companion object created")
        }

        val j : Int = 20

        fun shoo() {
            println("$j")
        }
    }

    val i : Int = 10

    fun foo() {
        println("$i and $j")
    }

}