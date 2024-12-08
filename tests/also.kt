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