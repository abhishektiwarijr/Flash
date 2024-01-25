fun main() {
    val degree = Degree(8.0)
    val degree2 = Degree(8.0, 0.0)
}

@JvmInline
value class Degree(val value: Double) {

    constructor(e : Double, m : Double) : this(e + m) {
        require(m > 0.0) {
            "m shouldn't be 0"
        }
    }

    fun toRadians(): Double = Math.toRadians(value)
    fun toRotations(): Double = value / 360.0
    fun sin(): Double = Math.sin(toRadians())
    fun cos(): Double = Math.cos(toRadians())
    fun tan(): Double = Math.tan(toRadians())
    fun cot(): Double = 1.0 / tan()
    fun sec(): Double = 1.0 / cos()
    fun csc(): Double = 1.0 / sin()
}
