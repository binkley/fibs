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

    fun display(it: IndexedValue<Q>, dir: Boolean): String {
        val n = it.index
        val fib = it.value
        val sign = if (dir || 0 == n) "" else "-"
        return """Fib($sign$n):
$fib
(fib($sign$n): ${fib.a}; det: ${fib.det()}; trace: ${fib.trace()})"""
    }

    generateSequence(fib0) { next(it) }.
            take(limit + 1).
            withIndex().
            map { it -> display(it, n > -1) }.
            forEach(::println)

    println(display(IndexedValue(7, fib0(7)), true))
    println(display(IndexedValue(-2, fib0(-2)), true))
}
