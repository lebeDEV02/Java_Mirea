import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    String code;
    int currentPosition = 0;
    LinkedList<Token> tokenList = new LinkedList<>();

    public Lexer(String code) {
        this.code = code;
    }
    public LinkedList<Token> analyse() {
        while (nextToken()) {}
        for (Token token : tokenList)
            if (!(token.type.name.equals("SEMICOLON")))
                System.out.println("Token: " + token.type.name + ", value: ");
        return this.tokenList;
    }

    public boolean nextToken() {
        TokenType[] allTokenTypes = TokenType.tokenTypeList;
        if (this.currentPosition >= code.length()) {
            return false;
        }
        for (int i = 0; i < allTokenTypes.length; i++) {
            TokenType tokenType = allTokenTypes[i];
            String regex = tokenType.pattern;
            Matcher matcher = Pattern.compile(regex).matcher(code);
            if (matcher.find(this.currentPosition) && matcher.start() == this.currentPosition) {
                String result = this.code.substring(this.currentPosition, this.currentPosition + matcher.group().length());
                Token token = new Token(tokenType, result);
                this.currentPosition += result.length();
                if (token.text.indexOf(' ') != 0)
                    tokenList.add(token);
                return true;
            }
        }
        throw new Error("Ошибка на позиции: " + this.currentPosition);
    }
}
