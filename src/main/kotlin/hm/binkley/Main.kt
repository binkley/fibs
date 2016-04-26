package hm.binkley

import java.lang.System.err
import java.lang.System.exit
import java.lang.System.out
import java.util.*

private val fib0: IntArray = intArrayOf(0, 1, 1, 1)
private val ifib0: IntArray = intArrayOf(-1, 1, 1, 0)

private fun row(a: IntArray, i: Int): IntArray {
    val offset = 2 * i
    return intArrayOf(a[0 + offset], a[1 + offset])
}

private fun col(a: IntArray, j: Int): IntArray {
    return intArrayOf(a[0 + j], a[2 + j])
}

private infix fun IntArray.dot(that: IntArray): Int {
    return this[0] * that[0] + this[1] * that[1]
}

private operator fun IntArray.times(that: IntArray): IntArray {
    return intArrayOf(row(this, 0) dot col(that, 0),
            row(this, 0) dot col(that, 1),
            row(this, 1) dot col(that, 0),
            row(this, 1) dot col(that, 1))
}

private fun usage() {
    err.println("Usage: fibs <n>")
    exit(2)
}

private fun IntArray.show() {
    out.println(Arrays.toString(this))
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

    val step : Int
    val m : IntArray
    if (n < 0) {
        step = -1
        m = ifib0
    } else {
        step = 1
        m = fib0
    }

    fib0.show()
    var fibn: IntArray = fib0
    while (n != 0) {
        fibn *= m
        fibn.show()
        n -= step
    }
}
