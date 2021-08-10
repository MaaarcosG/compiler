// Generated from c:\Users\Marcos\Documents\Universidad\DecimoSemestre\Compiladores\compiler\Grammar\Decaf.g4 by ANTLR 4.8
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, ID=38, NUM=39, 
		CHAR=40, SPACES=41, COMMENT=42, LINE_COMMENT=43;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_struct_declar = 2, RULE_var_declar = 3, 
		RULE_structInstantiation = 4, RULE_var_type = 5, RULE_method_declar = 6, 
		RULE_method_type = 7, RULE_parameter = 8, RULE_parameter_type = 9, RULE_block = 10, 
		RULE_statement = 11, RULE_location = 12, RULE_method_call = 13, RULE_arg = 14, 
		RULE_expression = 15, RULE_higher_arith_op = 16, RULE_arith_op = 17, RULE_rel_op = 18, 
		RULE_eq_op = 19, RULE_cond_op = 20, RULE_literal = 21, RULE_int_literal = 22, 
		RULE_char_literal = 23, RULE_bool_literal = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "struct_declar", "var_declar", "structInstantiation", 
			"var_type", "method_declar", "method_type", "parameter", "parameter_type", 
			"block", "statement", "location", "method_call", "arg", "expression", 
			"higher_arith_op", "arith_op", "rel_op", "eq_op", "cond_op", "literal", 
			"int_literal", "char_literal", "bool_literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'Program'", "'{'", "'}'", "'struct'", "';'", "'['", 
			"']'", "'int'", "'char'", "'boolean'", "'void'", "'('", "','", "')'", 
			"'if'", "'else'", "'while'", "'return'", "'='", "'.'", "'-'", "'!'", 
			"'*'", "'/'", "'%'", "'+'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'&&'", "'||'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "NUM", "CHAR", "SPACES", "COMMENT", "LINE_COMMENT"
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
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(T__1);
			setState(52);
			match(T__2);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(53);
				declaration();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
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

	public static class DeclarationContext extends ParserRuleContext {
		public Struct_declarContext struct_declar() {
			return getRuleContext(Struct_declarContext.class,0);
		}
		public Var_declarContext var_declar() {
			return getRuleContext(Var_declarContext.class,0);
		}
		public Method_declarContext method_declar() {
			return getRuleContext(Method_declarContext.class,0);
		}
		public StructInstantiationContext structInstantiation() {
			return getRuleContext(StructInstantiationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				struct_declar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				var_declar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				method_declar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				structInstantiation();
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

	public static class Struct_declarContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
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
			setState(67);
			match(T__4);
			setState(68);
			((Struct_declarContext)_localctx).name = match(ID);
			setState(69);
			match(T__2);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(70);
				var_declar();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(T__3);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(77);
				match(T__5);
				}
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

	public static class Var_declarContext extends ParserRuleContext {
		public Var_typeContext vType;
		public Token name;
		public Token size;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode NUM() { return getToken(DecafParser.NUM, 0); }
		public Var_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declar; }
	}

	public final Var_declarContext var_declar() throws RecognitionException {
		Var_declarContext _localctx = new Var_declarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_declar);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((Var_declarContext)_localctx).vType = var_type();
				setState(81);
				((Var_declarContext)_localctx).name = match(ID);
				setState(82);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((Var_declarContext)_localctx).vType = var_type();
				setState(85);
				((Var_declarContext)_localctx).name = match(ID);
				setState(86);
				match(T__6);
				setState(87);
				((Var_declarContext)_localctx).size = match(NUM);
				setState(88);
				match(T__7);
				setState(89);
				match(T__5);
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

	public static class StructInstantiationContext extends ParserRuleContext {
		public Token struct;
		public Token name;
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public StructInstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInstantiation; }
	}

	public final StructInstantiationContext structInstantiation() throws RecognitionException {
		StructInstantiationContext _localctx = new StructInstantiationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structInstantiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__4);
			setState(94);
			((StructInstantiationContext)_localctx).struct = match(ID);
			setState(95);
			((StructInstantiationContext)_localctx).name = match(ID);
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
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Struct_declarContext struct_declar() {
			return getRuleContext(Struct_declarContext.class,0);
		}
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_type);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(T__10);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(T__4);
				setState(101);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				struct_declar();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				match(T__11);
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

	public static class Method_declarContext extends ParserRuleContext {
		public Method_typeContext returnType;
		public Token name;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Method_declarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_declar; }
	}

	public final Method_declarContext method_declar() throws RecognitionException {
		Method_declarContext _localctx = new Method_declarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((Method_declarContext)_localctx).returnType = method_type();
			setState(107);
			((Method_declarContext)_localctx).name = match(ID);
			setState(108);
			match(T__12);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(109);
				parameter();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(110);
					match(T__13);
					setState(111);
					parameter();
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(T__14);
			setState(123);
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

	public static class Method_typeContext extends ParserRuleContext {
		public Method_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_type; }
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
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

	public static class ParameterContext extends ParserRuleContext {
		public Parameter_typeContext vType;
		public Token name;
		public Parameter_typeContext parameter_type() {
			return getRuleContext(Parameter_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((ParameterContext)_localctx).vType = parameter_type();
				setState(128);
				((ParameterContext)_localctx).name = match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((ParameterContext)_localctx).vType = parameter_type();
				setState(131);
				((ParameterContext)_localctx).name = match(ID);
				setState(132);
				match(T__6);
				setState(133);
				match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				match(T__11);
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

	public static class Parameter_typeContext extends ParserRuleContext {
		public Parameter_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type; }
	}

	public final Parameter_typeContext parameter_type() throws RecognitionException {
		Parameter_typeContext _localctx = new Parameter_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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

	public static class BlockContext extends ParserRuleContext {
		public Var_declarContext decl;
		public StatementContext state;
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
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__2);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(141);
				((BlockContext)_localctx).decl = var_declar();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__12) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				{
				setState(147);
				((BlockContext)_localctx).state = statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext ifblock;
		public BlockContext elseblock;
		public LocationContext left;
		public ExpressionContext right;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__15);
				setState(156);
				match(T__12);
				setState(157);
				expression(0);
				setState(158);
				match(T__14);
				setState(159);
				((StatementContext)_localctx).ifblock = block();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(160);
					match(T__16);
					setState(161);
					((StatementContext)_localctx).elseblock = block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(T__17);
				setState(165);
				match(T__12);
				setState(166);
				expression(0);
				setState(167);
				match(T__14);
				setState(168);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(T__18);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(171);
					expression(0);
					}
				}

				setState(174);
				match(T__5);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				method_call();
				setState(176);
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				((StatementContext)_localctx).left = location();
				setState(180);
				match(T__19);
				setState(181);
				((StatementContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(183);
					expression(0);
					}
				}

				setState(186);
				match(T__5);
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

	public static class LocationContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext expr;
		public LocationContext loc;
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 24, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(189);
				((LocationContext)_localctx).name = match(ID);
				}
				break;
			case 2:
				{
				setState(190);
				((LocationContext)_localctx).name = match(ID);
				setState(191);
				match(T__6);
				setState(192);
				((LocationContext)_localctx).expr = expression(0);
				setState(193);
				match(T__7);
				}
				break;
			}
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(197);
				match(T__20);
				setState(198);
				((LocationContext)_localctx).loc = location();
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

	public static class Method_callContext extends ParserRuleContext {
		public Token method;
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((Method_callContext)_localctx).method = match(ID);
			setState(202);
			match(T__12);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				{
				setState(203);
				arg();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(204);
					match(T__13);
					setState(205);
					arg();
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(T__14);
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

	public static class ArgContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Rel_opContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public RelationOpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MethodCallExprContext extends ExpressionContext {
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public MethodCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ConditionalOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Cond_opContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public ConditionalOpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NegationExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LocationExprContext extends ExpressionContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class EqualityOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Eq_opContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public EqualityOpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NegativeExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegativeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParentExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class HigherArithOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Higher_arith_opContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Higher_arith_opContext higher_arith_op() {
			return getRuleContext(Higher_arith_opContext.class,0);
		}
		public HigherArithOpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ArithOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Arith_opContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Arith_opContext arith_op() {
			return getRuleContext(Arith_opContext.class,0);
		}
		public ArithOpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new MethodCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(221);
				method_call();
				}
				break;
			case 2:
				{
				_localctx = new LocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				location();
				}
				break;
			case 3:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new NegativeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(T__21);
				setState(225);
				expression(3);
				}
				break;
			case 5:
				{
				_localctx = new NegationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(T__22);
				setState(227);
				expression(2);
				}
				break;
			case 6:
				{
				_localctx = new ParentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(T__12);
				setState(229);
				expression(0);
				setState(230);
				match(T__14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new HigherArithOpContext(new ExpressionContext(_parentctx, _parentState));
						((HigherArithOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(235);
						((HigherArithOpContext)_localctx).op = higher_arith_op();
						setState(236);
						((HigherArithOpContext)_localctx).right = expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ArithOpContext(new ExpressionContext(_parentctx, _parentState));
						((ArithOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(239);
						((ArithOpContext)_localctx).op = arith_op();
						setState(240);
						((ArithOpContext)_localctx).right = expression(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationOpContext(new ExpressionContext(_parentctx, _parentState));
						((RelationOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						((RelationOpContext)_localctx).op = rel_op();
						setState(244);
						((RelationOpContext)_localctx).right = expression(7);
						}
						break;
					case 4:
						{
						_localctx = new EqualityOpContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(247);
						((EqualityOpContext)_localctx).op = eq_op();
						setState(248);
						((EqualityOpContext)_localctx).right = expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ConditionalOpContext(new ExpressionContext(_parentctx, _parentState));
						((ConditionalOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(251);
						((ConditionalOpContext)_localctx).op = cond_op();
						setState(252);
						((ConditionalOpContext)_localctx).right = expression(5);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class Higher_arith_opContext extends ParserRuleContext {
		public Higher_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_higher_arith_op; }
	}

	public final Higher_arith_opContext higher_arith_op() throws RecognitionException {
		Higher_arith_opContext _localctx = new Higher_arith_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_higher_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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

	public static class Arith_opContext extends ParserRuleContext {
		public Arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op; }
	}

	public final Arith_opContext arith_op() throws RecognitionException {
		Arith_opContext _localctx = new Arith_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__26) ) {
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
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__32) ) {
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
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !(_la==T__33 || _la==T__34) ) {
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
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				int_literal();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				char_literal();
				}
				break;
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				bool_literal();
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
		public TerminalNode NUM() { return getToken(DecafParser.NUM, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(NUM);
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

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(DecafParser.CHAR, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(CHAR);
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

	public static class Bool_literalContext extends ParserRuleContext {
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u011b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\5\4Q\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bs\n\b"+
		"\f\b\16\bv\13\b\7\bx\n\b\f\b\16\b{\13\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008b\n\n\3\13\3\13\3\f\3\f\7\f\u0091\n"+
		"\f\f\f\16\f\u0094\13\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00af\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bb\n\r"+
		"\3\r\5\r\u00be\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c6\n\16\3\16"+
		"\3\16\5\16\u00ca\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u00d1\n\17\f\17\16"+
		"\17\u00d4\13\17\7\17\u00d6\n\17\f\17\16\17\u00d9\13\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00eb\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0101\n\21\f\21\16\21\u0104"+
		"\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\5\27\u0113\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\2\3 \33\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\n\3\2\13\16\3\2\13\r\3"+
		"\2\32\34\4\2\30\30\35\35\3\2\36!\3\2\"#\3\2$%\3\2&\'\2\u012c\2\64\3\2"+
		"\2\2\4C\3\2\2\2\6E\3\2\2\2\b]\3\2\2\2\n_\3\2\2\2\fj\3\2\2\2\16l\3\2\2"+
		"\2\20\177\3\2\2\2\22\u008a\3\2\2\2\24\u008c\3\2\2\2\26\u008e\3\2\2\2\30"+
		"\u00bd\3\2\2\2\32\u00c5\3\2\2\2\34\u00cb\3\2\2\2\36\u00dc\3\2\2\2 \u00ea"+
		"\3\2\2\2\"\u0105\3\2\2\2$\u0107\3\2\2\2&\u0109\3\2\2\2(\u010b\3\2\2\2"+
		"*\u010d\3\2\2\2,\u0112\3\2\2\2.\u0114\3\2\2\2\60\u0116\3\2\2\2\62\u0118"+
		"\3\2\2\2\64\65\7\3\2\2\65\66\7\4\2\2\66:\7\5\2\2\679\5\4\3\28\67\3\2\2"+
		"\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\6\2\2>\3\3\2"+
		"\2\2?D\5\6\4\2@D\5\b\5\2AD\5\16\b\2BD\5\n\6\2C?\3\2\2\2C@\3\2\2\2CA\3"+
		"\2\2\2CB\3\2\2\2D\5\3\2\2\2EF\7\7\2\2FG\7(\2\2GK\7\5\2\2HJ\5\b\5\2IH\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NP\7\6\2\2OQ\7"+
		"\b\2\2PO\3\2\2\2PQ\3\2\2\2Q\7\3\2\2\2RS\5\f\7\2ST\7(\2\2TU\7\b\2\2U^\3"+
		"\2\2\2VW\5\f\7\2WX\7(\2\2XY\7\t\2\2YZ\7)\2\2Z[\7\n\2\2[\\\7\b\2\2\\^\3"+
		"\2\2\2]R\3\2\2\2]V\3\2\2\2^\t\3\2\2\2_`\7\7\2\2`a\7(\2\2ab\7(\2\2b\13"+
		"\3\2\2\2ck\7\13\2\2dk\7\f\2\2ek\7\r\2\2fg\7\7\2\2gk\7(\2\2hk\5\6\4\2i"+
		"k\7\16\2\2jc\3\2\2\2jd\3\2\2\2je\3\2\2\2jf\3\2\2\2jh\3\2\2\2ji\3\2\2\2"+
		"k\r\3\2\2\2lm\5\20\t\2mn\7(\2\2ny\7\17\2\2ot\5\22\n\2pq\7\20\2\2qs\5\22"+
		"\n\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wo\3\2"+
		"\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7\21\2\2}~\5"+
		"\26\f\2~\17\3\2\2\2\177\u0080\t\2\2\2\u0080\21\3\2\2\2\u0081\u0082\5\24"+
		"\13\2\u0082\u0083\7(\2\2\u0083\u008b\3\2\2\2\u0084\u0085\5\24\13\2\u0085"+
		"\u0086\7(\2\2\u0086\u0087\7\t\2\2\u0087\u0088\7\n\2\2\u0088\u008b\3\2"+
		"\2\2\u0089\u008b\7\16\2\2\u008a\u0081\3\2\2\2\u008a\u0084\3\2\2\2\u008a"+
		"\u0089\3\2\2\2\u008b\23\3\2\2\2\u008c\u008d\t\3\2\2\u008d\25\3\2\2\2\u008e"+
		"\u0092\7\5\2\2\u008f\u0091\5\b\5\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0098\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0097\5\30\r\2\u0096\u0095\3\2\2\2\u0097\u009a\3"+
		"\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\6\2\2\u009c\27\3\2\2\2\u009d\u009e\7\22\2"+
		"\2\u009e\u009f\7\17\2\2\u009f\u00a0\5 \21\2\u00a0\u00a1\7\21\2\2\u00a1"+
		"\u00a4\5\26\f\2\u00a2\u00a3\7\23\2\2\u00a3\u00a5\5\26\f\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00be\3\2\2\2\u00a6\u00a7\7\24\2\2"+
		"\u00a7\u00a8\7\17\2\2\u00a8\u00a9\5 \21\2\u00a9\u00aa\7\21\2\2\u00aa\u00ab"+
		"\5\26\f\2\u00ab\u00be\3\2\2\2\u00ac\u00ae\7\25\2\2\u00ad\u00af\5 \21\2"+
		"\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00be"+
		"\7\b\2\2\u00b1\u00b2\5\34\17\2\u00b2\u00b3\7\b\2\2\u00b3\u00be\3\2\2\2"+
		"\u00b4\u00be\5\26\f\2\u00b5\u00b6\5\32\16\2\u00b6\u00b7\7\26\2\2\u00b7"+
		"\u00b8\5 \21\2\u00b8\u00be\3\2\2\2\u00b9\u00bb\5 \21\2\u00ba\u00b9\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\7\b\2\2\u00bd"+
		"\u009d\3\2\2\2\u00bd\u00a6\3\2\2\2\u00bd\u00ac\3\2\2\2\u00bd\u00b1\3\2"+
		"\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be"+
		"\31\3\2\2\2\u00bf\u00c6\7(\2\2\u00c0\u00c1\7(\2\2\u00c1\u00c2\7\t\2\2"+
		"\u00c2\u00c3\5 \21\2\u00c3\u00c4\7\n\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00bf"+
		"\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\7\27\2\2"+
		"\u00c8\u00ca\5\32\16\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\33"+
		"\3\2\2\2\u00cb\u00cc\7(\2\2\u00cc\u00d7\7\17\2\2\u00cd\u00d2\5\36\20\2"+
		"\u00ce\u00cf\7\20\2\2\u00cf\u00d1\5\36\20\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00cd\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00db\7\21\2\2\u00db\35\3\2\2\2\u00dc\u00dd\5 \21\2\u00dd\37"+
		"\3\2\2\2\u00de\u00df\b\21\1\2\u00df\u00eb\5\34\17\2\u00e0\u00eb\5\32\16"+
		"\2\u00e1\u00eb\5,\27\2\u00e2\u00e3\7\30\2\2\u00e3\u00eb\5 \21\5\u00e4"+
		"\u00e5\7\31\2\2\u00e5\u00eb\5 \21\4\u00e6\u00e7\7\17\2\2\u00e7\u00e8\5"+
		" \21\2\u00e8\u00e9\7\21\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00de\3\2\2\2\u00ea"+
		"\u00e0\3\2\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00e4\3\2"+
		"\2\2\u00ea\u00e6\3\2\2\2\u00eb\u0102\3\2\2\2\u00ec\u00ed\f\n\2\2\u00ed"+
		"\u00ee\5\"\22\2\u00ee\u00ef\5 \21\13\u00ef\u0101\3\2\2\2\u00f0\u00f1\f"+
		"\t\2\2\u00f1\u00f2\5$\23\2\u00f2\u00f3\5 \21\n\u00f3\u0101\3\2\2\2\u00f4"+
		"\u00f5\f\b\2\2\u00f5\u00f6\5&\24\2\u00f6\u00f7\5 \21\t\u00f7\u0101\3\2"+
		"\2\2\u00f8\u00f9\f\7\2\2\u00f9\u00fa\5(\25\2\u00fa\u00fb\5 \21\b\u00fb"+
		"\u0101\3\2\2\2\u00fc\u00fd\f\6\2\2\u00fd\u00fe\5*\26\2\u00fe\u00ff\5 "+
		"\21\7\u00ff\u0101\3\2\2\2\u0100\u00ec\3\2\2\2\u0100\u00f0\3\2\2\2\u0100"+
		"\u00f4\3\2\2\2\u0100\u00f8\3\2\2\2\u0100\u00fc\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103!\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0106\t\4\2\2\u0106#\3\2\2\2\u0107\u0108\t\5\2\2\u0108"+
		"%\3\2\2\2\u0109\u010a\t\6\2\2\u010a\'\3\2\2\2\u010b\u010c\t\7\2\2\u010c"+
		")\3\2\2\2\u010d\u010e\t\b\2\2\u010e+\3\2\2\2\u010f\u0113\5.\30\2\u0110"+
		"\u0113\5\60\31\2\u0111\u0113\5\62\32\2\u0112\u010f\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0111\3\2\2\2\u0113-\3\2\2\2\u0114\u0115\7)\2\2\u0115/"+
		"\3\2\2\2\u0116\u0117\7*\2\2\u0117\61\3\2\2\2\u0118\u0119\t\t\2\2\u0119"+
		"\63\3\2\2\2\31:CKP]jty\u008a\u0092\u0098\u00a4\u00ae\u00ba\u00bd\u00c5"+
		"\u00c9\u00d2\u00d7\u00ea\u0100\u0102\u0112";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}