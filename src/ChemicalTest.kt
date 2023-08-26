import netscape.javascript.JSObject
import java.util.Stack

fun main(args: Array<String>) {
    val water = "H2O"
    parseMolecule(water) // return {H: 2, O: 1}

    val magnesiumHydroxide = "Mg(OH)2"
    parseMolecule(magnesiumHydroxide) // return {Mg: 1, O: 2, H: 2}

    val fremySalt = "K4[ON(SO3)2]2"
    parseMolecule(fremySalt) // return {K: 4, O: 14, N: 2, S: 4}
}

fun getAtoms(formula: String): Map<String, Int> {
    var str = formula
    val regex = Regex("""(\(\w+\)|\{\w+\}|\[\w+\])(\d*)""")
    while (regex.find(str) != null) {
        str = regex.replace(str) { it.groupValues[1].drop(1).dropLast(1).repeat(it.groupValues[2].toIntOrNull() ?: 1) }
    }
    if (str.any{it in "(){}[]"} || Regex("""[^A-Z][a-z]+""").find(str) != null)
        throw IllegalArgumentException()
    return Regex("""([A-Z][a-z]*)(\d*)""").findAll(str)
        .groupBy(keySelector={it.groupValues[1]},valueTransform={it.groupValues[2].toIntOrNull()?:1})
        .map{it.key to it.value.sum()}
        .toMap()
}

fun getAtoms2(formula: String): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    val numbers = mutableListOf(1)
    var atom = ""; var digit = ""

    if ("\\{\\w*[\\]\\)]|\\(\\w*[\\]\\}]|\\[\\w*[\\}\\)]".toRegex().containsMatchIn(formula) ||
        formula.replace("\\w".toRegex(), "").length % 2 != 0) throw IllegalArgumentException()

    for (char in formula.reversed()) {
        when {
            char == ')' || char == ']' || char == '}' -> { numbers.add(digit.toIntOrNull() ?: 1); digit = "" }
            char == '(' || char == '[' || char == '{' -> numbers.removeAt(numbers.lastIndex)
            char.isDigit() -> digit = "$char$digit"
            char.isLowerCase() -> atom = "$char$atom"
            char.isUpperCase() -> {
                atom = "$char$atom"
                val count = numbers.reduce(Int::times) * (digit.toIntOrNull() ?: 1)
                result[atom] = result[atom]?.let { it + count } ?: count
                atom = ""; digit = ""
            }
        }
    }
    return result.takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException()
}


fun parseMolecule(molecule: String) {
    println(getAtoms(molecule))
}