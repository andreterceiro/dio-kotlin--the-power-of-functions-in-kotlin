package tests

class Numbers(var number1: Int, var number2: Int)

fun main() {
    val numbers:Numbers = Numbers(1, 2)

    val sum:Int = with(numbers) {
        number1 + number2 // No 'return' is needed. Automatic returns the last 
                          // instruction of the block
                          // I can access all the properties of the 'numbers'
                          // object without specifying it
    }

    print(sum)
}