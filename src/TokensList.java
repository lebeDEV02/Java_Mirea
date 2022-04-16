import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Map;

public class TokensList {

    static Map<String, String> lexemsList = new HashMap<String, String>();
    public TokensList() {
        lexemsList.put("FOR", "^[F][O][R]$");
        lexemsList.put("WHILE","^[W][H][I][L][E]$");
        lexemsList.put("PRINT","^[P][R][I][N][T]$");

        lexemsList.put("INT", "^0|[1-9][0-9]*$");

        lexemsList.put("ASSIGN_OP", "^=$");
        lexemsList.put("PLUS_OP", "^[+]$");
        lexemsList.put("MINUS_OP", "^[-]$");
        lexemsList.put("MULTIPLY_OP", "^[*]$");
        lexemsList.put("DIVIDE_OP", "^[/]$");

        lexemsList.put("LESS", "^[<]$");
        lexemsList.put("MORE", "^[>]$");

        lexemsList.put("SEMICOLON", "^\\;$");
        lexemsList.put("L_BRACKET","^\\($");
        lexemsList.put("R_BRACKET","^\\)$");
        lexemsList.put("L_BRACE","^\\{$");
        lexemsList.put("R_BRACE","^\\}$");
        lexemsList.put("VAR", "^[a-z]+$");
    }
}