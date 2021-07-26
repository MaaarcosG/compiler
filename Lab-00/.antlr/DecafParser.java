// Generated from c:\Users\Marcos\Documents\Universidad\DecimoSemestre\Compiladores\compiler\Lab-00\Decaf.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, CLASS=2, PROGRAM=3, IF=4, ELSE=5, FOR=6, RETURN=7, BREAK=8, CONTINUE=9, 
		BOOLEAN=10, STRUCT=11, CHAR=12, INT=13, STRING=14, TRUE=15, FALSE=16, 
		VOID=17, CALLOUT=18, SEMICOLON=19, LCURLY=20, RCURLY=21, LSQUARE=22, RSQUARE=23, 
		LROUND=24, RROUND=25, COMMA=26, QUOTES=27, APOSTROPHE=28, ADD=29, SUB=30, 
		MULTIPLY=31, DIVIDE=32, REMINDER=33, AND=34, OR=35, NOT=36, GREATER_OP=37, 
		LESS_OP=38, GREATER_eq_op=39, LESS_eq_op=40, EQUAL_OP=41, ADD_eq_op=42, 
		SUB_eq_op=43, EQUALITY_OP=44, UNEQUALITY_OP=45, ID=46, LETTER=47, CHAR_LITERAL=48, 
		DECIMAL_LITERAL=49, HEX_LITERAL=50, BOOL_LITERAL=51, STRING_LITERAL=52, 
		WHITESPACE=53;
	public static final int
		RULE_program = 0, RULE_var_declar = 1, RULE_struct_declar = 2, RULE_field_declar = 3, 
		RULE_array_id = 4, RULE_field_var = 5, RULE_var_id = 6, RULE_method_declar = 7, 
		RULE_return_type = 8, RULE_block = 9, RULE_statement = 10, RULE_method_call_inter = 11, 
		RULE_method_call = 12, RULE_expr = 13, RULE_location = 14, RULE_callout_arg = 15, 
		RULE_int_literal = 16, RULE_rel_op = 17, RULE_eq_op = 18, RULE_cond_op = 19, 
		RULE_literal = 20, RULE_bin_op = 21, RULE_arith_op = 22, RULE_var_type = 23, 
		RULE_assign_op = 24, RULE_method_name = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "var_declar", "struct_declar", "field_declar", "array_id", 
			"field_var", "var_id", "method_declar", "return_type", "block", "statement", 
			"method_call_inter", "method_call", "expr", "location", "callout_arg", 
			"int_literal", "rel_op", "eq_op", "cond_op", "literal", "bin_op", "arith_op", 
			"var_type", "assign_op", "method_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'class'", "'Program'", "'if'", "'else'", "'for'", "'return'", 
			"'break'", "'continue'", "'boolean'", "'struct'", "'char'", "'int'", 
			"'string'", "'True'", "'False'", "'void'", "'callout'", "';'", "'{'", 
			"'}'", "'['", "']'", "'('", "')'", "','", "'\"'", "'''", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'>'", "'<'", "'>='", "'<='", 
			"'='", "'+='", "'-='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "CLASS", "PROGRAM", "IF", "ELSE", "FOR", "RETURN", "BREAK", 
			"CONTINUE", "BOOLEAN", "STRUCT", "CHAR", "INT", "STRING", "TRUE", "FALSE", 
			"VOID", "CALLOUT", "SEMICOLON", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", 
			"LROUND", "RROUND", "COMMA", "QUOTES", "APOSTROPHE", "ADD", "SUB", "MULTIPLY", 
			"DIVIDE", "REMINDER", "AND", "OR", "NOT", "GREATER_OP", "LESS_OP", "GREATER_eq_op", 
			"LESS_eq_op", "EQUAL_OP", "ADD_eq_op", "SUB_eq_op", "EQUALITY_OP", "UNEQUALITY_OP", 
			"ID", "LETTER", "CHAR_LITERAL", "DECIMAL_LITERAL", "HEX_LITERAL", "BOOL_LITERAL", 
			"STRING_LITERAL", "WHITESPACE"
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
	public String getGrammarFileName() { return "Decaf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(DecafParser.CLASS, 0); }
		public TerminalNode PROGRAM() { return getToken(DecafParser.PROGRAM, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<Field_declarContext> field_declar() {
			return getRuleContexts(Field_declarContext.class);
		}
		public Field_declarContext field_declar(int i) {
			return getRuleContext(Field_declarContext.class,i);
		}
		public List<Method_declarContext> method_declar() {
			return getRuleContexts(Method_declarContext.class);
		}
		public Method_declarContext method_declar(int i) {
			return getRuleContext(Method_declarContext.class,i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CLASS);
			setState(53);
			match(PROGRAM);
			setState(54);
			match(LCURLY);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					field_declar();
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRUCT) | (1L << INT) | (1L << VOID))) != 0)) {
				{
				{
				setState(61);
				method_declar();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(RCURLY);
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

	public static class Var_declarContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<Field_varContext> field_var() {
			return getRuleContexts(Field_varContext.class);
		}
		public Field_varContext field_var(int i) {
			return getRuleContext(Field_varContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Var_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declar; }
	}

	public final Var_declarContext var_declar() throws RecognitionException {
		Var_declarContext _localctx = new Var_declarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(69);
			var_type();
			setState(70);
			field_var();
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(72);
				match(COMMA);
				setState(73);
				var_type();
				setState(74);
				field_var();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(SEMICOLON);
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

	public static class Struct_declarContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(DecafParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<Var_declarContext> var_declar() {
			return getRuleContexts(Var_declarContext.class);
		}
		public Var_declarContext var_declar(int i) {
			return getRuleContext(Var_declarContext.class,i);
		}
		public Struct_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declar; }
	}

	public final Struct_declarContext struct_declar() throws RecognitionException {
		Struct_declarContext _localctx = new Struct_declarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(STRUCT);
			setState(84);
			match(ID);
			setState(85);
			match(LCURLY);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRUCT) | (1L << INT) | (1L << VOID))) != 0)) {
				{
				{
				setState(86);
				var_declar();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(92);
			match(RCURLY);
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

	public static class Field_declarContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public List<Field_varContext> field_var() {
			return getRuleContexts(Field_varContext.class);
		}
		public Field_varContext field_var(int i) {
			return getRuleContext(Field_varContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Field_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_declar; }
	}

	public final Field_declarContext field_declar() throws RecognitionException {
		Field_declarContext _localctx = new Field_declarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			var_type();
			setState(95);
			field_var();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(96);
				match(COMMA);
				setState(97);
				field_var();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(SEMICOLON);
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

	public static class Array_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LSQUARE() { return getToken(DecafParser.LSQUARE, 0); }
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(DecafParser.RSQUARE, 0); }
		public Array_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_id; }
	}

	public final Array_idContext array_id() throws RecognitionException {
		Array_idContext _localctx = new Array_idContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ID);
			setState(106);
			match(LSQUARE);
			setState(107);
			int_literal();
			setState(108);
			match(RSQUARE);
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

	public static class Field_varContext extends ParserRuleContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext array_id() {
			return getRuleContext(Array_idContext.class,0);
		}
		public Field_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_var; }
	}

	public final Field_varContext field_var() throws RecognitionException {
		Field_varContext _localctx = new Field_varContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_field_var);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				var_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				array_id();
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

	public static class Var_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Var_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_id; }
	}

	public final Var_idContext var_id() throws RecognitionException {
		Var_idContext _localctx = new Var_idContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
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

	public static class Method_declarContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_declar; }
	}

	public final Method_declarContext method_declar() throws RecognitionException {
		Method_declarContext _localctx = new Method_declarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			return_type();
			setState(117);
			method_name();
			setState(118);
			match(LROUND);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRUCT) | (1L << INT) | (1L << VOID))) != 0)) {
				{
				{
				setState(119);
				var_type();
				setState(120);
				var_id();
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(122);
					match(COMMA);
					setState(123);
					var_type();
					setState(124);
					var_id();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133);
			match(RROUND);
			setState(134);
			block();
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

	public static class Return_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_return_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(136);
				var_type();
				}
				break;
			case 2:
				{
				setState(137);
				match(VOID);
				}
				break;
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<Var_declarContext> var_declar() {
			return getRuleContexts(Var_declarContext.class);
		}
		public Var_declarContext var_declar(int i) {
			return getRuleContext(Var_declarContext.class,i);
		}
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
			setState(140);
			match(LCURLY);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRUCT) | (1L << INT) | (1L << VOID))) != 0)) {
				{
				{
				setState(141);
				var_declar();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CALLOUT) | (1L << ID))) != 0)) {
				{
				{
				setState(147);
				statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(RCURLY);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(DecafParser.FOR, 0); }
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public List<Int_literalContext> int_literal() {
			return getRuleContexts(Int_literalContext.class);
		}
		public Int_literalContext int_literal(int i) {
			return getRuleContext(Int_literalContext.class,i);
		}
		public List<TerminalNode> EQUAL_OP() { return getTokens(DecafParser.EQUAL_OP); }
		public TerminalNode EQUAL_OP(int i) {
			return getToken(DecafParser.EQUAL_OP, i);
		}
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
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
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(IF);
				setState(156);
				match(LROUND);
				setState(157);
				expr(0);
				setState(158);
				match(RROUND);
				setState(159);
				block();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(160);
					match(ELSE);
					setState(161);
					block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(FOR);
				setState(165);
				var_id();
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL_OP) {
					{
					setState(166);
					match(EQUAL_OP);
					setState(167);
					int_literal();
					}
				}

				setState(170);
				match(COMMA);
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					{
					setState(171);
					var_id();
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EQUAL_OP) {
						{
						setState(172);
						match(EQUAL_OP);
						setState(173);
						int_literal();
						}
					}

					}
					}
					break;
				case DECIMAL_LITERAL:
				case HEX_LITERAL:
					{
					setState(176);
					int_literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(179);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(RETURN);
				setState(182);
				expr(0);
				setState(183);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				method_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				location();
				setState(187);
				assign_op();
				setState(188);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(190);
				location();
				setState(191);
				assign_op();
				setState(192);
				expr(0);
				setState(193);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(195);
				var_id();
				setState(196);
				match(EQUAL_OP);
				setState(197);
				expr(0);
				setState(198);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(200);
				match(BREAK);
				setState(201);
				match(SEMICOLON);
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

	public static class Method_call_interContext extends ParserRuleContext {
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_call_interContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call_inter; }
	}

	public final Method_call_interContext method_call_inter() throws RecognitionException {
		Method_call_interContext _localctx = new Method_call_interContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method_call_inter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			method_name();
			setState(205);
			match(LROUND);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CALLOUT) | (1L << LROUND) | (1L << SUB) | (1L << NOT) | (1L << ID) | (1L << CHAR_LITERAL) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << BOOL_LITERAL))) != 0)) {
				{
				setState(206);
				expr(0);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(207);
					match(COMMA);
					setState(208);
					expr(0);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(216);
			match(RROUND);
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

	public static class Method_callContext extends ParserRuleContext {
		public Method_call_interContext method_call_inter() {
			return getRuleContext(Method_call_interContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public TerminalNode CALLOUT() { return getToken(DecafParser.CALLOUT, 0); }
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public List<Callout_argContext> callout_arg() {
			return getRuleContexts(Callout_argContext.class);
		}
		public Callout_argContext callout_arg(int i) {
			return getRuleContext(Callout_argContext.class,i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_method_call);
		int _la;
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				method_call_inter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				method_call_inter();
				setState(220);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(CALLOUT);
				setState(223);
				match(LROUND);
				setState(224);
				match(STRING_LITERAL);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(225);
					match(COMMA);
					setState(226);
					callout_arg();
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(227);
						match(COMMA);
						setState(228);
						callout_arg();
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(236);
				match(RROUND);
				setState(237);
				match(SEMICOLON);
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

	public static class ExprContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode SUB() { return getToken(DecafParser.SUB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode NOT() { return getToken(DecafParser.NOT, 0); }
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(241);
				location();
				}
				break;
			case 2:
				{
				setState(242);
				literal();
				}
				break;
			case 3:
				{
				setState(243);
				match(SUB);
				setState(244);
				expr(4);
				}
				break;
			case 4:
				{
				setState(245);
				method_call();
				}
				break;
			case 5:
				{
				setState(246);
				match(NOT);
				setState(247);
				expr(2);
				}
				break;
			case 6:
				{
				setState(248);
				match(LROUND);
				setState(249);
				expr(0);
				setState(250);
				match(RROUND);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(254);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(255);
					bin_op();
					setState(256);
					expr(6);
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class LocationContext extends ParserRuleContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext array_id() {
			return getRuleContext(Array_idContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(263);
				var_id();
				}
				break;
			case 2:
				{
				setState(264);
				array_id();
				}
				break;
			}
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(267);
				match(T__0);
				setState(268);
				location();
				}
				break;
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

	public static class Callout_argContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public Callout_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_arg; }
	}

	public final Callout_argContext callout_arg() throws RecognitionException {
		Callout_argContext _localctx = new Callout_argContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_callout_arg);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CALLOUT:
			case LROUND:
			case SUB:
			case NOT:
			case ID:
			case CHAR_LITERAL:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				expr(0);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(STRING_LITERAL);
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

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(DecafParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(DecafParser.HEX_LITERAL, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_int_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !(_la==DECIMAL_LITERAL || _la==HEX_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Rel_opContext extends ParserRuleContext {
		public TerminalNode GREATER_OP() { return getToken(DecafParser.GREATER_OP, 0); }
		public TerminalNode LESS_OP() { return getToken(DecafParser.LESS_OP, 0); }
		public TerminalNode LESS_eq_op() { return getToken(DecafParser.LESS_eq_op, 0); }
		public TerminalNode GREATER_eq_op() { return getToken(DecafParser.GREATER_eq_op, 0); }
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_OP) | (1L << LESS_OP) | (1L << GREATER_eq_op) | (1L << LESS_eq_op))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Eq_opContext extends ParserRuleContext {
		public TerminalNode EQUALITY_OP() { return getToken(DecafParser.EQUALITY_OP, 0); }
		public TerminalNode UNEQUALITY_OP() { return getToken(DecafParser.UNEQUALITY_OP, 0); }
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !(_la==EQUALITY_OP || _la==UNEQUALITY_OP) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Cond_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(DecafParser.AND, 0); }
		public TerminalNode OR() { return getToken(DecafParser.OR, 0); }
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(DecafParser.CHAR_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(DecafParser.BOOL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				int_literal();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(CHAR_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				match(BOOL_LITERAL);
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

	public static class Bin_opContext extends ParserRuleContext {
		public Arith_opContext arith_op() {
			return getRuleContext(Arith_opContext.class,0);
		}
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bin_op);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case MULTIPLY:
			case DIVIDE:
			case REMINDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				arith_op();
				}
				break;
			case GREATER_OP:
			case LESS_OP:
			case GREATER_eq_op:
			case LESS_eq_op:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				rel_op();
				}
				break;
			case EQUALITY_OP:
			case UNEQUALITY_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				eq_op();
				}
				break;
			case AND:
			case OR:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				cond_op();
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

	public static class Arith_opContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(DecafParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(DecafParser.SUB, 0); }
		public TerminalNode MULTIPLY() { return getToken(DecafParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(DecafParser.DIVIDE, 0); }
		public TerminalNode REMINDER() { return getToken(DecafParser.REMINDER, 0); }
		public Arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op; }
	}

	public final Arith_opContext arith_op() throws RecognitionException {
		Arith_opContext _localctx = new Arith_opContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MULTIPLY) | (1L << DIVIDE) | (1L << REMINDER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(DecafParser.BOOLEAN, 0); }
		public TerminalNode STRUCT() { return getToken(DecafParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Struct_declarContext struct_declar() {
			return getRuleContext(Struct_declarContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_var_type);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(BOOLEAN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(STRUCT);
				setState(299);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				struct_declar();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(VOID);
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

	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode EQUAL_OP() { return getToken(DecafParser.EQUAL_OP, 0); }
		public TerminalNode ADD_eq_op() { return getToken(DecafParser.ADD_eq_op, 0); }
		public TerminalNode SUB_eq_op() { return getToken(DecafParser.SUB_eq_op, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL_OP) | (1L << ADD_eq_op) | (1L << SUB_eq_op))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ID);
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
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0137\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\7\2A"+
		"\n\2\f\2\16\2D\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3O\n\3\f\3\16"+
		"\3R\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\7\5e\n\5\f\5\16\5h\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\5\7s\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0081\n"+
		"\t\f\t\16\t\u0084\13\t\5\t\u0086\n\t\3\t\3\t\3\t\3\n\3\n\5\n\u008d\n\n"+
		"\3\13\3\13\7\13\u0091\n\13\f\13\16\13\u0094\13\13\3\13\7\13\u0097\n\13"+
		"\f\13\16\13\u009a\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a5"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u00ab\n\f\3\f\3\f\3\f\3\f\5\f\u00b1\n\f\3\f\5"+
		"\f\u00b4\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cd\n\f\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00d4\n\r\f\r\16\r\u00d7\13\r\5\r\u00d9\n\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00e8\n\16\f\16\16\16\u00eb"+
		"\13\16\5\16\u00ed\n\16\3\16\3\16\5\16\u00f1\n\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ff\n\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0105\n\17\f\17\16\17\u0108\13\17\3\20\3\20\5\20\u010c\n\20"+
		"\3\20\3\20\5\20\u0110\n\20\3\21\3\21\5\21\u0114\n\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\5\26\u0121\n\26\3\27\3\27\3\27"+
		"\3\27\5\27\u0127\n\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0131"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\2\3\34\34\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\2\b\3\2\63\64\3\2\'*\3\2./\3\2$%\3\2\37#\3"+
		"\2+-\2\u014a\2\66\3\2\2\2\4G\3\2\2\2\6U\3\2\2\2\b`\3\2\2\2\nk\3\2\2\2"+
		"\fr\3\2\2\2\16t\3\2\2\2\20v\3\2\2\2\22\u008c\3\2\2\2\24\u008e\3\2\2\2"+
		"\26\u00cc\3\2\2\2\30\u00ce\3\2\2\2\32\u00f0\3\2\2\2\34\u00fe\3\2\2\2\36"+
		"\u010b\3\2\2\2 \u0113\3\2\2\2\"\u0115\3\2\2\2$\u0117\3\2\2\2&\u0119\3"+
		"\2\2\2(\u011b\3\2\2\2*\u0120\3\2\2\2,\u0126\3\2\2\2.\u0128\3\2\2\2\60"+
		"\u0130\3\2\2\2\62\u0132\3\2\2\2\64\u0134\3\2\2\2\66\67\7\4\2\2\678\7\5"+
		"\2\28<\7\26\2\29;\5\b\5\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=B\3"+
		"\2\2\2><\3\2\2\2?A\5\20\t\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE"+
		"\3\2\2\2DB\3\2\2\2EF\7\27\2\2F\3\3\2\2\2GH\5\60\31\2HI\5\f\7\2IP\3\2\2"+
		"\2JK\7\34\2\2KL\5\60\31\2LM\5\f\7\2MO\3\2\2\2NJ\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7\25\2\2T\5\3\2\2\2UV\7\r\2\2V"+
		"W\7\60\2\2W[\7\26\2\2XZ\5\4\3\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2"+
		"\2\\^\3\2\2\2][\3\2\2\2^_\7\27\2\2_\7\3\2\2\2`a\5\60\31\2af\5\f\7\2bc"+
		"\7\34\2\2ce\5\f\7\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2"+
		"hf\3\2\2\2ij\7\25\2\2j\t\3\2\2\2kl\7\60\2\2lm\7\30\2\2mn\5\"\22\2no\7"+
		"\31\2\2o\13\3\2\2\2ps\5\16\b\2qs\5\n\6\2rp\3\2\2\2rq\3\2\2\2s\r\3\2\2"+
		"\2tu\7\60\2\2u\17\3\2\2\2vw\5\22\n\2wx\5\64\33\2x\u0085\7\32\2\2yz\5\60"+
		"\31\2z{\5\16\b\2{\u0082\3\2\2\2|}\7\34\2\2}~\5\60\31\2~\177\5\16\b\2\177"+
		"\u0081\3\2\2\2\u0080|\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085y\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\33\2\2\u0088"+
		"\u0089\5\24\13\2\u0089\21\3\2\2\2\u008a\u008d\5\60\31\2\u008b\u008d\7"+
		"\23\2\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d\23\3\2\2\2\u008e"+
		"\u0092\7\26\2\2\u008f\u0091\5\4\3\2\u0090\u008f\3\2\2\2\u0091\u0094\3"+
		"\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0098\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0097\5\26\f\2\u0096\u0095\3\2\2\2\u0097\u009a\3"+
		"\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\27\2\2\u009c\25\3\2\2\2\u009d\u009e\7\6\2"+
		"\2\u009e\u009f\7\32\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\7\33\2\2\u00a1"+
		"\u00a4\5\24\13\2\u00a2\u00a3\7\7\2\2\u00a3\u00a5\5\24\13\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00cd\3\2\2\2\u00a6\u00a7\7\b\2\2\u00a7"+
		"\u00aa\5\16\b\2\u00a8\u00a9\7+\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b3\7\34\2\2\u00ad"+
		"\u00b0\5\16\b\2\u00ae\u00af\7+\2\2\u00af\u00b1\5\"\22\2\u00b0\u00ae\3"+
		"\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b4\5\"\22\2\u00b3"+
		"\u00ad\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\5\24"+
		"\13\2\u00b6\u00cd\3\2\2\2\u00b7\u00b8\7\t\2\2\u00b8\u00b9\5\34\17\2\u00b9"+
		"\u00ba\7\25\2\2\u00ba\u00cd\3\2\2\2\u00bb\u00cd\5\32\16\2\u00bc\u00bd"+
		"\5\36\20\2\u00bd\u00be\5\62\32\2\u00be\u00bf\5\34\17\2\u00bf\u00cd\3\2"+
		"\2\2\u00c0\u00c1\5\36\20\2\u00c1\u00c2\5\62\32\2\u00c2\u00c3\5\34\17\2"+
		"\u00c3\u00c4\7\25\2\2\u00c4\u00cd\3\2\2\2\u00c5\u00c6\5\16\b\2\u00c6\u00c7"+
		"\7+\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\7\25\2\2\u00c9\u00cd\3\2\2\2"+
		"\u00ca\u00cb\7\n\2\2\u00cb\u00cd\7\25\2\2\u00cc\u009d\3\2\2\2\u00cc\u00a6"+
		"\3\2\2\2\u00cc\u00b7\3\2\2\2\u00cc\u00bb\3\2\2\2\u00cc\u00bc\3\2\2\2\u00cc"+
		"\u00c0\3\2\2\2\u00cc\u00c5\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\27\3\2\2"+
		"\2\u00ce\u00cf\5\64\33\2\u00cf\u00d8\7\32\2\2\u00d0\u00d5\5\34\17\2\u00d1"+
		"\u00d2\7\34\2\2\u00d2\u00d4\5\34\17\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00db\7\33\2\2\u00db\31\3\2\2\2\u00dc\u00f1\5\30\r\2\u00dd"+
		"\u00de\5\30\r\2\u00de\u00df\7\25\2\2\u00df\u00f1\3\2\2\2\u00e0\u00e1\7"+
		"\24\2\2\u00e1\u00e2\7\32\2\2\u00e2\u00ec\7\66\2\2\u00e3\u00e4\7\34\2\2"+
		"\u00e4\u00e9\5 \21\2\u00e5\u00e6\7\34\2\2\u00e6\u00e8\5 \21\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\33\2\2\u00ef\u00f1\7\25\2\2\u00f0"+
		"\u00dc\3\2\2\2\u00f0\u00dd\3\2\2\2\u00f0\u00e0\3\2\2\2\u00f1\33\3\2\2"+
		"\2\u00f2\u00f3\b\17\1\2\u00f3\u00ff\5\36\20\2\u00f4\u00ff\5*\26\2\u00f5"+
		"\u00f6\7 \2\2\u00f6\u00ff\5\34\17\6\u00f7\u00ff\5\32\16\2\u00f8\u00f9"+
		"\7&\2\2\u00f9\u00ff\5\34\17\4\u00fa\u00fb\7\32\2\2\u00fb\u00fc\5\34\17"+
		"\2\u00fc\u00fd\7\33\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe"+
		"\u00f4\3\2\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00f7\3\2\2\2\u00fe\u00f8\3\2"+
		"\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0106\3\2\2\2\u0100\u0101\f\7\2\2\u0101"+
		"\u0102\5,\27\2\u0102\u0103\5\34\17\b\u0103\u0105\3\2\2\2\u0104\u0100\3"+
		"\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\35\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010c\5\16\b\2\u010a\u010c\5\n\6"+
		"\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010e"+
		"\7\3\2\2\u010e\u0110\5\36\20\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\37\3\2\2\2\u0111\u0114\5\34\17\2\u0112\u0114\7\66\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0112\3\2\2\2\u0114!\3\2\2\2\u0115\u0116\t\2\2\2\u0116"+
		"#\3\2\2\2\u0117\u0118\t\3\2\2\u0118%\3\2\2\2\u0119\u011a\t\4\2\2\u011a"+
		"\'\3\2\2\2\u011b\u011c\t\5\2\2\u011c)\3\2\2\2\u011d\u0121\5\"\22\2\u011e"+
		"\u0121\7\62\2\2\u011f\u0121\7\65\2\2\u0120\u011d\3\2\2\2\u0120\u011e\3"+
		"\2\2\2\u0120\u011f\3\2\2\2\u0121+\3\2\2\2\u0122\u0127\5.\30\2\u0123\u0127"+
		"\5$\23\2\u0124\u0127\5&\24\2\u0125\u0127\5(\25\2\u0126\u0122\3\2\2\2\u0126"+
		"\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127-\3\2\2\2"+
		"\u0128\u0129\t\6\2\2\u0129/\3\2\2\2\u012a\u0131\7\17\2\2\u012b\u0131\7"+
		"\f\2\2\u012c\u012d\7\r\2\2\u012d\u0131\7\60\2\2\u012e\u0131\5\6\4\2\u012f"+
		"\u0131\7\23\2\2\u0130\u012a\3\2\2\2\u0130\u012b\3\2\2\2\u0130\u012c\3"+
		"\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131\61\3\2\2\2\u0132"+
		"\u0133\t\7\2\2\u0133\63\3\2\2\2\u0134\u0135\7\60\2\2\u0135\65\3\2\2\2"+
		"\37<BP[fr\u0082\u0085\u008c\u0092\u0098\u00a4\u00aa\u00b0\u00b3\u00cc"+
		"\u00d5\u00d8\u00e9\u00ec\u00f0\u00fe\u0106\u010b\u010f\u0113\u0120\u0126"+
		"\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}