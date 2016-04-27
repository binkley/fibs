package hm.binkley

import java.lang.System.err
import java.lang.System.exit

private val fib0 = Q(Fraction(0), Fraction(1),
        Fraction(1), Fraction(1))
private val ifib0 = Q(Fraction(-1), Fraction(1),
        Fraction(1), Fraction(0))

private fun usage() {
    err.println("Usage: fibs <n>")
    exit(2)
}

private fun n(args: Array<String>): Int? {
    return if (1 == args.size) try {
        args[0].toInt()
    } catch (e: NumberFormatException) {
        null
    } else null
}

fun main(args: Array<String>) {
    var n: Int = n(args) ?: return usage()

    val m: Q
    if (n < 0) {
        n = -n
        m = ifib0
    } else {
        m = fib0
    }

    generateSequence(fib0) { it -> it * m }.
            take(n + 1).
            forEach { println(it) }
}
