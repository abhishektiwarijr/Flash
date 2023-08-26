package solid

interface DoSomething {
    fun doSomething()
}

class A : DoSomething {
    override fun doSomething() {
        println("Doing something")
    }
}

class B {
    private var doSomething: DoSomething? = null

    fun doIt(doSomething: DoSomething) {
        this.doSomething = doSomething
        doSomething.doSomething()
    }
}

fun main() {
    val b = B()
    b.doIt(A())
}