import java.util.Stack;

public class PolishNotationCalculator {

    public static String convertInfixToPolish(String expression) {
        int priorityOfOperation;
        String currentString = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            priorityOfOperation = getPriorityOfOperation(expression.charAt(i));

            if (priorityOfOperation == 0) {
                currentString += expression.charAt(i);
            }

            if (priorityOfOperation == 1) {
                stack.push(expression.charAt(i));
            }

            if(priorityOfOperation > 1){
                currentString += " ";

                while(!stack.empty()){
                    if(getPriorityOfOperation(stack.peek()) > priorityOfOperation){
                        currentString += stack.pop();
                    } else{
                        break;
                    }
                }
                stack.push(expression.charAt(i));
            }

            if(priorityOfOperation == -1){
                currentString += " ";
                while(getPriorityOfOperation(stack.peek()) != 1){
                    currentString += stack.pop();
                }
                stack.pop();
            }
        }
        while(!stack.empty()){
            currentString += stack.pop();
        }
        return currentString;
    }

    public static double returnExpressionAnswer(String polishNotationExpr){
        String operand = new String();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < polishNotationExpr.length(); i++) {
            if (polishNotationExpr.charAt(i) == ' ') {
                continue;
            }

            if(getPriorityOfOperation(polishNotationExpr.charAt(i)) == 0){
                while (polishNotationExpr.charAt(i) != ' ' && getPriorityOfOperation(polishNotationExpr.charAt(i)) == 0) {
                    operand += polishNotationExpr.charAt(i++);
                    if(i == polishNotationExpr.length()){
                        break;
                    }
                }

                    stack.push(Double.parseDouble(operand));
                    operand = new String();
            }

            if(getPriorityOfOperation(polishNotationExpr.charAt(i)) > 1){
                double firstOperand = stack.pop();
                double secondOperand = stack.pop();

                if(polishNotationExpr.charAt(i) == '+'){
                    stack.push(firstOperand + secondOperand);
                } else if(polishNotationExpr.charAt(i) == '-') {
                    stack.push(firstOperand - secondOperand);
                } else if(polishNotationExpr.charAt(i) == '*') {
                    stack.push(firstOperand * secondOperand);
                } else if(polishNotationExpr.charAt(i) == '/') {
                    stack.push(firstOperand / secondOperand);
                }
            }
        }
        return stack.pop();
    }

    public static int getPriorityOfOperation(char operation){
        if(operation == '*' || operation == '/'){
            return 3;
        } else if(operation == '+' || operation == '-'){
            return 2;
        } else if (operation == '('){
            return 1;
        } else if (operation == ')'){
            return -1;
        } else{
            return 0;
        }
    }
}
