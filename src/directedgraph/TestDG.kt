package directedgraph

fun main() {
    val adjacencyListGraph = AdjacencyList<String>()

    val brazil = adjacencyListGraph.createVertex("Brazil")
    val germany = adjacencyListGraph.createVertex("Germany")
    val thailand = adjacencyListGraph.createVertex("Thailand")
    val unitedKingdom = adjacencyListGraph.createVertex("United Kingdom")

    adjacencyListGraph.addDirectedEdge(brazil, germany, 1860.00)
    adjacencyListGraph.addDirectedEdge(brazil, thailand, 2310.00)
    adjacencyListGraph.addDirectedEdge(thailand, germany, 1250.00)
    adjacencyListGraph.addDirectedEdge(germany, unitedKingdom, 1310.00)
    adjacencyListGraph.addDirectedEdge(unitedKingdom, brazil, 890.00)

    println(adjacencyListGraph)

}