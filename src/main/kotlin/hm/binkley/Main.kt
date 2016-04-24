package hm.binkley

import java.lang.System.err
import java.lang.System.exit
import java.lang.System.out
import java.util.*

private val fib0: IntArray = intArrayOf(0, 1, 1, 1)

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

fun main(args: Array<String>) {
    var n: Int
    when (args.size) {
        1 -> n = args[0].toInt()
        else -> {
            err.println("Usage: X n")
            exit(2)
            n = -1 // TODO: Fake
        }
    }

    if (n < 0) {
        err.println("Usage: X n")
        exit(2)
    }

    out.println(Arrays.toString(fib0))
    var fibn: IntArray = fib0
    while (n-- > 0) {
        fibn *= fib0
        out.println(Arrays.toString(fibn))
    }
}
