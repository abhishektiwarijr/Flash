package generics

import java.io.Serializable

open class Animal : Serializable {
    open fun makeNoise() {
        println("make noise..!")
    }
}