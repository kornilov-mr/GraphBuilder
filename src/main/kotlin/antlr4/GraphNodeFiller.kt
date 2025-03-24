package antlr4

import graph.Graph
/**
 * Listener, inheritor of GraphBaseListener, which
 * fires on entering statement specified in grammar
 *
 * Goes through all input filling edges between already created nodes
 */
class GraphNodeFiller(val graph: Graph) : GraphBaseListener() {
    override fun enterStatement(ctx: GraphParser.StatementContext) {
        val node = ctx.ID(0).text
        val neighbors = mutableListOf<String>()

        if (ctx.ID().size > 1) {
            neighbors.add(ctx.ID(1).text)
        } else if (ctx.list() != null) {
            neighbors.addAll(ctx.list().ID().map { it.text })
        }
        for (n in neighbors) {
            graph.addEdge(node, n)
        }
        super.enterStatement(ctx)
    }

}