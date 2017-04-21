package hm.binkley

class Q private constructor(val a: Int, val b: Int, val c: Int, val d: Int,
        val n: Int) {
    companion object {
        /** The 0th Fibonacci */
        val fib0 = Q(0, 1, 1, 1, 0)
    }

    operator fun invoke(n: Int): Q {
        val limit: Int
        val next: (Q) -> Q
        if (n < 0) {
            next = Q::dec
            limit = -n + 1
        } else {
            next = Q::inc
            limit = n + 1
        }
        return generateSequence(fib0) { next(it) }.
                take(limit).
                last()
    }

    /** The trace of Q */
    fun trace() = a + d

    /** The determinant of Q */
    fun det() = a * d + b * c

    /** Gets the element at position <var>i</var> and <var>j</var>. */
    operator fun get(i: Int, j: Int) = when (i) {
        0 -> when (j) {
            0 -> a
            1 -> b
            else -> throw IndexOutOfBoundsException(i.toString())
        }
        1 -> when (j) {
            0 -> c
            1 -> d
            else -> throw IndexOutOfBoundsException(i.toString())
        }
        else -> throw IndexOutOfBoundsException(i.toString())
    }

    /** Gets tne following Fibonacci. */
    operator fun inc() = Q(b, d, d, b + d, n + 1)

    /** Gets the preceding Fibonacci. */
    operator fun dec() = Q(b - a, a, a, b, n - 1)

    fun pow(n: Int): Q {
        throw UnsupportedOperationException()
    }

    /** Primitive representation of the array */
    override fun toString() = "[ $a $b\n  $c $d ]"

    override fun equals(other: Any?) = when {
        this === other -> true
        other?.javaClass != javaClass -> false
        else -> {
            other as Q
            when {
                a != other.a -> false
                b != other.b -> false
                c != other.c -> false
                d != other.d -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result += 31 * result + b.hashCode()
        result += 31 * result + c.hashCode()
        result += 31 * result + d.hashCode()
        return result
    }
}
