/**
 * Control flow is a very important aspect of any programming language.
 * In kotlin its very identical to Java. Few addon definitely are here.
 *
 * We have more smart "for loops" and and "switch" is replaced by "when".
 * Also loop labels syntax has also changed from myLabel: to myLabel@
 *
 * Rest everything is same as java. Lets code for some example
 *
 */
fun main() {

    val a = 10
    val b = 20

    if(a>b) {
        println("A is greater than B")
    } else {
        println("B is greater than A")
    }

    // If is capable of returning values.
    // See this example below
    val max = if(a > b) a else b
    println("Maximum of both A and B is $max")

    // When is the switch of kotlin
    when(a) {
        1 -> println("Value of A is 1")
        2,3 -> {
                 println("Value of A is either 2 or 3")
                 println("This is some another work")
               } // Note the block for multiple statements
        else -> println("We do not know the value of A")
    }

    val myArray : IntArray = intArrayOf(1,2,3,4,5,6)
    val myList : List<String> = listOf("Test", "Hello", "World")

    // Lets get value of each item in array and the list
    for(i in myArray) {
        println("value of each item is $i")
    }

    for(i in myList) {
        println("value of each item is $i")
    }

    // Wouldn't that be cool if can get the index and value together in a loop
    // Kotlin do allow you for that. Here is its syntax
    for((index, value) in myArray.withIndex()) {
        println("Value is $value and index is $index")
    }
    for((index, value) in myList.withIndex()) {
        println("Value is $value and index is $index")
    }

    // break, continue, return works exactly like java
    for(i in 0..10) {
        if(i == 9) {
            println("Value of i is 9")
            println("Breaking the loop")
            break
        }

        if(i == 5) {
            println("Not printing value of i when it is 5")
            continue
        }

        println("Value of i is $i")
    }

    // There is a change in ways to define labels in kotlin
    for((i,v) in myArray.withIndex()) {

        mylabel@
        for((j,k) in myList.withIndex()) {
           if(j == 2) continue@mylabel
            println("Index and value of inner loop is $j and $k")
        }
        println("Inner loop finished with $i and $v")
    }
    println("Outer loop finished")

    // While loop is same like of java
    var i = 0
    while(i < a) {
        print("Value of i is $i")
        i++
    }
    println()

    // So the do while is same like java too.
    do {
        i--
        println()
    } while(i>0)

}