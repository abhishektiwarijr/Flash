package accessmodifiers

open class Employee(name: String, email: String, salary: String, id: String) {
    public var name : String? = null
    private var email : String? = null
    protected var salary : String? = null
    internal var id : String? = null

    init {
        this.name = name
        this.email = email
        this.salary = salary
        this.id = id
    }


    operator fun component1() = name
    operator fun component2() = email
    operator fun component3() = salary
    operator fun component4() = id
}