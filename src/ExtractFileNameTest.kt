fun main() {
 println(extractFileNameEff2("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION"))
 println(extractFileNameEff2("1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34"))
 println(extractFileNameEff2("1231231223123131_myFile.tar.gz2"))
}

fun extractFileName(dirtyFileName: String): String {
//    .replace("(?:.*/)?([^/]+?|)(?=(?:\\.[^/.]*)?\$)".toRegex(), "")
    return dirtyFileName.replace("^([^_]+)_".toRegex(), "").substringBeforeLast(".")
}

fun extractFileNameEff(dirtyFileName: String) = dirtyFileName.substringAfter("_").substringBeforeLast(".")
fun extractFileNameEff2(dirtyFileName: String) = Regex("""^\d+_(?<fileName>.*)\..+$""").matchEntire(dirtyFileName)!!.groups["fileName"]!!.value
