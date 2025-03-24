package antlr4;// Generated from Graph.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphParser}.
 */
public interface GraphListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GraphParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GraphParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GraphParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GraphParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GraphParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(GraphParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(GraphParser.ListContext ctx);
}