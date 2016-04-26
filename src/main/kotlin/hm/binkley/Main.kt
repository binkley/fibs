package hm.binkley

import java.lang.System.err
import java.lang.System.exit
import java.lang.System.out
import java.util.*

private class Fraction {
    val n: Int
    val d: Int

    constructor(n: Int, d: Int) {
        val gcd = gcd(n, d)
        this.n = n / gcd
        this.d = d / gcd
    }

    constructor(n: Int) : this(n, 1)

    override fun toString(): String {
        return if (1 != d) "%d/%d".format(n, d) else n.toString()
    }

    private fun gcd(p: Int, q: Int): Int {
        return if (0 == q) p else gcd(q, p % q)
    }
}

private operator fun Fraction.plus(that: Fraction): Fraction {
    return Fraction(this.n * this.d + that.n * that.d, this.d * that.d)
}

private operator fun Fraction.times(that: Fraction): Fraction {
    return Fraction(this.n * that.n, this.d * that.d)
}

private val fib0: Array<Fraction> = arrayOf(Fraction(0), Fraction(1),
        Fraction(1), Fraction(1))
private val ifib0: Array<Fraction> = arrayOf(Fraction(-1), Fraction(1),
        Fraction(1), Fraction(0))

private fun row(a: Array<Fraction>, i: Int): Array<Fraction> {
    val offset = 2 * i
    return arrayOf(a[0 + offset], a[1 + offset])
}

private fun col(a: Array<Fraction>, j: Int): Array<Fraction> {
    return arrayOf(a[0 + j], a[2 + j])
}

private infix fun Array<Fraction>.dot(that: Array<Fraction>): Fraction {
    return this[0] * that[0] + this[1] * that[1]
}

private operator fun Array<Fraction>.times(
        that: Array<Fraction>): Array<Fraction> {
    return arrayOf(row(this, 0) dot col(that, 0),
            row(this, 0) dot col(that, 1),
            row(this, 1) dot col(that, 0),
            row(this, 1) dot col(that, 1))
}

private fun usage() {
    err.println("Usage: fibs <n>")
    exit(2)
}

private fun Array<Fraction>.show() {
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

    val step: Int
    val m: Array<Fraction>
    if (n < 0) {
        step = -1
        m = ifib0
    } else {
        step = 1
        m = fib0
    }

    fib0.show()
    var fibn: Array<Fraction> = fib0
    while (n != 0) {
        fibn *= m
        fibn.show()
        n -= step
    }
}
