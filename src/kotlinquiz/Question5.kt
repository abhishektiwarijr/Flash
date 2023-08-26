package kotlinquiz


//Does Kotlin supports extension properties? Yes, Kotlin supports extension properties. Ex:

val <T> List<T>.lastIndex: Int
    get() = size - 1
