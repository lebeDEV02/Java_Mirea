import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Lexer lexer = new Lexer(expression);
        Parser parser = new Parser(lexer.analyse());
        RootTreeNode root = parser.parse();
        Interpreter interpreter = new Interpreter();
        for (int i = 0; i < root.codeStrings.size(); i++) {
            interpreter.run(root.codeStrings.get(i));
        }
    }
}