package delegation

import kotlin.properties.Delegates

fun main() {

    //Observable Delegate Test
    val observableDelegateUseCase = ObservableUseCases()
    observableDelegateUseCase.points = 12
    observableDelegateUseCase.points = 20

    //Vetoable Delegation Test
    val vetoableDelegationUseCase = VetoableUseCases()
    vetoableDelegationUseCase.age = 12
    println(vetoableDelegationUseCase.age)
    vetoableDelegationUseCase.age = 21
    println(vetoableDelegationUseCase.age)
    vetoableDelegationUseCase.age = 40
    println(vetoableDelegationUseCase.age)

    //If you want to initialize the age property later(not at the time of object construction)
    // and want it as non-null then use this delegate
    //Trying to read the property before the initial value
    // has been assigned results in an exception.
    var age: Int by Delegates.notNull<Int>()
    //Trying to read the property before the initial value
    // has been assigned results in an exception.
    println(age)
    age = 50
}


class Heavy {
    init {
        println("Heavy Class")
    }
}

class LazyUseCases {
    //a new instance is generated every time and thus takes extra time
    var heavy1 = Heavy()

    //no new instance is generated twice,
    //old instance is cached and used in the subsequent calls
    val heavy2 by lazy { Heavy() }
}

class ObservableUseCases {
    var points: Int by Delegates.observable(0) { property, oldValue, newValue ->
        println("Old value $oldValue")
        println("New value $newValue")
    }
}

class VetoableUseCases {
    //Here I wanted to intercept the assignment value of the variable age
    //So, I have put there a condition until and unless it is satisfied
    // the value of the field will not get changed i.e. 21
    var age: Int by Delegates.vetoable(21) { property, oldValue, newValue ->
        println("Old value $oldValue")
        println("New value $newValue")
        newValue > 21
    }
}

class DoubleColonDelegateUseCases {

    var newBaseUrl: String = ""

    //starting Kotlin 1.4, this is possible to delegate directly to another property.
    var baseUrl: String by this::newBaseUrl
}