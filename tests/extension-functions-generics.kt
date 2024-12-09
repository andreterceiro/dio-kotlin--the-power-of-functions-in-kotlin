package tests

fun <T> T?.nullSafeToString() = this.toString() ?: "valor nulo"

fun main() {
    print(null.nullSafeToString())
    print(" -- ")
    print("Hi".nullSafeToString())
}
