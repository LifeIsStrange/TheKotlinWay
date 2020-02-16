fun reflectionsCanMakeAProgramAwareOfItself() {
    println(::`strings can do a lot of things 👽`.name)
}

// todo https://kotlinlang.org/docs/reference/lambdas.html
fun main() {
    reflectionsCanMakeAProgramAwareOfItself()

    `strings can do a lot of things 👽`()
    `Kotlin c'est pas null`()
}