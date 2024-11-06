/* Generated By:JavaCC: Do not edit this line. JavaCCParserConstants.java */
package jminusminus;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface JavaCCParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int BEGIN_COMMENT = 6;
  /** RegularExpression Id. */
  int END_COMMENT = 7;
  /** RegularExpression Id. */
  int COMMENT = 8;
  /** RegularExpression Id. */
  int BEGIN_MULTI_LINE_COMMENT = 9;
  /** RegularExpression Id. */
  int END_MULTI_LINE_COMMENT = 10;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 11;
  /** RegularExpression Id. */
  int ABSTRACT = 12;
  /** RegularExpression Id. */
  int BOOLEAN = 13;
  /** RegularExpression Id. */
  int CHAR = 14;
  /** RegularExpression Id. */
  int CLASS = 15;
  /** RegularExpression Id. */
  int ELSE = 16;
  /** RegularExpression Id. */
  int EXTENDS = 17;
  /** RegularExpression Id. */
  int FALSE = 18;
  /** RegularExpression Id. */
  int IF = 19;
  /** RegularExpression Id. */
  int IMPORT = 20;
  /** RegularExpression Id. */
  int INSTANCEOF = 21;
  /** RegularExpression Id. */
  int INT = 22;
  /** RegularExpression Id. */
  int NEW = 23;
  /** RegularExpression Id. */
  int NULL = 24;
  /** RegularExpression Id. */
  int PACKAGE = 25;
  /** RegularExpression Id. */
  int PRIVATE = 26;
  /** RegularExpression Id. */
  int PROTECTED = 27;
  /** RegularExpression Id. */
  int PUBLIC = 28;
  /** RegularExpression Id. */
  int RETURN = 29;
  /** RegularExpression Id. */
  int STATIC = 30;
  /** RegularExpression Id. */
  int SUPER = 31;
  /** RegularExpression Id. */
  int THIS = 32;
  /** RegularExpression Id. */
  int TRUE = 33;
  /** RegularExpression Id. */
  int VOID = 34;
  /** RegularExpression Id. */
  int WHILE = 35;
  /** RegularExpression Id. */
  int BREAK = 36;
  /** RegularExpression Id. */
  int CASE = 37;
  /** RegularExpression Id. */
  int CONTINUE = 38;
  /** RegularExpression Id. */
  int DEFAULT_TOKEN = 39;
  /** RegularExpression Id. */
  int DO = 40;
  /** RegularExpression Id. */
  int DOUBLE = 41;
  /** RegularExpression Id. */
  int FOR = 42;
  /** RegularExpression Id. */
  int LONG = 43;
  /** RegularExpression Id. */
  int SWITCH = 44;
  /** RegularExpression Id. */
  int COMMA = 45;
  /** RegularExpression Id. */
  int DOT = 46;
  /** RegularExpression Id. */
  int LBRACK = 47;
  /** RegularExpression Id. */
  int LCURLY = 48;
  /** RegularExpression Id. */
  int LPAREN = 49;
  /** RegularExpression Id. */
  int RPAREN = 50;
  /** RegularExpression Id. */
  int RBRACK = 51;
  /** RegularExpression Id. */
  int RCURLY = 52;
  /** RegularExpression Id. */
  int SEMI = 53;
  /** RegularExpression Id. */
  int ASSIGN = 54;
  /** RegularExpression Id. */
  int DEC = 55;
  /** RegularExpression Id. */
  int EQUAL = 56;
  /** RegularExpression Id. */
  int GT = 57;
  /** RegularExpression Id. */
  int INC = 58;
  /** RegularExpression Id. */
  int LAND = 59;
  /** RegularExpression Id. */
  int LE = 60;
  /** RegularExpression Id. */
  int LNOT = 61;
  /** RegularExpression Id. */
  int MINUS = 62;
  /** RegularExpression Id. */
  int PLUS = 63;
  /** RegularExpression Id. */
  int PLUS_ASSIGN = 64;
  /** RegularExpression Id. */
  int STAR = 65;
  /** RegularExpression Id. */
  int DIV = 66;
  /** RegularExpression Id. */
  int MOD = 67;
  /** RegularExpression Id. */
  int QUESTION = 68;
  /** RegularExpression Id. */
  int LT = 69;
  /** RegularExpression Id. */
  int LOR = 70;
  /** RegularExpression Id. */
  int MINUS_ASSIGN = 71;
  /** RegularExpression Id. */
  int STAR_ASSIGN = 72;
  /** RegularExpression Id. */
  int DIV_ASSIGN = 73;
  /** RegularExpression Id. */
  int COLON = 74;
  /** RegularExpression Id. */
  int GE = 75;
  /** RegularExpression Id. */
  int MOD_ASSIGN = 76;
  /** RegularExpression Id. */
  int NOT_EQUAL = 77;
  /** RegularExpression Id. */
  int IDENTIFIER = 78;
  /** RegularExpression Id. */
  int LETTER = 79;
  /** RegularExpression Id. */
  int DIGIT = 80;
  /** RegularExpression Id. */
  int INT_LITERAL = 81;
  /** RegularExpression Id. */
  int LONG_LITERAL = 82;
  /** RegularExpression Id. */
  int CHAR_LITERAL = 83;
  /** RegularExpression Id. */
  int STRING_LITERAL = 84;
  /** RegularExpression Id. */
  int DIGITS = 85;
  /** RegularExpression Id. */
  int ESC = 86;
  /** RegularExpression Id. */
  int DOUBLE_LITERAL = 87;
  /** RegularExpression Id. */
  int EXPONENT = 88;
  /** RegularExpression Id. */
  int SUFFIX = 89;
  /** RegularExpression Id. */
  int ERROR = 90;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMENT = 1;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"//\"",
    "<END_COMMENT>",
    "<COMMENT>",
    "\"/*\"",
    "\"*/\"",
    "<MULTI_LINE_COMMENT>",
    "\"abstract\"",
    "\"boolean\"",
    "\"char\"",
    "\"class\"",
    "\"else\"",
    "\"extends\"",
    "\"false\"",
    "\"if\"",
    "\"import\"",
    "\"instanceof\"",
    "\"int\"",
    "\"new\"",
    "\"null\"",
    "\"package\"",
    "\"private\"",
    "\"protected\"",
    "\"public\"",
    "\"return\"",
    "\"static\"",
    "\"super\"",
    "\"this\"",
    "\"true\"",
    "\"void\"",
    "\"while\"",
    "\"break\"",
    "\"case\"",
    "\"continue\"",
    "\"default\"",
    "\"do\"",
    "\"double\"",
    "\"for\"",
    "\"long\"",
    "\"switch\"",
    "\",\"",
    "\".\"",
    "\"[\"",
    "\"{\"",
    "\"(\"",
    "\")\"",
    "\"]\"",
    "\"}\"",
    "\";\"",
    "\"=\"",
    "\"--\"",
    "\"==\"",
    "\">\"",
    "\"++\"",
    "\"&&\"",
    "\"<=\"",
    "\"!\"",
    "\"-\"",
    "\"+\"",
    "\"+=\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"?\"",
    "\"<\"",
    "\"||\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\":\"",
    "\">=\"",
    "\"%=\"",
    "\"!=\"",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "<INT_LITERAL>",
    "<LONG_LITERAL>",
    "<CHAR_LITERAL>",
    "<STRING_LITERAL>",
    "<DIGITS>",
    "<ESC>",
    "<DOUBLE_LITERAL>",
    "<EXPONENT>",
    "<SUFFIX>",
    "<ERROR>",
  };

}
