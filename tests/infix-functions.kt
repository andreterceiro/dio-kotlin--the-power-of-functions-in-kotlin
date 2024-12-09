package tests

infix fun Int.times(str: String) = str.repeat(this)

fun main() {
    print(2.times("Bye "))
}