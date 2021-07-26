// Generated from c:\Users\Marcos\Documents\Universidad\DecimoSemestre\Compiladores\compiler\Lab-00\Decaf.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "CLASS", "PROGRAM", "IF", "ELSE", "FOR", "RETURN", "BREAK", "CONTINUE", 
			"BOOLEAN", "STRUCT", "CHAR", "INT", "STRING", "TRUE", "FALSE", "VOID", 
			"CALLOUT", "SEMICOLON", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "LROUND", 
			"RROUND", "COMMA", "QUOTES", "APOSTROPHE", "ADD", "SUB", "MULTIPLY", 
			"DIVIDE", "REMINDER", "AND", "OR", "NOT", "GREATER_OP", "LESS_OP", "GREATER_eq_op", 
			"LESS_eq_op", "EQUAL_OP", "ADD_eq_op", "SUB_eq_op", "EQUALITY_OP", "UNEQUALITY_OP", 
			"ID", "LETTER", "CHAR_LITERAL", "DECIMAL_LITERAL", "DIGIT", "HEX_LITERAL", 
			"BOOL_LITERAL", "STRING_LITERAL", "WHITESPACE"
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


	public DecafLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Decaf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0149\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3"+
		"*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\7/\u011a\n/\f/\16/\u011d"+
		"\13/\3\60\3\60\3\61\3\61\3\61\3\61\5\61\u0125\n\61\3\61\3\61\3\62\6\62"+
		"\u012a\n\62\r\62\16\62\u012b\3\63\3\63\3\64\3\64\3\64\6\64\u0133\n\64"+
		"\r\64\16\64\u0134\3\65\3\65\5\65\u0139\n\65\3\66\3\66\3\66\3\66\7\66\u013f"+
		"\n\66\f\66\16\66\u0142\13\66\3\66\3\66\3\67\3\67\3\67\3\67\2\28\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\2g\64i\65k\66m\67\3\2"+
		"\t\5\2C\\aac|\n\2$$))^^ddhhppttvv\6\2\f\f\17\17$$^^\3\2\62;\4\2ZZzz\5"+
		"\2\62;CHch\5\2\13\f\17\17\"\"\2\u014f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2i\3"+
		"\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7w\3\2\2\2\t\177\3"+
		"\2\2\2\13\u0082\3\2\2\2\r\u0087\3\2\2\2\17\u008b\3\2\2\2\21\u0092\3\2"+
		"\2\2\23\u0098\3\2\2\2\25\u00a1\3\2\2\2\27\u00a9\3\2\2\2\31\u00b0\3\2\2"+
		"\2\33\u00b5\3\2\2\2\35\u00b9\3\2\2\2\37\u00c0\3\2\2\2!\u00c5\3\2\2\2#"+
		"\u00cb\3\2\2\2%\u00d0\3\2\2\2\'\u00d8\3\2\2\2)\u00da\3\2\2\2+\u00dc\3"+
		"\2\2\2-\u00de\3\2\2\2/\u00e0\3\2\2\2\61\u00e2\3\2\2\2\63\u00e4\3\2\2\2"+
		"\65\u00e6\3\2\2\2\67\u00e8\3\2\2\29\u00ea\3\2\2\2;\u00ec\3\2\2\2=\u00ee"+
		"\3\2\2\2?\u00f0\3\2\2\2A\u00f2\3\2\2\2C\u00f4\3\2\2\2E\u00f6\3\2\2\2G"+
		"\u00f9\3\2\2\2I\u00fc\3\2\2\2K\u00fe\3\2\2\2M\u0100\3\2\2\2O\u0102\3\2"+
		"\2\2Q\u0105\3\2\2\2S\u0108\3\2\2\2U\u010a\3\2\2\2W\u010d\3\2\2\2Y\u0110"+
		"\3\2\2\2[\u0113\3\2\2\2]\u0116\3\2\2\2_\u011e\3\2\2\2a\u0120\3\2\2\2c"+
		"\u0129\3\2\2\2e\u012d\3\2\2\2g\u012f\3\2\2\2i\u0138\3\2\2\2k\u013a\3\2"+
		"\2\2m\u0145\3\2\2\2op\7\60\2\2p\4\3\2\2\2qr\7e\2\2rs\7n\2\2st\7c\2\2t"+
		"u\7u\2\2uv\7u\2\2v\6\3\2\2\2wx\7R\2\2xy\7t\2\2yz\7q\2\2z{\7i\2\2{|\7t"+
		"\2\2|}\7c\2\2}~\7o\2\2~\b\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7h\2\2"+
		"\u0081\n\3\2\2\2\u0082\u0083\7g\2\2\u0083\u0084\7n\2\2\u0084\u0085\7u"+
		"\2\2\u0085\u0086\7g\2\2\u0086\f\3\2\2\2\u0087\u0088\7h\2\2\u0088\u0089"+
		"\7q\2\2\u0089\u008a\7t\2\2\u008a\16\3\2\2\2\u008b\u008c\7t\2\2\u008c\u008d"+
		"\7g\2\2\u008d\u008e\7v\2\2\u008e\u008f\7w\2\2\u008f\u0090\7t\2\2\u0090"+
		"\u0091\7p\2\2\u0091\20\3\2\2\2\u0092\u0093\7d\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7g\2\2\u0095\u0096\7c\2\2\u0096\u0097\7m\2\2\u0097\22\3\2\2\2\u0098"+
		"\u0099\7e\2\2\u0099\u009a\7q\2\2\u009a\u009b\7p\2\2\u009b\u009c\7v\2\2"+
		"\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u009f\7w\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\24\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4"+
		"\7q\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7v\2\2\u00ab"+
		"\u00ac\7t\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7v\2\2"+
		"\u00af\30\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7j\2\2\u00b2\u00b3\7"+
		"c\2\2\u00b3\u00b4\7t\2\2\u00b4\32\3\2\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7"+
		"\7p\2\2\u00b7\u00b8\7v\2\2\u00b8\34\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb"+
		"\7v\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be"+
		"\u00bf\7i\2\2\u00bf\36\3\2\2\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7t\2\2\u00c2"+
		"\u00c3\7w\2\2\u00c3\u00c4\7g\2\2\u00c4 \3\2\2\2\u00c5\u00c6\7H\2\2\u00c6"+
		"\u00c7\7c\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca\7g\2\2"+
		"\u00ca\"\3\2\2\2\u00cb\u00cc\7x\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7k"+
		"\2\2\u00ce\u00cf\7f\2\2\u00cf$\3\2\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2"+
		"\7c\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7q\2\2\u00d5"+
		"\u00d6\7w\2\2\u00d6\u00d7\7v\2\2\u00d7&\3\2\2\2\u00d8\u00d9\7=\2\2\u00d9"+
		"(\3\2\2\2\u00da\u00db\7}\2\2\u00db*\3\2\2\2\u00dc\u00dd\7\177\2\2\u00dd"+
		",\3\2\2\2\u00de\u00df\7]\2\2\u00df.\3\2\2\2\u00e0\u00e1\7_\2\2\u00e1\60"+
		"\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3\62\3\2\2\2\u00e4\u00e5\7+\2\2\u00e5"+
		"\64\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7\66\3\2\2\2\u00e8\u00e9\7$\2\2\u00e9"+
		"8\3\2\2\2\u00ea\u00eb\7)\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7-\2\2\u00ed<"+
		"\3\2\2\2\u00ee\u00ef\7/\2\2\u00ef>\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1@\3"+
		"\2\2\2\u00f2\u00f3\7\61\2\2\u00f3B\3\2\2\2\u00f4\u00f5\7\'\2\2\u00f5D"+
		"\3\2\2\2\u00f6\u00f7\7(\2\2\u00f7\u00f8\7(\2\2\u00f8F\3\2\2\2\u00f9\u00fa"+
		"\7~\2\2\u00fa\u00fb\7~\2\2\u00fbH\3\2\2\2\u00fc\u00fd\7#\2\2\u00fdJ\3"+
		"\2\2\2\u00fe\u00ff\7@\2\2\u00ffL\3\2\2\2\u0100\u0101\7>\2\2\u0101N\3\2"+
		"\2\2\u0102\u0103\7@\2\2\u0103\u0104\7?\2\2\u0104P\3\2\2\2\u0105\u0106"+
		"\7>\2\2\u0106\u0107\7?\2\2\u0107R\3\2\2\2\u0108\u0109\7?\2\2\u0109T\3"+
		"\2\2\2\u010a\u010b\7-\2\2\u010b\u010c\7?\2\2\u010cV\3\2\2\2\u010d\u010e"+
		"\7/\2\2\u010e\u010f\7?\2\2\u010fX\3\2\2\2\u0110\u0111\7?\2\2\u0111\u0112"+
		"\7?\2\2\u0112Z\3\2\2\2\u0113\u0114\7#\2\2\u0114\u0115\7?\2\2\u0115\\\3"+
		"\2\2\2\u0116\u011b\5_\60\2\u0117\u011a\5_\60\2\u0118\u011a\5e\63\2\u0119"+
		"\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c^\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f"+
		"\t\2\2\2\u011f`\3\2\2\2\u0120\u0124\59\35\2\u0121\u0122\7^\2\2\u0122\u0125"+
		"\t\3\2\2\u0123\u0125\n\4\2\2\u0124\u0121\3\2\2\2\u0124\u0123\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\59\35\2\u0127b\3\2\2\2\u0128\u012a\t\5\2\2"+
		"\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012cd\3\2\2\2\u012d\u012e\t\5\2\2\u012ef\3\2\2\2\u012f\u0130"+
		"\7\62\2\2\u0130\u0132\t\6\2\2\u0131\u0133\t\7\2\2\u0132\u0131\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135h\3"+
		"\2\2\2\u0136\u0139\5\37\20\2\u0137\u0139\5!\21\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0137\3\2\2\2\u0139j\3\2\2\2\u013a\u0140\7$\2\2\u013b\u013c\7^\2\2\u013c"+
		"\u013f\t\3\2\2\u013d\u013f\n\4\2\2\u013e\u013b\3\2\2\2\u013e\u013d\3\2"+
		"\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\7$\2\2\u0144l\3\2\2\2\u0145"+
		"\u0146\t\b\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b\67\2\2\u0148n\3\2\2\2"+
		"\13\2\u0119\u011b\u0124\u012b\u0134\u0138\u013e\u0140\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}