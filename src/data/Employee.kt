package data

open class XYZ(val nam : String) {
    final override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    final override fun hashCode(): Int {
        return super.hashCode()
    }
    final override fun toString(): String {
        return super.toString()
    }
}

data class Employee(var name : String, var salary : Int) : XYZ(name)


fun main() {
    val employee1 = Employee("Vaibhav", 500000)
    val employee2 = Employee("Vaibhav", 500000)

    println(employee1 == employee2)

}
