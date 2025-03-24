package graph

/**
 * Class, which represents the whole graph
 * @property nodes collection of all nodes in graph
 * @property stringToNode hashmap which contains string to node used for checking
 * if the node with such name is already added or doesn't exist
 */
class Graph {
    private val nodes: MutableSet<Node> = mutableSetOf()
    private val stringToNode: MutableMap<String, Node> = mutableMapOf()

    /**
     * Creates node with the name
     * @param nodeName name of the node to create
     */
    fun addNode(nodeName: String) {
        if (!stringToNode.contains(nodeName)) {
            val node = Node(nodeName)
            stringToNode[nodeName] = node
            nodes.add(node)
        }
    }

    /**
     * Add new edge between two nodes (directional)
     * @param nodeName1 name of the start node
     * @param nodeName2 name of the end node
     * @throws Exception if some of the nodes don't exist
     */
    fun addEdge(nodeName1: String, nodeName2: String) {
        if (!(stringToNode.contains(nodeName1) && stringToNode.contains(nodeName2)))
            throw Exception("unknown Node")
        val node1: Node = stringToNode[nodeName1]!!
        val node2: Node = stringToNode[nodeName2]!!
        node1.addChild(node2)
    }

    /**
     * Formats the graph for PlantUML
     * @return list of edges in right format
     */
    fun toListOfEdges(): String {
        var s = ""
        for (node in nodes) {
            for (child in node.children) {
                s += node.name + " -> " + child.name + "\n"
            }
        }
        return s
    }
}