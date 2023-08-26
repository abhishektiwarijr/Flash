package kotlinquiz

//Will it compile?

fun dfs(graph: Graph) {
    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v, visited)
    }

    dfs(graph.vertices[0], HashSet())
}


data class Graph(
    val vertices: List<Vertex>
)

data class Vertex(val neighbors: List<Vertex>)

//Yes, Kotlin supports local functions which are functions inside another function.