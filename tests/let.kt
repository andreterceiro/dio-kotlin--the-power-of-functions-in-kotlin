package tests

fun main() {
    var ret:String = "test".let {
        toUpperCase(it) // It receives the ret value as calls a function
    }

    print(ret)
}

fun toUpperCase(str: String): String {
    return str.uppercase();
}