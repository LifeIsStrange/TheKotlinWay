fun expression_example() {
    val a = 5
    val b = 4

    // expression based language
    val max = if (a > b) {
        a
    } else {
        b
    }
    println(max)
}

class MathUtils()

infix fun MathUtils.isValueInRange(x: Int): Unit  = when (x) {
    in 1..10 -> print("x is in the range")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}

// default arguments, and named arguments
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {}

fun foo(vararg strings: String) { /*...*/ }

val eps = 1E-10

// tail call recursive
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))


sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}

// where bounds, contravariance, covariance
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun length(s: String) = s.length
fun isOdd(nbr: Int): Boolean = nbr % 2 != 0

fun `examples of control flow`() {
    expression_example()
    val math = MathUtils()
    math isValueInRange 3
    reformat(str="damn", upperCaseFirstLetter = false)
    // spread operator like ... in js
    foo(strings = *arrayOf("a", "b", "c"))
    // tail call recursive
    findFixPoint()

    // functors and higer order functions are cool!
    // map, flatmap, filter, any, fold, groupBy, etc
    val numbers = listOf(1, 2, 3)
    println(numbers.map { it * it }) // [1, 4, 9]
    // filter
    println(numbers.filter { it %2 == 0 })
    eval(Const(2.0))

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength))


    // destructuring is cool
    data class Book(val author: String, val title: String, val year: Int)
    val book = Book("Roberto Bolano", "2666", 2004)

    val (author, title, year) = book

    // lazy properties (virtually infinite length)
    // observables // get notified on property update
    // sequences

    // enums can encapsulate function
    // companion object allow shared static variables

    // asynchronicity in kotlin: coroutines
    // optionally support actor model

    // higher kinded types
}
