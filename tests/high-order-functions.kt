package tests

fun main() {
    print(calculate(4, 5, ::sum))
    // prints 9
}

// Pay atention to the ":" sign after 'functionWhoSums'
fun calculate(a: Int, b:Int, functionWhoSums: (Int, Int) -> Int): Int {
    return functionWhoSums(a, b)
}

fun sum(x: Int, y: Int): Int {
    return x + y
}