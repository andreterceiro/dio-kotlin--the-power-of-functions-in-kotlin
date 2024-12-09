package tests

fun operation(): (Int) -> Int {
    return ::square
}

fun square(num: Int): Int {
    return num * num
}

fun main() {
    print(operation()(2))
    print(" -- ")

    // or

    var func = operation()
    print(func(2))
}