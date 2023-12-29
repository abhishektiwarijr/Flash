package uplers

interface Repository<T> {
    fun get(): Iterable<T>
}

fun main() {
    val input = listOf(
        Student(
            1, "A", subscribedCourses = listOf(
                Course(11, "Maths", false),
                Course(11, "Arts", true),
            )
        ),
        Student(
            2, "B", subscribedCourses = listOf(
                Course(21, "History", true),
                Course(21, "Biology", true),
            )
        ),
        Student(
            3, "C", subscribedCourses = listOf(
                Course(31, "Physics", false),
                Course(31, "History", true),
            )
        ),
    )
    println(getPaidCoursesWithTheNumbersOfSubscribedStudents(3, input))
}

fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int, input: List<Student>): Map<Course, Int> {
    //TODO make a efficient solution for this
    return input.flatMap { it.subscribedCourses }
        .filter { it.isPaid }
        .groupBy({ it.name }, { it })
        .map { (_, values) -> values[0] to values.size }
        .toMap().entries.sortedByDescending { it.value }
        .take(coursesCount)
        .associateBy({ it.key }, { it.value })
}