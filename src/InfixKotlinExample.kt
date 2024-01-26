/**
 * Infix Notation
 * 1. They must have a single parameter.
 * 2. The parameter must not accept a variable number of arguments.
 * 3. The parameter must not have a default value.
 *
 * Infix notation makes code more natural and readable,
 * resembling everyday language and improving the expressiveness
 * of certain operations.
 */

fun main() {
    val sum = 5 add 3

    val jack = PersonX("Jack")
    val jill = PersonX("Jill")

    //Looks cool right?
    jack befriend jill

    val defaultSetting = GameSettings()
    val hardLevelSetting = GameSettings().apply {
        difficulty = "Hard"
        graphicsQuality = "High"
    }

    val finalSettings = defaultSetting configure hardLevelSetting
    println("Final Game Settings:")
    println("Difficulty: ${finalSettings.difficulty}")
    println("Graphics Quality: ${finalSettings.graphicsQuality}")
}

infix fun Int.add(input : Int) : Int = this + input


class PersonX(val name : String) {
    infix fun befriend(other : PersonX) {
        println("$name is now friends with ${other.name}")
    }
}

data class GameSettings(
    var difficulty : String = "Easy",
    var graphicsQuality : String = "Normal"
)

infix fun GameSettings.configure(settings: GameSettings) : GameSettings {
    return GameSettings(
        difficulty = settings.difficulty,
        graphicsQuality = settings.graphicsQuality
    )
}