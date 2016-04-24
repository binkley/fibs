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

private fun dot(a: IntArray, b: IntArray): Int {
    return a[0] * b[0] + a[1] * b[1]
}

private fun mult(a: IntArray, b: IntArray): IntArray {
    return intArrayOf(dot(row(a, 0), col(b, 0)),
            dot(row(a, 0), col(b, 1)),
            dot(row(a, 1), col(b, 0)),
            dot(row(a, 1), col(b, 1)))
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
        fibn = mult(fibn, fib0)
        out.println(Arrays.toString(fibn))
    }
}
