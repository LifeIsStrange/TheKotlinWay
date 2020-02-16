// data keyword means that getters, copy constructor and other niceties are auto-implemented
data class Alien(val name: String, val face: String)

fun `strings can do a lot of things 👽`() {
    val musicNote = "\uD834\uDD1E"
    val alienEmojiFace = """👽"""

    val alien = Alien("e.t.", alienEmojiFace)

    // $ and ${} for string interpolation
    val sentence = "My name is ${alien.name.toUpperCase()} $musicNote,\n" + "this is my face: ${alien.face}"
    val anotherWay = """
                            |My name is ${alien.name.toUpperCase()} $musicNote,
                            |this is my face: ${alien.face}
                            """.trimMargin()

    // operator overloading
    if (sentence == anotherWay) {
        println(sentence)
    }
}