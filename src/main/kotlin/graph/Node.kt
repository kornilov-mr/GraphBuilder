package graph

/**
 * Class, which represents graph nodes
 * @property children collection of all nodes,
 * which the node has an edge to(directional)
 * @property name name of the node
 */
class Node(val name: String) {
    val children:MutableList<Node> = mutableListOf()
    fun addChild(node: Node) {
        children.add(node)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Node) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

}