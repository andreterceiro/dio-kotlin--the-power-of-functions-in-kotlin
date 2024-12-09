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
}
