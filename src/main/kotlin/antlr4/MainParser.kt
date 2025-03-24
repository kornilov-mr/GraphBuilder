package antlr4

import graph.Graph
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker


/**
 * @param input graph as input string:
 * Example: "A -> B
 *           B -> C
 *           C -> A"
 * @return graph, which is created for the string using antlr4
 */
fun parseUserInput(input: String): Graph {
    val lexer = GraphLexer(CharStreams.fromString(input))
    val tokens = CommonTokenStream(lexer)
    val parser = GraphParser(tokens)
    val tree = parser.file()

    val graphNodeBuilder = GraphNodeBuilder()
    ParseTreeWalker.DEFAULT.walk(graphNodeBuilder, tree)

    val emptyGraph: Graph = graphNodeBuilder.graph
    val graphNodeFiller = GraphNodeFiller(emptyGraph)
    ParseTreeWalker.DEFAULT.walk(graphNodeFiller, tree)
    return graphNodeBuilder.graph
}