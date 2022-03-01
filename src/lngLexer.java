import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lngLexer {
    public static void main(String args[]){
        RegularExpressions regExpEntity = new RegularExpressions();
        LinkedList<Token> listOfTokens = new LinkedList<Token>();

        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        String firstString = "";

        for (int i = 0; i<expression.length(); i++){
            if(expression.toCharArray()[i] == ' '){
                continue;
            } else{
                firstString += expression.toCharArray()[i];
                String secondString = " ";
                if (i < expression.length() - 1) {
                    secondString = firstString + expression.toCharArray()[i + 1];
                }
                for (String key : regExpEntity.lexemsList.keySet()) {
                    Pattern p = Pattern.compile(regExpEntity.lexemsList.get(key));
                    Matcher m_1 = p.matcher(firstString);
                    Matcher m_2 = p.matcher(secondString);
                    if (m_1.find() && !m_2.find()) {
                        listOfTokens.add(new Token(key.toString(), firstString));
                        firstString = "";
                    }
                }
            }
        }
        printListOfTokens(listOfTokens);
    }
    public static void printListOfTokens(LinkedList<Token> listOfTokens){
        for (Token token : listOfTokens) {
            System.out.println("Type of Regular Exp.: "+token.type + "; Token: " + token.value);
        }
    }
}
