package hm.binkley

class Q(val a: Int, val b: Int, val c: Int, val d: Int) {
    companion object {
        val fib0 = Q(0, 1, 1, 1)
    }

    fun trace() = a + d

    fun det() = a * d + b * c

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

    operator fun inc() = Q(b, d, d, b + d)

    operator fun dec() = Q(b - a, a, a, b)

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
