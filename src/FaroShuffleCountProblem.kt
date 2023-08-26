fun main() {
    println(faroCycles(8)) //3
    println(faroCycles(52)) //8
    println(faroCycles(2)) //1
    println(faroCycles(30)) //28
}

fun faroCycles(deckSize: Int): Int {
//    1. Leave first and last card
//    2. Divide remaining cards into 2 decks
//    3. Merge the two decks picking alternatively one card from each, starting with the first deck.

    val originalList = (1..deckSize).map { it }
    val list = originalList.toMutableList()

    val m = (deckSize - 2) / 2
    val merged = mutableListOf<Int>()
    var count = 0

    while (merged != originalList) {
        if (merged.isNotEmpty()) {
            list.clear()
            list.addAll(merged)
        }
        merged.clear()
        for (i in 1..m) {
            merged.add(list[m + i])
            merged.add(list[i])
        }
        merged.add(0, 1)
        merged.add(merged.size, deckSize)
        count++
    }

    return count
}

fun faroCyclesEff(m: Int): Int {
    var k = 0
    var n = 1
    while (n!=1 || k==0) {
        k += 1
        n = (m * (n%2) + n) shr 1
    }
    return k
}


fun faroCyclesEff2(deckSize: Int): Int {
    var counter = 0
    val list = (1..deckSize).toList()
    var shuffledList = list

    do {
        shuffledList = faroShuffle(shuffledList)
        counter++
        if(counter > 2000) break
    } while(list != shuffledList)

    return counter
}
private fun faroShuffle(list: List<Int>) : List<Int>{
    val first = list.subList(0, (list.size + 1) / 2)
    val second = list.subList((list.size + 1) / 2, list.size)
    val shuffledList = mutableListOf<Int>()
    for (i in first.indices){
        shuffledList.add(first[i])
        shuffledList.add(second[i])
    }
    return shuffledList
}
