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


## Scope functions


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


## run

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


## with

More close to run, with a different syntax, see:

```kotlin
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
```


## apply

Please see the following code:

```kotlin
package tests

class Person(var name: String, var age: Int) {
    constructor(): this("", 0)

    override fun toString(): String {
        return "name: $name, age: $age"
    }
}

fun main() {
    var person = Person()

    person.apply({
        name = "André" // no comma at the end
        age = 42       // equals sign and not a double column
    })

    print(person)
}
```


## also

Please see the following code:

```kotlin
package tests

class Person(var name: String, var age: Int) {
    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}

fun sayHello(p: Person) { // type Person
    print("Hello to ${p.name} -- ")
}

fun main() {
    val person = Person("André", 42)
    person.also {
        sayHello(it) // Here, also uses it, who is equals here to a person
    }
    println(person)
}
```


# "special", different functions


## infix functions

Please see this simple example. In this example we extend the behaviour of Int with a times method:

```kotlin
package tests

infix fun Int.times(str: String) = str.repeat(this)

fun main() {
    print(2.times("Bye "))
    print(2 times("HI! ")) // Also works without a dot!    
}
```

An internal infix function `to`:

```kotlin
package tests

infix fun Int.times(str: String) = str.repeat(this)

fun main() {
    val pair = "Júlio" to "Enzo"
    print(pair)
    print(" -- ")

    print(pair::class.simpleName)
}
```

You also can create as internal function of a class:

```kotlin
package tests

fun main() {
    val julio = Person("Julio")
    print(julio.name)
    print(" -- ")

    julio addSon "André"
    julio addSon "Thais"
    print(julio.sons)
}

class Person(var name: String) {
    val sons = mutableListOf<String>()

    fun constructor() {
        this.name = name
    }

    infix fun addSon(name: String) {
        this.sons.add(name)
    }
}
```


## Operator functions

With this functions we can replace the behariour of the operators or add some functionality. But we have to memorize the method names to use, see:

```kotlin
package tests

fun main() {
    operator fun Int.times(str: String) = str.repeat(this)
    print(3 * "hi ")
    // prints "hi hi hi "
    print(" -- ")

    operator fun String.get(range: IntRange) = substring(range)
    print("Brasil"[0..2])
}
```


## High order functions

Here we will study a function that returns another function or functions that receives another function as a parameter.

Let's see first a function that receives another function as a parameter:

```kotlin
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
```