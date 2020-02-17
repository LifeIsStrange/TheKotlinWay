fun reflectionsCanMakeAProgramAwareOfItself() {
    println(::`strings can do a lot of things 👽`.name)
}

fun main() {
    reflectionsCanMakeAProgramAwareOfItself()

    `strings can do a lot of things 👽`()
    `Kotlin c'est pas null`()
    `examples of control flow`()

    // exercices at: https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt
}
// read more: https://arrow-kt.io/
// Higher kinded types
// purity