import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Map;

public class RegularExpressions {

    static Map<String, String> lexemsList = new HashMap<String, String>();
    public RegularExpressions() {
        lexemsList.put("IF", "^[I][F]$");
        lexemsList.put("WHILE","^[W][H][I][L][E]$");
        lexemsList.put("INT", "^0|[1-9][0-9]*$");
        lexemsList.put("ASSIGN_OP", "^=$");
        lexemsList.put("OPERATORS_LIST", "^[-|+|/|*]$");
        lexemsList.put("SEMICOLON", "^\\;$");
        lexemsList.put("COMPARISON_OPERATORS", "^[>|<|~]$");
        lexemsList.put("L_BRACKET","^\\($");
        lexemsList.put("R_BRACKET","^\\)$");
        lexemsList.put("L_BRACE","^\\{$");
        lexemsList.put("R_BRACE","^\\}$");
        lexemsList.put("VAR", "^[a-z0-9]+$");
    }
}
