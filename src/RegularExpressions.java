import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Map;

public class RegularExpressions {

    static Map<String, String> lexemsList = new HashMap<String, String>();
    public RegularExpressions() {
        lexemsList.put("STRING", "^\"[0-9a-zA-Z*\\/&s ]*\"|str(\"[0-9a-zA-Z*\\/&s ]*\")$");
        lexemsList.put("INT", "^0|[1-9][0-9]*$");
        lexemsList.put("ASSIGN_OP", "^=$");
        lexemsList.put("VAR", "^[a-z][a-z0-9]*$");
        lexemsList.put("OPERATORS_LIST", "^[-|+|/|*]$");
    }
}
