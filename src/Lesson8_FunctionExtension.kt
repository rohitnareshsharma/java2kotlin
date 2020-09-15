/**
 * Function Extension
 *
 * What we want to do here is add new methods to a class without inheriting it.
 * This not only looks cool. But has advantage to even add more functionality to
 * a final class.
 */
fun main() {

    val myString = "This is mystring"
    println("is myString empty : ${myString.isEmptyOrNot()}")

    val hulari = Alien("Hulari", "Laser")
    hulari.printSkill()

    val bukati = Alien("bukati", "Flying")
    bukati.printSkill()

    hulari.addSkill(bukati)
    hulari.printSkill()
}

fun String.isEmptyOrNot() : Boolean {
    return this.isEmpty()
}

class Alien(val name : String, var skill : String) {
    fun printSkill() {
        println("My name is $name and my skill is $skill")
    }
}

fun Alien.addSkill(a : Alien) {
    this.skill = this.skill + " and " +a.skill
}