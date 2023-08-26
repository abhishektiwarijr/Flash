package kotlinquiz

//Can local functions access to local variables of the outer scope?

fun dfs1(graph: Graph) {
    val visited = HashSet<Vertex>()
    fun dfs1(current: Vertex) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs1(v)
    }

    dfs1(graph.vertices[0])
}

//Yes, local functions can access to local variables of the outer scope.
