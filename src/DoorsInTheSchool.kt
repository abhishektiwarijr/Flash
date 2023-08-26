import kotlin.math.roundToInt

fun main() {
    println(doors(5))
    println(doors(10))
    println(doors(100))
//    println(doors(100000))
}

fun doors(n: Int): Int {
    val doors = BooleanArray(n) { false }

    for (i in 0 until  n) {
        for (j in i until n step (i+1)) {
            doors[j] = doors[j].not()
        }
    }

    return doors.count { it }
}

fun doorsEff(n: Int)=Math.sqrt(n.toDouble()).toInt()

// It can mathematically be proven that only (x^2)-th student leave the door finally open.
// Note that i-th door state does not change any more after the i-th student comes to school.
fun doorsEff2(n: Int): Int = Math.floor(Math.sqrt(n.toDouble())).roundToInt()

fun doorsEff3(n: Int): Int {
    val doorsOpen = Array(n){false}
    repeat(n){s->for (i in s until n step s+1) doorsOpen[i] = !doorsOpen[i]}
    return doorsOpen.filter{it}.size
}