package test

class WhatIsWrong(var name : String) {
    var id: Int = -1

    init {
        println("Employee has got a name as $name")
    }

    constructor(sectionName: String, id : Int) : this(sectionName) {
        this.id = id
    }
}