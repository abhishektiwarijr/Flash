val digitBlocks = mutableListOf<Long>()

fun main() {
//    test()
//    println(buildSequence(0))

//    println(solve(1L)) //1
//    println(solve(2L)) //1
//    println(solve(3L)) //2
//    println(solve(15L)) //5
    println(solve(100L)) //1
//    println(solve(2100L)) //2
//    println(solve(31000L)) //2
//    println(solve(999999999999999999L)) //4
//    println(solve(1000000000000000000L)) //1
//    println(solve(999999999999999993L)) //7
}

data class BlockData(val range: LongRange, val maxValue: Long)

fun solve(n: Long): Int {
    var cn = n
    //preparing digit blocks
    val digitBlocks = mutableListOf<BlockData>()
    var x = 0L
    var l0 = 0L
    var sum = 0L
    for (i in 0..8) {
        val f0 = x + (1L * (i + 1))
        val pow = Math.pow(10.0, i.toDouble()).toLong()
        l0 += 9L * pow * (i + 1)
        val avg0: Double = (f0 + l0) / 2.0
        x = l0
        sum += pow * 9L
        digitBlocks.add(BlockData(pow..sum, ((avg0 * 9L * pow).toLong())))
    }

    //check in which block it exist
    var digitBlock = 0
    for (i in digitBlocks) {
        if (n <= i.maxValue) {
            digitBlock = digitBlocks.indexOf(i)
            break
        }
    }

    //subtract till that block
    for (i in digitBlock downTo 0) {
        cn -= digitBlocks[i].maxValue
    }

    val block = digitBlocks[digitBlock]
    var lb = block.range.first
    var ub = block.range.last


    var sn0 = 0L
    var m = 0
    while (cn > 1) {
        cn /= 10
        val pow = Math.pow(10.0, m.toDouble()).toLong()
        sn0 += 9L * pow * (m + 1)
        m++
    }
    m++
    sn0 += m

    println(sn0)
    return sn0.toInt()

//    for (i in 1..lb.toString().length) {
//        1 = (9 * 0 + 1 * 1)
//        10 = (9 * 1 + 1 * 2)
//        100 = (9 * 1 + 90 * 2 + 1 * 3)
//        1000 = (9 * 1 + 90 * 2 + 900 * 3 + 1 * 4)
//        10000 = (9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 1 * 5)

//    }

//    first: 10 (sequence length: 9 * 1 + 1 * 2)
//    last: 99 (sequence length: 9 * 1 + 90 * 2)
//    average sequence length: 9 + (2 + 180) / 2 = 100
//    2-digit block length: 90 * 100 = 9000


//    2055


//    first: 10 (sequence length: 9 * 1 + 1 * 2)
//    last: 50 (sequence length: 9 * 1 + 41 * 2)
//    average sequence length: 9 + (2 + 72) / 2 = 51
//    2-digit block length: 40 * 50 = 2000
//    2-digit block length: 41 * 51 = 2091
//    2091



//    first: 100 (sequence length: 9 * 1 + 90 * 2 + 1 * 3)
//    number: 999 (sequence length: 9 + 180 + 900 * 3)
//    average sequence length: 9 + 180 + (3 + 2700) / 2 = 1540.5
//    3-digit block length: 900 * 1540.5 = 1386450


//    var s = 0L
//    for (i in 0..digitBlock) {
//        s += digitBlocks[i]
//    }

//    val result = StringBuilder()
//    return if (digitBlock == 0) {
//        for (i in 1..9) {
//            var a = 1
//            while (a <= i) {
//                result.append(a)
//                a++
//            }
//        }
//        result[n.toInt() - 1].toString().toInt()
//    } else {
//        for (i in 10..99) {
//            var a = 1
//            while (result.length <= n && a <= i) {
//                result.append(a)
//                a++
//            }
//        }
//        result[n.toInt() - 46].toString().toInt()
//    }
}

fun binarySearch(nums: IntRange, target: Long): Long {
    var lb: Long = nums.first.toLong()
    var ub: Long = nums.last.toLong()

    while (lb <= ub) {
        val mid: Long = lb + (ub - lb) / 2
        if (mid == target) {
            return mid
        }

        if (mid < target) {
            lb = mid + 1L
        } else {
            ub = mid - 1L
        }
    }
    return -1L
}

