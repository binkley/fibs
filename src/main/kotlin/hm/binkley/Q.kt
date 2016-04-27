package hm.binkley

import java.util.*

class Q {
    private val a: Fraction
    private val b: Fraction
    private val c: Fraction
    private val d: Fraction

    constructor(a: Fraction, b: Fraction, c: Fraction, d: Fraction) {
        this.a = a
        this.b = b
        this.c = c
        this.d = d
    }

    fun row(i: Int): File {
        return if (0 == i) File(a, b) else File(c, d)
    }

    fun col(j: Int): File {
        return if (0 == j) File(a, c) else File(b, d)
    }

    operator fun times(that: Q): Q {
        return Q(this.row(0) dot that.col(0),
                this.row(0) dot that.col(1),
                this.row(1) dot that.col(0),
                this.row(1) dot that.col(1))
    }

    override fun toString(): String {
        return Arrays.toString(arrayOf(a, b, c, d))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Q

        if (a != other.a) return false
        if (b != other.b) return false
        if (c != other.c) return false
        if (d != other.d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result += 31 * result + b.hashCode()
        result += 31 * result + c.hashCode()
        result += 31 * result + d.hashCode()
        return result
    }
}
