import kotlin.system.measureTimeMillis

fun main() {
    val t = measureTimeMillis {
        preventLongGCRun()
    }
    print(t)
}

fun preventLongGCRun() {
    var i = 0
    while (i < 1_00_00_000L) {
        //business logic

        //prevent long gc
//        if (i % 3000 == 0) {
//            try {
//                Thread.sleep(0)
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//        }
        i++
    }
}
