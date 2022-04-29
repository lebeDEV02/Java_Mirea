import java.util.LinkedList;

public class Parser {
    LinkedList<Token> tokens;
    int tokenPosition = 0;

    public Parser(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }

    public Token retCurrent(String[] need) {
        if (tokenPosition < tokens.size()) {
            Token curToken = tokens.get(tokenPosition);
            for (String tokenTypeName : need)
                if (tokenTypeName.equals(curToken.type.name)) {
                    tokenPosition++;
                    return curToken;
                }
        }
        return null;
    }

    public void require(String[] expected) {
        Token token = retCurrent(expected);
        if (token == null) {
            throw new Error("На позиции " + tokenPosition + " ожидается токен " + expected[0]);
        }
    }

    public RootTreeNode parse() {
        RootTreeNode rootTree = new RootTreeNode();
        while (tokenPosition < tokens.size()) {
            TopTreeNode codeString = parserString();
            require(new String[]{"SEMICOLON"});
            rootTree.addNode(codeString);
        }
        return rootTree;
    }

    public TopTreeNode parserString(){
        if (tokens.get(tokenPosition).type.name.equals("VAR")) {
            TopTreeNode varNode = parserVarNumber();
            Token assign = retCurrent(new String[]{"ASSIGN"});
            if (assign != null) {
                TopTreeNode rightVal = parserFormula();
                return new BinOperationTreeNode(assign, varNode, rightVal);
            }
            throw new Error("После переменной ожидается оператор присвоения на позиции " + this.tokenPosition);
        }
        else if (tokens.get(tokenPosition).type.name.equals("PRINT")) {
            tokenPosition++;
            return new UnarOperationTreeNode(tokens.get(tokenPosition-1), this.parserFormula());
        }
        else if (tokens.get(tokenPosition).type.name.equals("WHILE")) {
            tokenPosition++;
            return  parserWhile();
        }
        else if (tokens.get(tokenPosition).type.name.equals("FOR")) {
            tokenPosition++;
            return parserFor();
        }
        else if (tokens.get(tokenPosition).type.name.equals("IF")) {
            tokenPosition++;
            return parserIf();
        }
        throw new Error("Ожидалось действие или переменная на позиции: " + tokenPosition);
    }

    public TopTreeNode parserVarNumber() { // простейший случай формулы
        if (tokens.get(tokenPosition).type.name.equals("INT")){
            tokenPosition++;
            return new NumberTreeNode(tokens.get(tokenPosition-1));
        }
        if (tokens.get(tokenPosition).type.name.equals("VAR")){
            tokenPosition++;
            return new VarTreeNode(tokens.get(tokenPosition-1));
        }

        throw new Error("Ожидалась переменная или число на позиции " + tokenPosition);
    }

    public TopTreeNode parserParentheses() {
        if (tokens.get(tokenPosition).type.name.equals("L_BRACE")) {
            tokenPosition++;
            TopTreeNode node = parserFormula();
            require(new String[]{"R_BRACE"});
            return node;
        }
        else {
            return parserVarNumber();
        }
    }

    public TopTreeNode parserFormula(){
        TopTreeNode leftVal = parserMultDiv();
        Token operator = retCurrent(new String[]{"PLUS","MINUS","POW"});
        while (operator != null){
            TopTreeNode rightVal = parserMultDiv();
            leftVal = new BinOperationTreeNode(operator, leftVal, rightVal);
            operator = retCurrent(new String[]{"PLUS","MINUS", "POW"});
        }
        return leftVal;
    }

    public TopTreeNode getOperations() {
        TopTreeNode codeStringNode = parserString();
        require(new String[]{"SEMICOLON"});
        return codeStringNode;
    }

    public TopTreeNode parserMultDiv() {
        TopTreeNode leftNode = parserParentheses();
        Token operator = retCurrent(new String[]{"MULTIPLY","DIVIDE"});
        while (operator != null) {
            TopTreeNode rightVal = parserParentheses();
            leftNode = new BinOperationTreeNode(operator, leftNode, rightVal);
            operator = retCurrent(new String[]{"MULTIPLY","DIVIDE"});
        }
        return leftNode;
    }

    public TopTreeNode parserFor() {
        TopTreeNode leftVal = parserFormula();
        Token operator = retCurrent(new String[]{"LESS", "MORE", "EQUALS"});
        TopTreeNode rightVal = parserFormula();
        require(new String[]{"SEMICOLON"});
        TopTreeNode varNode = parserVarNumber();
        Token assign = retCurrent(new String[]{"ASSIGN"});
        TopTreeNode rightActVal = parserFormula();
        BinOperationTreeNode action = new BinOperationTreeNode(assign, varNode, rightActVal);
        if (assign == null)
            throw new Error("После переменной ожидается '=' на позиции:" + tokenPosition);
        ForTreeNode forNode = new ForTreeNode(operator, leftVal, rightVal, action);
        require(new String[]{"L_CURLY_BRACE"});
        while(!tokens.get(tokenPosition).type.name.equals("R_CURLY_BRACE")) {
            forNode.addOperations(getOperations());
            if (tokenPosition == tokens.size())
                throw new Error("Ошибка, ожидалось '}'");
        }
        tokenPosition++;
        return forNode;
    }

    public TopTreeNode parserWhile() {
        TopTreeNode leftVal = parserFormula();
        Token operator = retCurrent(new String[]{"LESS", "MORE", "EQUALS"});
        TopTreeNode rightVal = parserFormula();
        WhileTreeNode whileNode = new WhileTreeNode(operator, leftVal, rightVal);
        require(new String[]{"L_CURLY_BRACE"});
        while (!tokens.get(tokenPosition).type.name.equals("R_CURLY_BRACE")) {
            whileNode.addOperations(getOperations());
            if (tokenPosition == tokens.size())
                throw new Error("Ожидалось '}' на позиции" + tokenPosition);
        }
        tokenPosition++;
        return whileNode;
    }

    TopTreeNode parserIf() {
        TopTreeNode leftVal = parserFormula();
        Token operator = retCurrent(new String[]{"LESS", "MORE", "EQUALS"});
        TopTreeNode rightVal = parserFormula();
        IfTreeNode ifNode = new IfTreeNode(operator, leftVal, rightVal);
        require(new String[]{"L_CURLY_BRACE"});
        while (!tokens.get(tokenPosition).type.name.equals("R_CURLY_BRACE")) {
            ifNode.addOperations(getOperations());
            if (tokenPosition == tokens.size())
                throw new Error("Ожидалось '}' на позиции" + tokenPosition);
        }
        tokenPosition++;
        return ifNode;
    }
}