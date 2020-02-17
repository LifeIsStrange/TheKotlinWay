/*
 Get rid of those pesky NullPointerExceptions, you know, The Billion Dollar Mistake
*/

// singleton are first class citizen
object Singleton {
    fun doNothing() {}
    var nullableStr: String? = null
}

fun `Kotlin c'est pas null`() {
    var output: String
    // output = null   // Compilation error

    // Kotlin protects you from mistakenly operating on nullable types

    val name: String? = null    // Nullable type
    // println(name.length())      // Compilation error

    // btw functions can be nested
    fun calculateTotal(obj: Any?) {
        // And if you check a type is right, the compiler will auto-cast it for you AKA smartcast
        if (obj is Singleton) {
            obj.doNothing()
            // with great power comes great responsibility
            val lyingToTheCompiler: String = obj.nullableStr!!
        }
    }

    val b: String? = null
    // safe call AKA optional chaining
    println(b?.length)

    // safe cast
    val aInt: Int? = b as? Int

    // safe recovery AKA elvis operator
    val negativeLengthIfbIsNull = b?.length ?: -1
}
