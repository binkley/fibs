package hm.binkley

import java.lang.System.err
import java.lang.System.exit
import java.lang.System.out

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

    val step: Int
    val m: Q
    if (n < 0) {
        step = -1
        m = ifib0
    } else {
        step = 1
        m = fib0
    }

    out.println(fib0)
    var fibn = fib0
    while (n != 0) {
        fibn *= m
        out.println(fibn)
        n -= step
    }
}
