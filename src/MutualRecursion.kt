fun main() {
    println(checkF(0, 1))
    println(checkF(5, 3))
    println(checkF(10, 6))
    println(checkF(15, 9))
    println(checkF(25, 16))

    println(checkM(0, 0))
    println(checkM(5, 3))
    println(checkM(10, 6))
    println(checkM(15, 9))
    println(checkM(25, 16))
}

fun checkF(input : Int, shouldBe : Int) = assertEquals(f(input), shouldBe)

fun assertEquals(f: Int, shouldBe: Int): Boolean {
    return f == shouldBe
}

fun checkM(input : Int, shouldBe : Int) = assertEquals(m(input), shouldBe)

fun f(n : Int) : Int {
    if(n == 0) return 1
    return n - m(f(n-1))
}

fun m(n : Int) : Int {
    if(n == 0) return 0
    return n - f(m(n-1))
}

fun fEff(n : Int) : Int = if (n == 0) 1 else n - mEff(fEff(n - 1))
fun mEff(n : Int) : Int = if (n == 0) 0 else n - fEff(mEff(n - 1))
