package test

fun main() {
    val fruits = listOf(
        "Apple",
        "Apricot",
        "Avocado",
        "Banana",
        "Bilberry",
        "Blackberry",
        "Blackcurrant",
        "Blueberry",
        "Boysenberry",
        "Currant",
        "Cherry",
        "Cherimoya",
        "Chico fruit",
        "Cloudberry",
        "Coconut",
        "Cranberry",
        "Cucumber",
        "Custard apple",
        "Damson",
        "Date",
        "Dragonfruit",
        "Durian",
        "Elderberry",
        "Feijoa",
        "Fig",
        "Goji berry",
        "Gooseberry",
        "Grape",
        "Raisin",
        "Grapefruit",
        "Guava",
        "Honeyberry",
        "Huckleberry",
        "Jabuticaba",
        "Jackfruit",
        "Jambul",
        "Jujube",
        "Juniper berry",
        "Kiwano",
        "Kiwifruit",
        "Kumquat",
        "Lemon",
        "Lime",
        "Loquat",
        "Longan",
        "Lychee",
        "Mango",
        "Mangosteen",
        "Marionberry",
        "Melon",
        "Cantaloupe",
        "Honeydew",
        "Watermelon",
        "Miracle fruit",
        "Mulberry",
        "Nectarine",
        "Nance",
        "Olive",
        "Orange",
        "Blood orange",
        "Clementine",
        "Mandarine",
        "Tangerine",
        "Papaya",
        "Passionfruit",
        "Peach",
        "Pear",
        "Persimmon",
        "Physalis",
        "Plantain",
        "Plum",
        "Prune",
        "Pineapple",
        "Plumcot",
        "Pomegranate",
        "Pomelo",
        "Purple mangosteen",
        "Quince",
        "Raspberry",
        "Salmonberry",
        "Rambutan",
        "Redcurrant",
        "Salal berry",
        "Salak",
        "Satsuma",
        "Soursop",
        "Star fruit",
        "Solanum quitoense",
        "Strawberry",
        "Tamarillo",
        "Tamarind",
        "Ugli fruit",
        "Yuzu"
    )
    val destination = LinkedHashMap<String, MutableList<String>>()
    for (element in fruits) {
        val key = element.first().toString()
        val list = destination.getOrPut(key) { ArrayList<String>() }
        list.add(element)
    }

//    val map = hashMapOf<String, ArrayList<String>>()
//    fruits.forEach {
//        val first = it.first()
//        fruits.forEach { a ->
//            if (a.first() == first) {
//                if (first.toString() in map.keys) {
//                    val list: ArrayList<String> = map.get(first.toString())!!
//                    list.add(a)
//                    map.put(first.toString(), list)
//                } else {
//                    val list = ArrayList<String>()
//                    list.add(a)
//                    map.put(first.toString(), list)
//                }
//            }
//        }
//
//    }
    println(destination.toString())
}