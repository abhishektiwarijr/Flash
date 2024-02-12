/**
 * Kotlin groupBy vs groupingBy
 *  Both groupBy & groupingBy help to group Collections and
 *  use selector as input parameter.
 *
 *  – groupBy:
 *      returns a Map object
 *      changes the values by valueTransform
 *      allows to pass a destination object to get mutable Map as result
 *
 *  – groupingBy:
 *      returns a Grouping object
 *      doesn’t have valueTransform, so it changes the values
 *      by Grouping method such as eachCount(), fold(), reduce(),
 *      aggregate() etc.
 *      doesn’t provide simple way to return a mutable Map
 */
fun main() {
    exampleGroupBy()
    exampleGroupByTo()
    exampleGroupingBy()
}

/**
 * groupingBy() groups items and apply an operation to all groups at one time,
 * then returns a Grouping object.
 *
 * For example, we use groupingBy() to get Grouping object, then:
 * – Grouping.eachCount() to count number of items corresponding to each group.
 * – Grouping.fold() to calculate total number of characters in each group.
 */
fun exampleGroupingBy() {
    val words = listOf("bezkoder", "zkoder", "kotlin", "programmingz", "bezcoder", "professional", "zcoder")
    println(words.groupBy { it.first() }) // {b=[bezkoder, bezcoder], z=[zkoder, zcoder], k=[kotlin], p=[programmingz, professional]}

    println(words.groupingBy { it.first() }.eachCount()) // {b=2, z=2, k=1, p=2}
    println(
        words.groupingBy {
            it.first()
        }.fold(0) { total, word ->
            total + word.length
        }
    ) // {b=16, z=12, k=6, p=24}
}

/**
 * groupByTo() is just like groupBy(),
 * but it also puts the result to the destination map.
 */
fun exampleGroupByTo() {
    val phoneToYear = listOf(
        "Nexus One" to 2010,
        "Pixel 2" to 2017,
        "Pixel 4a" to 2020,
        "iPhone 4" to 2010,
        "iPhone X" to 2017,
        "Galaxy Note 8" to 2017,
        "Galaxy S11" to 2020
    )

//    val phonesByYear = phoneToYear.groupBy({ it.second }, { it.first })
//    println(phonesByYear) // {2010=[Nexus One, iPhone 4], 2017=[Pixel 2, iPhone X, Galaxy Note 8], 2020=[Pixel 4a, Galaxy S11]}

//    phonesByYear[2020]?.add("iPhone 12") // compile error

    val phonesByYearMutable = LinkedHashMap<Int, MutableList<String>>()
    phoneToYear.groupByTo(phonesByYearMutable, { it.second }, { it.first })

    println(phonesByYearMutable) // {2010=[Nexus One, iPhone 4], 2017=[Pixel 2, iPhone X, Galaxy Note 8], 2020=[Pixel 4a, Galaxy S11]}

    //You can also do this because If you use groupBy(), you cannot modify the result:
    phonesByYearMutable[2020]?.add("iPhone 12")
    println(phonesByYearMutable[2020]) // [Pixel 4a, Galaxy S11, iPhone 12]
}

/**
 * groupBy() takes a selector and returns a Map.
 */
fun exampleGroupBy() {
    val words = listOf("bezkoder", "zkoder", "kotlin", "programmingz", "bezcoder", "professional", "zcoder")
    val byLength = words.groupBy { it.length }

    println(byLength) // {8=[bezkoder, bezcoder], 6=[zkoder, kotlin, zcoder], 12=[programmingz, professional]}
    println(byLength.keys) // [8, 6, 12]
    println(byLength.values) // [[bezkoder, bezcoder], [zkoder, kotlin, zcoder], [programmingz, professional]]

    val byFirstLetter = words.groupBy { it.first() }
    println(byFirstLetter) // {b=[bezkoder, bezcoder], z=[zkoder, zcoder], k=[kotlin], p=[programmingz, professional]}

    val byFirstLetterAndLength = words.groupBy({ it.first() }, { it.length })
    println(byFirstLetterAndLength) // {b=[8, 8], z=[6, 6], k=[6], p=[12, 12]}

    //Kotlin groupBy multiple keys

    data class Key(val letter: Char, val length: Int)

    fun String.toKey() = Key(this.first(), this.length)
    val byLastLetterAndLength = words.groupBy { it.toKey() }
    println(byLastLetterAndLength) // {Key(letter=b, length=8)=[bezkoder, bezcoder], Key(letter=z, length=6)=[zkoder, zcoder], Key(letter=k, length=6)=[kotlin], Key(letter=p, length=12)=[programmingz, professional]}
}
