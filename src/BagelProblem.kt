import java.lang.reflect.Field
import java.lang.reflect.Modifier

class Bagel {
    val value: Int get() = 3
}

fun main() {
    println(bagel.value)
}

val bagel: Bagel
    get() {
        try {
            val f = java.lang.Boolean::class.java.getField("TRUE")
            val modifiers = Field::class.java.getDeclaredField("modifiers")
            modifiers.isAccessible = true
            modifiers.setInt(f, f.modifiers and Modifier.FINAL.inv())
            f[null] = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Bagel()
    }