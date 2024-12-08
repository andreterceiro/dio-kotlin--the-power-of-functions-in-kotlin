
package tests

fun main() {
    var ret:String = "test".run({
        print(length) // Similar a "test".length, but in run works this way
        print(" -- ")
        toUpperCase(this) // It receives the ret value as calls a function
                          // You don't need to use return - the last instruction is returned        
    })

    print(ret)
}

fun toUpperCase(str: String): String {
    return str.uppercase();
}
