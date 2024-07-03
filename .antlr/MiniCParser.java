// Generated from c:/Users/Neon/Desktop/falculdade/compiladores/3 Adress/Trabalho-Compiladores/MiniC.g by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, INT=26, CHAR=27, TIPO=28, IF=29, WHILE=30, ELSE=31, BREAK=32, 
		CONTINUE=33, RETURN=34, Identifier=35, CONSTANT_INT=36, CONSTANT_CHAR=37, 
		COMMENT=38, WS=39;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_data_definition = 2, RULE_declarator = 3, 
		RULE_function_definition = 4, RULE_function_header = 5, RULE_parameter_list = 6, 
		RULE_parameter_declaration = 7, RULE_function_body = 8, RULE_block = 9, 
		RULE_statement = 10, RULE_expression = 11, RULE_binary = 12, RULE_unary = 13, 
		RULE_primary = 14, RULE_argument_list = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "data_definition", "declarator", "function_definition", 
			"function_header", "parameter_list", "parameter_declaration", "function_body", 
			"block", "statement", "expression", "binary", "unary", "primary", "argument_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'('", "')'", "'{'", "'}'", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'=='", "'!='", "'<='", "'>='", "'>'", "'<'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'int'", "'char'", 
			null, "'if'", "'while'", "'else'", "'break'", "'continue'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT", "CHAR", "TIPO", "IF", "WHILE", "ELSE", "BREAK", "CONTINUE", 
			"RETURN", "Identifier", "CONSTANT_INT", "CONSTANT_CHAR", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			definition();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==CHAR) {
				{
				{
				setState(33);
				definition();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public Data_definitionContext data_definition() {
			return getRuleContext(Data_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				data_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				function_definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Data_definitionContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiniCParser.CHAR, 0); }
		public Data_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_definition; }
	}

	public final Data_definitionContext data_definition() throws RecognitionException {
		Data_definitionContext _localctx = new Data_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==CHAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(46);
			declarator();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(47);
				match(T__0);
				setState(48);
				declarator();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public Function_headerContext function_header() {
			return getRuleContext(Function_headerContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiniCParser.CHAR, 0); }
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==CHAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(59);
			function_header();
			setState(60);
			function_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_headerContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Function_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_header; }
	}

	public final Function_headerContext function_header() throws RecognitionException {
		Function_headerContext _localctx = new Function_headerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			declarator();
			setState(63);
			parameter_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public Parameter_declarationContext parameter_declaration() {
			return getRuleContext(Parameter_declarationContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__2);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==CHAR) {
				{
				setState(66);
				parameter_declaration();
				}
			}

			setState(69);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_declarationContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public List<TerminalNode> INT() { return getTokens(MiniCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MiniCParser.INT, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(MiniCParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(MiniCParser.CHAR, i);
		}
		public Parameter_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration; }
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==CHAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(72);
			declarator();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(73);
				match(T__0);
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==CHAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				declarator();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_bodyContext extends ParserRuleContext {
		public List<Data_definitionContext> data_definition() {
			return getRuleContexts(Data_definitionContext.class);
		}
		public Data_definitionContext data_definition(int i) {
			return getRuleContext(Data_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__4);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==CHAR) {
				{
				{
				setState(82);
				data_definition();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 272243884076L) != 0)) {
				{
				{
				setState(88);
				statement();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				statement();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 272243884076L) != 0) );
			setState(102);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public TerminalNode BREAK() { return getToken(MiniCParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(MiniCParser.CONTINUE, 0); }
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__23:
			case T__24:
			case Identifier:
			case CONSTANT_INT:
			case CONSTANT_CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				expression();
				setState(105);
				match(T__1);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(IF);
				setState(108);
				match(T__2);
				setState(109);
				expression();
				setState(110);
				match(T__3);
				setState(111);
				statement();
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(112);
					match(ELSE);
					setState(113);
					statement();
					}
					break;
				}
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(WHILE);
				setState(117);
				match(T__2);
				setState(118);
				expression();
				setState(119);
				match(T__3);
				setState(120);
				statement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(BREAK);
				setState(123);
				match(T__1);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(CONTINUE);
				setState(125);
				match(T__1);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				match(RETURN);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240568500232L) != 0)) {
					{
					setState(127);
					expression();
					}
				}

				setState(130);
				match(T__1);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				block();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 8);
				{
				setState(132);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<BinaryContext> binary() {
			return getRuleContexts(BinaryContext.class);
		}
		public BinaryContext binary(int i) {
			return getRuleContext(BinaryContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			binary(0);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(136);
				match(T__0);
				setState(137);
				binary(0);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public List<BinaryContext> binary() {
			return getRuleContexts(BinaryContext.class);
		}
		public BinaryContext binary(int i) {
			return getRuleContext(BinaryContext.class,i);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
	}

	public final BinaryContext binary() throws RecognitionException {
		return binary(0);
	}

	private BinaryContext binary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BinaryContext _localctx = new BinaryContext(_ctx, _parentState);
		BinaryContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_binary, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(144);
				match(Identifier);
				setState(145);
				match(T__6);
				setState(146);
				binary(18);
				}
				break;
			case 2:
				{
				setState(147);
				match(Identifier);
				setState(148);
				match(T__7);
				setState(149);
				binary(17);
				}
				break;
			case 3:
				{
				setState(150);
				match(Identifier);
				setState(151);
				match(T__8);
				setState(152);
				binary(16);
				}
				break;
			case 4:
				{
				setState(153);
				match(Identifier);
				setState(154);
				match(T__9);
				setState(155);
				binary(15);
				}
				break;
			case 5:
				{
				setState(156);
				match(Identifier);
				setState(157);
				match(T__10);
				setState(158);
				binary(14);
				}
				break;
			case 6:
				{
				setState(159);
				match(Identifier);
				setState(160);
				match(T__11);
				setState(161);
				binary(13);
				}
				break;
			case 7:
				{
				setState(162);
				unary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(165);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(166);
						match(T__12);
						setState(167);
						binary(13);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(168);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(169);
						match(T__13);
						setState(170);
						binary(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(171);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(172);
						match(T__14);
						setState(173);
						binary(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(174);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(175);
						match(T__15);
						setState(176);
						binary(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(177);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(178);
						match(T__16);
						setState(179);
						binary(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(180);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(181);
						match(T__17);
						setState(182);
						binary(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(183);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(184);
						match(T__18);
						setState(185);
						binary(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(186);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(187);
						match(T__19);
						setState(188);
						binary(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(189);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(190);
						match(T__20);
						setState(191);
						binary(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(192);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(193);
						match(T__21);
						setState(194);
						binary(4);
						}
						break;
					case 11:
						{
						_localctx = new BinaryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary);
						setState(195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(196);
						match(T__22);
						setState(197);
						binary(3);
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unary);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__23);
				setState(204);
				match(Identifier);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(T__24);
				setState(206);
				match(Identifier);
				}
				break;
			case T__2:
			case Identifier:
			case CONSTANT_INT:
			case CONSTANT_CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public TerminalNode CONSTANT_INT() { return getToken(MiniCParser.CONSTANT_INT, 0); }
		public TerminalNode CONSTANT_CHAR() { return getToken(MiniCParser.CONSTANT_CHAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primary);
		int _la;
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(CONSTANT_INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(CONSTANT_CHAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				match(T__2);
				setState(214);
				expression();
				setState(215);
				match(T__3);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				match(Identifier);
				setState(218);
				match(T__2);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240568500232L) != 0)) {
					{
					setState(219);
					argument_list();
					}
				}

				setState(222);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public List<BinaryContext> binary() {
			return getRuleContexts(BinaryContext.class);
		}
		public BinaryContext binary(int i) {
			return getRuleContext(BinaryContext.class,i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			binary(0);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(226);
				match(T__0);
				setState(227);
				binary(0);
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return binary_sempred((BinaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binary_sempred(BinaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u00ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00022\b\u0002"+
		"\n\u0002\f\u00025\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006D\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007M\b\u0007\n\u0007\f\u0007P\t\u0007\u0001\b\u0001\b\u0005\b"+
		"T\b\b\n\b\f\bW\t\b\u0001\b\u0005\bZ\b\b\n\b\f\b]\t\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0004\tc\b\t\u000b\t\f\td\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\ns\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0086\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u008b\b\u000b"+
		"\n\u000b\f\u000b\u008e\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a4\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00c7\b\f\n\f\f\f\u00ca"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d1\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00dd\b\u000e\u0001\u000e"+
		"\u0003\u000e\u00e0\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00e5\b\u000f\n\u000f\f\u000f\u00e8\t\u000f\u0001\u000f\u0000\u0001\u0018"+
		"\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e\u0000\u0001\u0001\u0000\u001a\u001b\u0104\u0000 \u0001"+
		"\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000"+
		"\u0000\u00068\u0001\u0000\u0000\u0000\b:\u0001\u0000\u0000\u0000\n>\u0001"+
		"\u0000\u0000\u0000\fA\u0001\u0000\u0000\u0000\u000eG\u0001\u0000\u0000"+
		"\u0000\u0010Q\u0001\u0000\u0000\u0000\u0012`\u0001\u0000\u0000\u0000\u0014"+
		"\u0085\u0001\u0000\u0000\u0000\u0016\u0087\u0001\u0000\u0000\u0000\u0018"+
		"\u00a3\u0001\u0000\u0000\u0000\u001a\u00d0\u0001\u0000\u0000\u0000\u001c"+
		"\u00df\u0001\u0000\u0000\u0000\u001e\u00e1\u0001\u0000\u0000\u0000 $\u0003"+
		"\u0002\u0001\u0000!#\u0003\u0002\u0001\u0000\"!\u0001\u0000\u0000\u0000"+
		"#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005\u0000"+
		"\u0000\u0001(\u0001\u0001\u0000\u0000\u0000),\u0003\u0004\u0002\u0000"+
		"*,\u0003\b\u0004\u0000+)\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000"+
		",\u0003\u0001\u0000\u0000\u0000-.\u0007\u0000\u0000\u0000.3\u0003\u0006"+
		"\u0003\u0000/0\u0005\u0001\u0000\u000002\u0003\u0006\u0003\u00001/\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000067\u0005\u0002\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0005"+
		"#\u0000\u00009\u0007\u0001\u0000\u0000\u0000:;\u0007\u0000\u0000\u0000"+
		";<\u0003\n\u0005\u0000<=\u0003\u0010\b\u0000=\t\u0001\u0000\u0000\u0000"+
		">?\u0003\u0006\u0003\u0000?@\u0003\f\u0006\u0000@\u000b\u0001\u0000\u0000"+
		"\u0000AC\u0005\u0003\u0000\u0000BD\u0003\u000e\u0007\u0000CB\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0005"+
		"\u0004\u0000\u0000F\r\u0001\u0000\u0000\u0000GH\u0007\u0000\u0000\u0000"+
		"HN\u0003\u0006\u0003\u0000IJ\u0005\u0001\u0000\u0000JK\u0007\u0000\u0000"+
		"\u0000KM\u0003\u0006\u0003\u0000LI\u0001\u0000\u0000\u0000MP\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u000f"+
		"\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QU\u0005\u0005\u0000"+
		"\u0000RT\u0003\u0004\u0002\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V[\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XZ\u0003\u0014\n\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^_\u0005\u0006\u0000\u0000_\u0011\u0001\u0000\u0000\u0000`b\u0005"+
		"\u0005\u0000\u0000ac\u0003\u0014\n\u0000ba\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fg\u0005\u0006\u0000\u0000g\u0013\u0001\u0000"+
		"\u0000\u0000hi\u0003\u0016\u000b\u0000ij\u0005\u0002\u0000\u0000j\u0086"+
		"\u0001\u0000\u0000\u0000kl\u0005\u001d\u0000\u0000lm\u0005\u0003\u0000"+
		"\u0000mn\u0003\u0016\u000b\u0000no\u0005\u0004\u0000\u0000or\u0003\u0014"+
		"\n\u0000pq\u0005\u001f\u0000\u0000qs\u0003\u0014\n\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0086\u0001\u0000\u0000\u0000"+
		"tu\u0005\u001e\u0000\u0000uv\u0005\u0003\u0000\u0000vw\u0003\u0016\u000b"+
		"\u0000wx\u0005\u0004\u0000\u0000xy\u0003\u0014\n\u0000y\u0086\u0001\u0000"+
		"\u0000\u0000z{\u0005 \u0000\u0000{\u0086\u0005\u0002\u0000\u0000|}\u0005"+
		"!\u0000\u0000}\u0086\u0005\u0002\u0000\u0000~\u0080\u0005\"\u0000\u0000"+
		"\u007f\u0081\u0003\u0016\u000b\u0000\u0080\u007f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0086\u0005\u0002\u0000\u0000\u0083\u0086\u0003\u0012\t\u0000\u0084"+
		"\u0086\u0005\u0002\u0000\u0000\u0085h\u0001\u0000\u0000\u0000\u0085k\u0001"+
		"\u0000\u0000\u0000\u0085t\u0001\u0000\u0000\u0000\u0085z\u0001\u0000\u0000"+
		"\u0000\u0085|\u0001\u0000\u0000\u0000\u0085~\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0015\u0001\u0000\u0000\u0000\u0087\u008c\u0003\u0018\f\u0000\u0088\u0089"+
		"\u0005\u0001\u0000\u0000\u0089\u008b\u0003\u0018\f\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0017\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0006"+
		"\f\uffff\uffff\u0000\u0090\u0091\u0005#\u0000\u0000\u0091\u0092\u0005"+
		"\u0007\u0000\u0000\u0092\u00a4\u0003\u0018\f\u0012\u0093\u0094\u0005#"+
		"\u0000\u0000\u0094\u0095\u0005\b\u0000\u0000\u0095\u00a4\u0003\u0018\f"+
		"\u0011\u0096\u0097\u0005#\u0000\u0000\u0097\u0098\u0005\t\u0000\u0000"+
		"\u0098\u00a4\u0003\u0018\f\u0010\u0099\u009a\u0005#\u0000\u0000\u009a"+
		"\u009b\u0005\n\u0000\u0000\u009b\u00a4\u0003\u0018\f\u000f\u009c\u009d"+
		"\u0005#\u0000\u0000\u009d\u009e\u0005\u000b\u0000\u0000\u009e\u00a4\u0003"+
		"\u0018\f\u000e\u009f\u00a0\u0005#\u0000\u0000\u00a0\u00a1\u0005\f\u0000"+
		"\u0000\u00a1\u00a4\u0003\u0018\f\r\u00a2\u00a4\u0003\u001a\r\u0000\u00a3"+
		"\u008f\u0001\u0000\u0000\u0000\u00a3\u0093\u0001\u0000\u0000\u0000\u00a3"+
		"\u0096\u0001\u0000\u0000\u0000\u00a3\u0099\u0001\u0000\u0000\u0000\u00a3"+
		"\u009c\u0001\u0000\u0000\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4\u00c8\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\n\f\u0000\u0000\u00a6\u00a7\u0005\r\u0000\u0000\u00a7\u00c7\u0003"+
		"\u0018\f\r\u00a8\u00a9\n\u000b\u0000\u0000\u00a9\u00aa\u0005\u000e\u0000"+
		"\u0000\u00aa\u00c7\u0003\u0018\f\f\u00ab\u00ac\n\n\u0000\u0000\u00ac\u00ad"+
		"\u0005\u000f\u0000\u0000\u00ad\u00c7\u0003\u0018\f\u000b\u00ae\u00af\n"+
		"\t\u0000\u0000\u00af\u00b0\u0005\u0010\u0000\u0000\u00b0\u00c7\u0003\u0018"+
		"\f\n\u00b1\u00b2\n\b\u0000\u0000\u00b2\u00b3\u0005\u0011\u0000\u0000\u00b3"+
		"\u00c7\u0003\u0018\f\t\u00b4\u00b5\n\u0007\u0000\u0000\u00b5\u00b6\u0005"+
		"\u0012\u0000\u0000\u00b6\u00c7\u0003\u0018\f\b\u00b7\u00b8\n\u0006\u0000"+
		"\u0000\u00b8\u00b9\u0005\u0013\u0000\u0000\u00b9\u00c7\u0003\u0018\f\u0007"+
		"\u00ba\u00bb\n\u0005\u0000\u0000\u00bb\u00bc\u0005\u0014\u0000\u0000\u00bc"+
		"\u00c7\u0003\u0018\f\u0006\u00bd\u00be\n\u0004\u0000\u0000\u00be\u00bf"+
		"\u0005\u0015\u0000\u0000\u00bf\u00c7\u0003\u0018\f\u0005\u00c0\u00c1\n"+
		"\u0003\u0000\u0000\u00c1\u00c2\u0005\u0016\u0000\u0000\u00c2\u00c7\u0003"+
		"\u0018\f\u0004\u00c3\u00c4\n\u0002\u0000\u0000\u00c4\u00c5\u0005\u0017"+
		"\u0000\u0000\u00c5\u00c7\u0003\u0018\f\u0003\u00c6\u00a5\u0001\u0000\u0000"+
		"\u0000\u00c6\u00a8\u0001\u0000\u0000\u0000\u00c6\u00ab\u0001\u0000\u0000"+
		"\u0000\u00c6\u00ae\u0001\u0000\u0000\u0000\u00c6\u00b1\u0001\u0000\u0000"+
		"\u0000\u00c6\u00b4\u0001\u0000\u0000\u0000\u00c6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00c6\u00ba\u0001\u0000\u0000\u0000\u00c6\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c0\u0001\u0000\u0000\u0000\u00c6\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u0019\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0018\u0000"+
		"\u0000\u00cc\u00d1\u0005#\u0000\u0000\u00cd\u00ce\u0005\u0019\u0000\u0000"+
		"\u00ce\u00d1\u0005#\u0000\u0000\u00cf\u00d1\u0003\u001c\u000e\u0000\u00d0"+
		"\u00cb\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d1\u001b\u0001\u0000\u0000\u0000\u00d2"+
		"\u00e0\u0005#\u0000\u0000\u00d3\u00e0\u0005$\u0000\u0000\u00d4\u00e0\u0005"+
		"%\u0000\u0000\u00d5\u00d6\u0005\u0003\u0000\u0000\u00d6\u00d7\u0003\u0016"+
		"\u000b\u0000\u00d7\u00d8\u0005\u0004\u0000\u0000\u00d8\u00e0\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005#\u0000\u0000\u00da\u00dc\u0005\u0003\u0000"+
		"\u0000\u00db\u00dd\u0003\u001e\u000f\u0000\u00dc\u00db\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u00e0\u0005\u0004\u0000\u0000\u00df\u00d2\u0001\u0000\u0000"+
		"\u0000\u00df\u00d3\u0001\u0000\u0000\u0000\u00df\u00d4\u0001\u0000\u0000"+
		"\u0000\u00df\u00d5\u0001\u0000\u0000\u0000\u00df\u00d9\u0001\u0000\u0000"+
		"\u0000\u00e0\u001d\u0001\u0000\u0000\u0000\u00e1\u00e6\u0003\u0018\f\u0000"+
		"\u00e2\u00e3\u0005\u0001\u0000\u0000\u00e3\u00e5\u0003\u0018\f\u0000\u00e4"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7"+
		"\u001f\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u0013"+
		"$+3CNU[dr\u0080\u0085\u008c\u00a3\u00c6\u00c8\u00d0\u00dc\u00df\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}