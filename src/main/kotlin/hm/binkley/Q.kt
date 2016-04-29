package hm.binkley

import java.util.*

class Q {
    companion object {
        val fib0 = Q(Fraction(0), Fraction(1), Fraction(1), Fraction(1))
    }

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

    fun trace(): Fraction {
        return a + d;
    }

    fun det(): Fraction {
        return a * d + b * c
    }

    operator fun get(i: Int, j: Int): Fraction {
        return when (i) {
            0 -> when (j) {
                0 -> a
                1 -> b
                else -> {
                    throw IndexOutOfBoundsException(i.toString())
                }
            }
            1 -> when (j) {
                0 -> c
                1 -> d
                else -> {
                    throw IndexOutOfBoundsException(i.toString())
                }
            }
            else -> {
                throw IndexOutOfBoundsException(i.toString())
            }
        }
    }

    operator fun inc(): Q {
        return Q(b, d, d, b + d)
    }

    operator fun dec(): Q {
        return Q(b - a, a, a, b)
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
