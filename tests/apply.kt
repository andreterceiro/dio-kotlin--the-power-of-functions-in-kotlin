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
