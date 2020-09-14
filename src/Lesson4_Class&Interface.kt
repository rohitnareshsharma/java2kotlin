/**
 * We define classes in our projects. Which are made up of variables and methods
 * Variables tell the data which class provide abstraction to. While methods
 * tells about the behaviour and work that will get executed on the data.
 *
 * Defining classes and interface is exactly same of java. But as there is no static
 * word supported. There are some changes related to creating inner classes.
 *
 * any inner/nested class is by default static in nature. So you can create its object directly
 * without creating enclosing class object.
 *
 * But if you want to create real inner class who can access parent class variables.
 * "inner" keyword is to be used
 *
 * At the end we will learn about declaring anonymous objects as well.
 * For creating anonymous classes we use "object" expression.
 * It is to be supplied with class body
 *
 */
fun main() {

    val job = MyJob()
    job.printMySalary()

    // Look how to access an object member variable in a string
    println("This is my job and my salary is ${job.mySalary}")

    val nestedJob = MyJob.Nested()
    nestedJob.foo()

    val innerJob = MyJob().Inner()
    innerJob.foo()

    // This colon here ":" represents the interface implements of java
    val me = object : Human {
        override fun think() {
            println("Thinking")
        }
    }

    me.think()
}

class MyJob {

    val mySalary = "Huge"

    fun printMySalary() {
        println("My salary is $mySalary")
    }

    class Nested {
        fun foo() {
            // It cannot access mySalary variable
            println("This is a foo function")
        }
    }

    inner class Inner {
        fun foo() {
            // It can access mySalary variable
            println("This is a foo function with access to salary which is $mySalary")
        }
    }
}

interface Human {
    fun think()
}