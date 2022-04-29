public class TokenType {
    String name;
    String pattern;

    public TokenType(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }
    public static TokenType[] tokenTypeList={
            new TokenType("INT", "^0|[1-9][0-9]*"),

            new TokenType("WHITESPACE", "\\ "),

            new TokenType("ASSIGN", "\\="),

            new TokenType("MINUS", "\\-"),
            new TokenType("PLUS", "\\+"),
            new TokenType("MORE", "\\>"),
            new TokenType("DIVIDE", "\\/"),
            new TokenType("MULTIPLY", "\\*"),
            new TokenType("LESS", "\\<"),
            new TokenType("POW", "(\\*\\*)"),
            new TokenType("EQUALS", "(==)"),

            new TokenType("PRINT", "print"),
            new TokenType("FOR", "for"),
            new TokenType("IF", "if"),
            new TokenType("WHILE","while"),

            new TokenType("SEMICOLON", "\\;"),
            new TokenType("L_BRACE", "\\("),
            new TokenType("R_BRACE", "\\)"),
            new TokenType("L_CURLY_BRACE", "\\{"),
            new TokenType("R_CURLY_BRACE", "\\}"),

            new TokenType("VAR", "[a-z][a-z]*"),
    };
}
