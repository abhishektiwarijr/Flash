package kotlinquiz

//Is it allowed to create an extension function for a nullable receiver type? Ex:

fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

//Yes, it is allowed.