package hm.binkley

import java.util.*

class Q {
    private val m: Array<Fraction>

    constructor(a: Fraction, b: Fraction, c: Fraction, d: Fraction) {
        m = arrayOf(a, b, c, d)
    }

    fun row(i: Int): File {
        val offset = 2 * i
        return File(m[0 + offset], m[1 + offset])
    }

    fun col(j: Int): File {
        return File(m[0 + j], m[2 + j])
    }

    operator fun times(that: Q): Q {
        return Q(this.row(0) dot that.col(0),
                this.row(0) dot that.col(1),
                this.row(1) dot that.col(0),
                this.row(1) dot that.col(1))
    }

    override fun toString(): String {
        return Arrays.toString(this.m)
    }
}
