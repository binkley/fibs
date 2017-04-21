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
    val next: (Q) -> Q
    if (n < 0) {
        next = Q::dec
        n = -n
    } else {
        next = Q::inc
    }

    fun display(it: IndexedValue<Q>)
            = """Fib(${it.index}):
${it.value}
(fib(${it.index}): ${it.value.a}; det: ${it.value.det()}; trace: ${it.value.trace()})"""

    generateSequence(fib0) { next(it) }.
            take(n + 1).
            withIndex().
            map(::display).
            forEach(::println)

    println(display(IndexedValue(7, fib0(7))))
    println(display(IndexedValue(-2, fib0(-2))))
}
