// Generated from c:/Users/Neon/Desktop/falculdade/compiladores/3 Adress/Trabalho-Compiladores/MiniC.g by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniCParser}.
 */
public interface MiniCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(MiniCParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(MiniCParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#data_definition}.
	 * @param ctx the parse tree
	 */
	void enterData_definition(MiniCParser.Data_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#data_definition}.
	 * @param ctx the parse tree
	 */
	void exitData_definition(MiniCParser.Data_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(MiniCParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(MiniCParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(MiniCParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(MiniCParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#function_header}.
	 * @param ctx the parse tree
	 */
	void enterFunction_header(MiniCParser.Function_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#function_header}.
	 * @param ctx the parse tree
	 */
	void exitFunction_header(MiniCParser.Function_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(MiniCParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(MiniCParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void enterParameter_declaration(MiniCParser.Parameter_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void exitParameter_declaration(MiniCParser.Parameter_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(MiniCParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(MiniCParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(MiniCParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(MiniCParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(MiniCParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(MiniCParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MiniCParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MiniCParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_list(MiniCParser.Argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_list(MiniCParser.Argument_listContext ctx);
}