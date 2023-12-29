import java.util.ArrayDeque
import java.util.Deque

fun main() {
    println(validParenthesis(expr = "{[()]}"))
}

fun validParenthesis(expr: String): Boolean {
    val stack = ArrayDeque<Char>()
    val openingBrackets = setOf<Char>('(', '{', '[')
    val closingBracketsMap = mapOf<Char, Char>(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (ch in expr) {
        when (ch) {
            in openingBrackets -> stack.push(ch)
            in closingBracketsMap.keys -> {
                if(stack.isEmpty() || stack.pop() != closingBracketsMap[ch]) {
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}
