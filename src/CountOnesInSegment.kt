import kotlin.system.measureTimeMillis

object Kata {
    @JvmStatic
    private val wordBits = LongArray(65536)

    init {
        for (i in 0..0xFFFF) {
            var cn = i
            var count = 0L
            while (count < cn) {
                cn = cn and (cn - 1)
                count++
            }
            wordBits[i] = count
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val tests = listOf<Pair<Long, Long>>(
            Pair(4250829, 231192380),
            Pair(4274934, 111537765),
            Pair(143852667, 147469842),
            Pair(269441501, 911165194),
            Pair(116087765, 142757035),
            Pair(155324915, 869470125),
            Pair(7201509, 8936988),
            Pair(111972748, 275373744),
            Pair(140503910, 350322228),
            Pair(799572077, 960709860),
            Pair(415301119, 771151433)
        )

        val time = measureTimeMillis {
            for (test in tests) {
                countOnesEff(test.first, test.second)
            }
        }
        println("Time $time")
    }

    fun main() {
//        println(countOnes(4, 7))
//        println(countOnes(5, 7))
//        println(countOnes(12, 29))
        val tests = listOf<Pair<Long, Long>>(
            Pair(4250829, 231192380),
            Pair(4274934, 111537765),
            Pair(143852667, 147469842),
            Pair(269441501, 911165194),
            Pair(116087765, 142757035),
            Pair(155324915, 869470125),
            Pair(7201509, 8936988),
            Pair(111972748, 275373744),
            Pair(140503910, 350322228),
            Pair(799572077, 960709860),
            Pair(415301119, 771151433)
        )

        val time = measureTimeMillis {
            for (test in tests) {
                countOnesEff(test.first, test.second)
            }
        }
        println("Time $time")
    }

    fun countOnes(left: Long, right: Long): Long {
        var sum = 0L
        for (i in left..right) {
            sum += count(i)
        }
        return sum
    }

    fun countOnesEff(left: Long, right: Long): Long {
        fun count(n: Long): Long {
            if (n <= 0) return 0
            val k = 63 - java.lang.Long.numberOfLeadingZeros(n)
            val t = 1L shl k
            return k * t / 2 + (n - t + 1) + count(n - t)
        }
        return count(right) - count(left - 1)
    }

    const val m1: Long = 0x5555555555555555
    const val m2: Long = 0x3333333333333333
    const val m4: Long = 0x0f0f0f0f0f0f0f0f
    const val m8: Long = 0x00ff00ff00ff00ff
    const val m16: Long = 0x0000ffff0000ffff
    const val m32: Long = 0x00000000ffffffff
    const val h01: Long = 0x0101010101010101

    fun count(n: Long): Long {
        val x = n.toInt()
        return (wordBits[x and 0xFFFF] + wordBits[x shr 16])

        var cn = n
        var count = 0L
        while (count < cn) {
            cn = cn and (cn - 1)
            count++
        }
        return count
//        var x = n
//        x = (x and m1) + (x shr 1 and m1) //put count of each  2 bits into those  2 bits
//        x = (x and m2) + (x shr 2 and m2) //put count of each  4 bits into those  4 bits
//        x = (x and m4) + (x shr 4 and m4) //put count of each  8 bits into those  8 bits
//        x = (x and m8) + (x shr 8 and m8) //put count of each 16 bits into those 16 bits
//        x = (x and m16) + (x shr 16 and m16) //put count of each 32 bits into those 32 bits
//        x = (x and m32) + (x shr 32 and m32) //put count of each 64 bits into those 64 bits
//        return x
//    cn -= cn shr 1 and m1
//    cn = (cn and m2) + (cn shr 2 and m2)
//    cn = cn + (cn shr 4) and m4
//    return cn * h01 shr 56
//
//        var count = 0L
//        while (count < cn) {
//            cn = cn and (cn - 1)
//            count++
//        }
//        return count
    }
}