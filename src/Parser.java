import java.util.LinkedList;

public class Parser {
    int iterator = 0;
    int amountOfExceptions = 0;
    int messagesToConsole = 0;
    public LinkedList<Token> tokens = new LinkedList<Token>();
    public int lengthOfExpression;
    Parser(LinkedList<Token> tokens, int lengthOfExpression) {
        this.tokens = tokens;
        this.lengthOfExpression = lengthOfExpression;
    }

    public void lang() throws ParsingException {
        for (int i = 0; i < lengthOfExpression; i++ ){
            if(iterator < tokens.size()) {
                expr_();
            } else if(iterator == tokens.size() && messagesToConsole == 0){
                if(amountOfExceptions == 0){
                    System.out.println("Parser check has passed successfully!!!");
                } else{
                    System.out.println("Found " + amountOfExceptions + " errors, fix them in order to continue ");
                }
                messagesToConsole += 1;
            }
        }
    }
    public void expr_() throws ParsingException {
        Token currentToken = tokens.get(iterator);
        if (currentToken.type == "WHILE"){
            while_do(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "IF"){
            try {
                IF(currentToken);
            }
            catch (ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }
            iterator++;
            currentToken = tokens.get(iterator);
            try{
                LB(currentToken);
            }
            catch (ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }
            iterator++;
            currentToken = tokens.get(iterator);
            condition(currentToken);
            currentToken = tokens.get(iterator);
            try{
                RB(currentToken);
            }
            catch (ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }
            iterator++;
            currentToken = tokens.get(iterator);
        }
        try {
            var__(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(currentToken, "VAR");
            amountOfExceptions += 1;
        }
        iterator++;
        currentToken = tokens.get(iterator);
        try{
            assign_op(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
        currentToken = tokens.get(iterator);
        while ((currentToken.type != "SEMICOLON") & (currentToken.type != "R_BRACKET") & (currentToken.type != "L_BRACKET") & (currentToken.type != "WHILE")){
            expr_val(currentToken);
            iterator++;
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "WHILE"){
            try {
                WHILE(currentToken);
            }
            catch(ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }
            iterator++;
            currentToken = tokens.get(iterator);
            if (currentToken.type == "L_BRACKET"){
                try{
                    LB(currentToken);
                }
                catch (ParsingException ex){
                    ex.printErrorMessage(ex.token, ex.expected);
                    amountOfExceptions += 1;
                }
                iterator++;
                currentToken = tokens.get(iterator);
                condition(currentToken);
                currentToken = tokens.get(iterator);
                try{
                    RB(currentToken);
                }
                catch (ParsingException ex){
                    ex.printErrorMessage(ex.token, ex.expected);
                    amountOfExceptions += 1;
                }
                iterator++;
            }
        }
        try{
            currentToken = tokens.get(iterator);
            SEMICOLON(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
    }

    public void IF(Token currentToken) throws ParsingException {
        if (currentToken.type != "IF")
            throw new ParsingException(currentToken, "IF");
    }

    public void var__(Token currentToken) throws ParsingException {
        if (currentToken.type != "VAR")
            throw new ParsingException(currentToken, "VAR");
    }
    public void assign_op(Token currentToken) throws ParsingException {
        if (currentToken.type != "ASSIGN_OP")
        {
            throw new ParsingException(currentToken, "ASSIGN_OP");
        }
    }
    public void expr_val(Token currentToken) throws ParsingException {
        if ((currentToken.type == "VAR") | (currentToken.type == "INT"))
            value(currentToken);
        else
            try {
                OP_VALUE(currentToken);
            }
            catch(ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }

    }
    public void value(Token currentToken) throws ParsingException {
        if (currentToken.type == "VAR")
            var__(currentToken);
        else
            try{
                digit__(currentToken);
            }
            catch (ParsingException ex){
                ex.printErrorMessage(ex.token, ex.expected);
                amountOfExceptions += 1;
            }
    }
    public void digit__(Token currentToken) throws ParsingException{
        if (currentToken.type != "INT")
            throw new ParsingException(currentToken, "INT");
    }
    public void OP_VALUE(Token currentToken) throws ParsingException{
        if (currentToken.type != "OPERATORS_LIST")
            throw new ParsingException(currentToken, "OPERATORS_LIST");
    }
    public void while_do(Token currentToken) throws ParsingException {
        WHILE(currentToken);
        iterator++;
        currentToken = tokens.get(iterator);
        try{
            LB(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
        currentToken = tokens.get(iterator);
        condition(currentToken);
        currentToken = tokens.get(iterator);
        try {
            RB(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
    }
    public void LB(Token currentToken) throws ParsingException {
        if (currentToken.type != "L_BRACKET")
            throw new ParsingException(currentToken, "L_BRACKET");
    }
    public void RB(Token currentToken) throws ParsingException{
        if (currentToken.type != "R_BRACKET")
            throw new ParsingException(currentToken, "R_BRACKET");
    }
    public void condition(Token currentToken) throws ParsingException {
        try {
            var__(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
        currentToken = tokens.get(iterator);
        try {
            COMPARISON_OP(currentToken);
        }
        catch (ParsingException ex){
            ex.printErrorMessage(ex.token, ex.expected);
            amountOfExceptions += 1;
        }
        iterator++;
        currentToken = tokens.get(iterator);
        expr_val(currentToken);
        iterator++;
    }
    public void COMPARISON_OP (Token currentToken) throws ParsingException{
        if (currentToken.type != "COMPARISON_OPERATORS")
            throw new ParsingException(currentToken, "COMPARISON_OPERATORS");
    }
    public void WHILE(Token currentToken) throws ParsingException{
        if (currentToken.type != "WHILE")
            throw new ParsingException(currentToken, "WHILE");
    }
    public void SEMICOLON(Token currentToken) throws ParsingException{
        if (currentToken.type != "SEMICOLON")
            throw new ParsingException(currentToken, "SEMICOLON");
    }
}