fun test() {
    val f1: Long = 1 * 1 //1
    val l1: Long = 9 * 1 //9
    val avg1: Double = (f1 + l1) / 2.0
    val digitBlock1: Long = (9 * avg1).toLong()

    val f2: Long = 9 * 1 + 1 * 2 //10
    val l2: Long = 9 * 1 + 90 * 2 //99
    val avg2: Double = (f2 + l2) / 2.0
    val digitBlock2: Long = (avg2 * 90).toLong()

    val f3: Long = 9 * 1 + 90 * 2 + 1 * 3 //100
    val l3: Long = 9 * 1 + 90 * 2 + 900 * 3 //999
    val avg3: Double = (f3 + l3) / 2.0
    val digitBlock3: Long = (avg3 * 900).toLong()

    val f4: Long = 9 * 1 + 90 * 2 + 900 * 3 + 1 * 4 //1000
    val l4: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4//9999
    val avg4: Double = (f4 + l4) / 2.0
    val digitBlock4: Long = (avg4 * 9000).toLong()

    val f5: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 1 * 5 //10000
    val l5: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 //99999
    val avg5: Double = (f5 + l5) / 2.0
    val digitBlock5 = (avg5 * 90000L).toLong()

    val f6: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 1 * 6 //100000
    val l6: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 //999999
    val avg6: Double = (f6 + l6) / 2.0
    val digitBlock6 = (avg6 * 900000L).toLong()

    val f7: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 1 * 7 //1000000
    val l7: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 9000000 * 7 //9999999
    val avg7: Double = (f7 + l7) / 2.0
    val digitBlock7 = (avg7 * 9000000L).toLong()

    val f8: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 9000000 * 7 + 1 * 8 //10000000
    val l8: Long = 9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 9000000 * 7 + 90000000 * 8 //99999999
    val avg8: Double = (f8 + l8) / 2.0
    val digitBlock8 = (avg8 * 90000000L).toLong()

    val f9: Long =
        9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 9000000 * 7 + 90000000 * 8 + 1 * 9 //100000000
    val l9: Long =
        9 * 1 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 + 9000000 * 7 + 90000000 * 8 + 900000000L * 9 //999999999
    val avg9: Double = (f9 + l9) / 2.0
    val digitBlock9 = (avg9 * 900000000L).toLong()


    val digitBlocksN = mutableMapOf<LongRange, Long>()
    var x = 0L
    var f0: Long
    var l0 = 0L
    var s = 0L
    for (i in 0..8) {
        f0 = x + (1L * (i + 1))
        val pow = Math.pow(10.0, i.toDouble()).toLong()
        l0 += 9L * pow * (i + 1)
        val avg0: Double = (f0 + l0) / 2.0
        x = l0
        s += pow * 9L
        digitBlocksN[pow..s] = ((avg0 * 9L * pow).toLong())
    }
    digitBlocksN.forEach {
        println("${it.key} ==> ${it.value}")
    }

//    first: 100 (sequence length: 9 + 180 + 1 * 3)
//    number: 999 (sequence length: 9 + 180 + 900 * 3)
//    average sequence length: 9 + 180 + (3 + 2700) / 2 = 1540.5
//    3-digit block length: 900 * 1540.5 = 1386450
//
//

    15L
//    first: 1 (sequence length: 1 * 1)
//    last: 9 (sequence length: 9 * 1)
//    average sequence length: (1 + 9) / 2 = 5
//    1-digit block length: 9 * 5 = 45

//    first: 1 (sequence length: 1 * 1)
//    last: 5 (sequence length: 5 * 1)
//    average sequence length: (1 + 5) / 2 = 3
//    1-digit block length: 5 * 3 = 15

//    val mid : Long = lb + (ub - lb) / 2


//    first: 10 (sequence length: 9 * 1 + 1 * 2)
//    last: 46 (sequence length: 9 * 1 + 37 * 2)
//    average sequence length: 9 + (2 + 180) / 2 = 100
//    2-digit block length: 42 * 100 = 2162

//    first: 10 (sequence length: 9 * 1 + 1 * 2)
//    last: 45 (sequence length: 9 * 1 + 36 * 2)
//    average sequence length: 9 + (2 + 180) / 2 = 100
//    2-digit block length: 45 * 46 = 2070


    30

//
//    31000L
//
//    first: 100 (sequence length: 9 + 180 + 1 * 3)
//    number: 999 (sequence length: 9 + 180 + 900 * 3)
//    average sequence length: 9 + 180 + (3 + 2700) / 2 = 1540.5
//    3-digit block length: 900 * 1540.5 = 1386450
//
//    first: 100 (sequence length: 9 + 180 + 1 * 3)
//    number: 999 (sequence length: 9 + 180 + 900 * 3)
//    average sequence length: 9 + 180 + (3 + 2700) / 2 = 1540.5
//    3-digit block length: 900 * 1540.5 = 1386450


    digitBlocks.add(digitBlock1) //1-9 = 45
    digitBlocks.add(digitBlock2) //10-99 = 9000
    digitBlocks.add(digitBlock3) //100-999 = 1,386,450
    digitBlocks.add(digitBlock4) //1000-9999 =
    digitBlocks.add(digitBlock5) //10000-99999
    digitBlocks.add(digitBlock6) //100000-999999
    digitBlocks.add(digitBlock7) //1000000-9999999
    digitBlocks.add(digitBlock8) //10000000-99999999
    digitBlocks.add(digitBlock9) //100000000-999999999
}

fun buildSequence(index: Int): String {
    var result = ""
    for (i in 1..16) {
        result += i
    }
    return result.length.toString()
}
