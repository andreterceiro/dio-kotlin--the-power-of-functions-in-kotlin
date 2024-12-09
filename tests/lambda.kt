package tests

fun main() {
    val toUpperCase1: (String) -> String = {str: String -> str.uppercase()} 

    print(toUpperCase1("test 1"))
    print(" -- ")

    val toUpperCase2: (String) -> String = {it.uppercase()}
    print(toUpperCase2("test 2"))
}