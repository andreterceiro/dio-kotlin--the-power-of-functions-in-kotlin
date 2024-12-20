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

We an also pass a lambda function:

```kotlin
package tests

fun main() {
    print(calculate(4, 5, {a, b -> a * b}))
    // prints 9
}

// Pay atention to the ":" sign after 'functionWhoSums'
fun calculate(a: Int, b:Int, functionWhoSums: (Int, Int) -> Int): Int {
    return functionWhoSums(a, b)
}
```

We can also return a function, pay attention to the syntax:

```kotlin
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
```


## Extension function generics

As you can see in the next example, we create a function to print a value checking if is null for all types, generic:

```kotlin
package tests

fun <T> T?.nullSafeToString() = this.toString() ?: "valor nulo"

fun main() {
    print(null.nullSafeToString())
    print(" -- ")
    print("Hi".nullSafeToString())
}
```


## Suspend functions

Is associated to asynchronous tasks (because of this uses coroutines). Please see this example:

```kotlin
package tests

import kotlinx.coroutines.*

fun main() = runBlocking {
    doWorld()
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(5000L)
        print("world")
    }

    print("Hello ")
}
```

Please also see [this link](https://pl.kotl.in/14qvU5dQI) in Kotlin Playgroud.

As you can see in the example, the delay is associated to all output. Isn't related to an output, a delay and a subsequent output.


## Lambda function

You can construct lambda functions in several ways, see:

![lambda function variations](images/lambda-variations.png)

In the test directories I will test lambda functions, but only some variations, ok?

Two simple tests: 

```kotlin
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
```

Please pay attention to the details, like the double colon. You have to obbey the syntax.


## Extension functions and types

Specifically this item I have not tested, please see the example of the teacher:

![extension functions](images/extension-functions.png)


# Support materials

Please see this 2 sections in the [repository of the course](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos):

- 5_funcoes_de_escopo
- 6_funcoes_avancadas