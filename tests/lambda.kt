package tests

fun main() {
    // This way you have to specify the type of the parameter two times
    val toUpperCase1: (String) -> String = {str: String -> str.uppercase()} 
    print(toUpperCase1("test 1"))
    print(" -- ")

    // Uses it
    val toUpperCase2: (String) -> String = {it.uppercase()}
    print(toUpperCase2("test 2"))
    print(" -- ")

    // String::uppercase without parentesis
    // Only works without braces, ok?
    val toUpperCase3: (String) -> String = String::uppercase
    print(toUpperCase3("test 3"))
}