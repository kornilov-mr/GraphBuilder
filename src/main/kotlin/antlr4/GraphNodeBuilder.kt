package antlr4

import graph.Graph

/**
 * Listener, inheritor of GraphBaseListener, which
 * fires on entering statement specified in grammar
 *
 * Goes through all input only creating nodes, without filling edges
 */
class GraphNodeBuilder: GraphBaseListener() {
    val graph: Graph = Graph()

    override fun enterStatement(ctx: GraphParser.StatementContext) {
        graph.addNode(ctx.ID(0).text)
        val neighbors = mutableListOf<String>()

        if (ctx.ID().size > 1) {
            neighbors.add(ctx.ID(1).text)
        } else if (ctx.list() != null) {
            neighbors.addAll(ctx.list().ID().map { it.text })
        }
        for (n in neighbors) {
            graph.addNode(n)
        }
        super.enterStatement(ctx)
    }
}