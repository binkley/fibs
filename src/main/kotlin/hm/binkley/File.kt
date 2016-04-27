package hm.binkley

class File {
    private val v: Array<Fraction>

    constructor(a: Fraction, b: Fraction) {
        v = arrayOf(a, b)
    }

    infix fun dot(that: File): Fraction {
        return this.v[0] * that.v[0] + this.v[1] * that.v[1]
    }
}
