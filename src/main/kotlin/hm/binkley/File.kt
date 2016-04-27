package hm.binkley

import java.util.*

data class File(val a: Fraction, val b: Fraction) {
    infix fun dot(that: File): Fraction {
        return this.a * that.a + this.b * that.b
    }

    override fun toString(): String {
        return Arrays.toString(arrayOf(a, b))
    }
}
