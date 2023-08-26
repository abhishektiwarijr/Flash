package a

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
}