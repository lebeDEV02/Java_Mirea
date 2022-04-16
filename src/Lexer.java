import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    String userInput;
    LinkedList<Token> listOfTokens = new LinkedList<>();

    public Lexer(String userInput){
        this.userInput = userInput;
    }

    public void doLexicalAnalysis(){
        TokensList regExpEntity = new TokensList();

        String firstString = "";

        for (int i = 0; i<userInput.length(); i++){
            if(userInput.toCharArray()[i] == ' '){
                continue;
            } else{
                firstString += userInput.toCharArray()[i];
                String secondString = " ";
                if (i < userInput.length() - 1) {
                    secondString = firstString + userInput.toCharArray()[i + 1];
                }
                for (String key : regExpEntity.lexemsList.keySet()) {
                    Pattern p = Pattern.compile(regExpEntity.lexemsList.get(key));
                    Matcher m_1 = p.matcher(firstString);
                    Matcher m_2 = p.matcher(secondString);
                    if (m_1.find() && !m_2.find()) {
                        listOfTokens.add(new Token(key, firstString));
                        firstString = "";
                    }
                }
            }
        }
    }
    public LinkedList<Token> printListOfTokens(){
        doLexicalAnalysis();
        for (Token token : listOfTokens) {
            System.out.println("Type of Regular Exp.: "+token.type + "; Token: " + token.value);
        }
        return this.listOfTokens;
    }

}