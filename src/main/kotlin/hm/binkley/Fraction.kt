package hm.binkley

class Fraction {
    val n: Int
    val d: Int

    constructor(n: Int, d: Int) {
        val gcd = gcd(n, d)
        this.n = n / gcd
        this.d = d / gcd
    }

    constructor(n: Int) : this(n, 1)

    operator fun get(i: Int): Int {
        return when (i) {
            0 -> n
            1 -> d
            else -> {
                throw IndexOutOfBoundsException(i.toString())
            }
        }
    }

    operator fun plus(that: Fraction): Fraction {
        return Fraction(n * d + that.n * that.d, d * that.d)
    }

    operator fun minus(that: Fraction): Fraction {
        return Fraction(n * d - that.n * that.d, d * that.d)
    }

    operator fun times(that: Fraction): Fraction {
        return Fraction(n * that.n, d * that.d)
    }

    override fun toString(): String {
        return if (1 != d) "%d/%d".format(n, d) else n.toString()
    }

    private fun gcd(p: Int, q: Int): Int {
        return if (0 == q) p else gcd(q, p % q)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Fraction

        if (n != other.n) return false
        if (d != other.d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result += 31 * result + d
        return result
    }
}
