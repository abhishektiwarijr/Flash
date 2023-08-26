fun main() {
    val nameExample = NameExample()
    val groupedNames = nameExample.names.groupBy { it[0] }
    groupedNames.forEach { (t, u) ->
        print("$t -> $u")
    }
    val sortedNames = nameExample.names.sorted()

    val sections = mutableMapOf<Char, MutableList<String>>()
    sortedNames.forEachIndexed { index, s ->
        val lookupChar = s.first()
        if (sections.containsKey(lookupChar)) {
            if (getMatchedChar(sections, lookupChar)) {
                sections[lookupChar] = mutableListOf(s)
            } else {
                sections[lookupChar]?.add(s)
                if (sections[lookupChar]!!.size == 5) {
                    return@forEachIndexed
                }
            }
        } else {
            sections[lookupChar] = mutableListOf(s)
        }
    }
    sections.forEach { (t, u) ->
        println("$t -> $u")
    }
}

private fun getMatchedChar(
    sections: MutableMap<Char, MutableList<String>>,
    firstChar: Char
): Boolean {
    var matched = false
    run breaker@{
        sections[firstChar]?.forEach { item ->
            if (item.first() == firstChar) {
                matched = true
                return@breaker
            }
        }
    }
    return matched
}

class NameExample {
    var names = arrayOf(
        "Liam",
        "Olivia",
        "Noah",
        "Emma",
        "Oliver",
        "Ava",
        "William",
        "Sophia",
        "Elijah",
        "Isabella",
        "James",
        "Charlotte",
        "Benjamin",
        "Amelia",
        "Lucas",
        "Mia",
        "Mason",
        "Harper",
        "Ethan",
        "Evelyn"
    )
}