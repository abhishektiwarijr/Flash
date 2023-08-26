fun main() {
    val inp = "my name is sudhanshu"
    //Out - my aenm is uausdhnsh'
    val out = arrayListOf<String>()
    inp.split(" ").forEach { s ->
        var hasVowel = false
        var nsv = ""
        var nsc = ""
        s.forEach {
            if (it in "aeiou") {
                hasVowel = true
                nsv += it
                s.drop(s.indexOf(it))
            } else {
                nsc+=it
            }
        }
        if (hasVowel) {
            out.add(nsv+nsc)
        } else {
            out.add(nsc)
        }
    }
    println(out.joinToString(" "))
}