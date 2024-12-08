# Function inside another function

Is possible, as you can see in the following example:

```kotlin
package tests

fun main() {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    
    print(sum(2, 3))
}
```

5 is printed (2 + 3)


# let

Easy to understand, please see this code:

```kotlin
package tests

fun main() {
    var ret:String = "test".let({
        toUpperCase(it) // It receives the ret value as calls a function
                        // You don't need to use return - the last instruction is returned
    })

    print(ret)
}

fun toUpperCase(str: String): String {
    return str.uppercase();
}
```


# run

Similar to let, see the next code:

```kotlin
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
```

Details:
- In let you have to use 'it', but in case of run you have to use 'this';
- You can use 'length' that is equals to this.lenght().