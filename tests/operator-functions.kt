package tests

fun main() {
    operator fun Int.times(str: String) = str.repeat(this)
    print(3 * "hi ")
    // prints "hi hi hi "
    print(" -- ")

    operator fun String.get(range: IntRange) = substring(range)
    print("Brasil"[0..2])

}