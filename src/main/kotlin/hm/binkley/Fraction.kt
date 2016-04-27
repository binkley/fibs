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

    operator fun plus(that: Fraction): Fraction {
        return Fraction(this.n * this.d + that.n * that.d,
                this.d * that.d)
    }

    operator fun times(that: Fraction): Fraction {
        return Fraction(this.n * that.n, this.d * that.d)
    }

    override fun toString(): String {
        return if (1 != d) "%d/%d".format(n, d) else n.toString()
    }

    private fun gcd(p: Int, q: Int): Int {
        return if (0 == q) p else gcd(q, p % q)
    }
}
