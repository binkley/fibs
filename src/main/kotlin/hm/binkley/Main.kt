package hm.binkley

import hm.binkley.Q.Companion.fib0
import java.lang.System.err
import java.lang.System.exit

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

/** {@code main} Main entry point  */
fun main(args: Array<String>) {
    var n = n(args) ?: return usage()
    val limit: Int
    val next: (Q) -> Q
    if (n < 0) {
        next = Q::dec
        limit = -n
    } else {
        next = Q::inc
        limit = n
    }

    fun display(it: Q): String {
        val n = it.n
        return """Fib($n):
$it
(fib($n): ${it.a}; det: ${it.det()}; trace: ${it.trace()})"""
    }

    generateSequence(fib0) { next(it) }.
            take(limit + 1).
            map(::display).
            forEach(::println)

    println(display(fib0(7)))
    println(display(fib0(-2)))

    println(display(fib0.pow(0)))
    println(display(fib0.pow(1)))
    println(display(fib0.pow(2)))
    println(display(fib0.pow(-1)))

    println((fib0(0) * fib0(-1)) == fib0)
    println(display(fib0(0) * fib0(-2)))
}
