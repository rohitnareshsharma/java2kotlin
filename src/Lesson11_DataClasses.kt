/**
 * Imagine a person class with just 3 fields name, age, height.
 * Just to store this basic info in a java pojo class. You have to
 * create an entire class file with getters and setters.
 *
 * Also if you wish to have. equals, hascode, tostring method. Imagine
 * a lot of more code going in. Class will no longer look like a coca cola.
 *
 * Kotlin solved this boilerplate code issue for smartly storing data.
 * by introducing data classes.
 *
 * Data Classes = Meant to hold data fields, Java POJO
 *              = add hashcode, equals, tostring methods automatically for you
 *              = provides copy(), componentN() like handy methods
 *              = cannot be abstract, open, inner or sealed
 *              = can be extended by other data classes
 *              = support destructive declaration statements
 *              = you can define custom methods also by providing body
 *
 * Just one line of code will do the same trick of 50+ lines of java code
 *
 *
 * copy() -> Allows you to clone entire object. You can modify also.
 *
 * componentN() -> depending upon the number of argument in the primary constructor
 *                 kotlin creates component1(), component2() and so on methods.
 *                 Each will return values in order as mentioned in the primary constructor
 *
 * In the end we will learn about Destructive Declaration.
 */

data class MyPerson(var name : String, var age : Int, var height : Float)

fun main() {

    val person = MyPerson("Rohit",34, 5.7f )
    val person2 = MyPerson("Rohit",35, 5.7f )

    println(person)
    println(person2)
    println("Is person1 and person2 are same : ${person.equals(person2)}")

    // We are cloning the entire object
    println(person.copy())

    // We are cloning the entire object, but also modifying certain values
    println(person.copy(height = 5.9f, age = 67))


    println(person.component1()) // Will return name
    println(person.component2()) // Will return age
    println(person.component3()) // Will return height

    // Destructive Declarations
    val (name, age, height) = person // It is internally based on componentN() methods
    println(name)
    println(age)
    println(height)

    // Destructive declaration works super well with collection also.
    val listOfPerson : List<MyPerson> = listOf(person, person2, person.copy(name="Akash"))

    for((name, age, height) in listOfPerson) {
        println("name is $name, age is $age and height is $height")
    }

}