package tests

infix fun Int.times(str: String) = str.repeat(this)

fun main() {
    print(2.times("Bye "))
    print(" -- ")

    print(2 times("Hi! ")) // Also works without a dot!
    print(" -- ")

    val pair = "Júlio" to "Enzo"
    print(pair)
    print(" -- ")

    print(pair::class.simpleName)
    print(" -- ")

    val julio = Person("Julio")
    print(julio.name)
    print(" -- ")

    julio addSon "André"
    julio addSon "Thais"
    print(julio.sons)
}

class Person(var name: String) {
    val sons = mutableListOf<String>()

    fun constructor() {
        this.name = name
    }

    infix fun addSon(name: String) {
        this.sons.add(name)
    }
}
