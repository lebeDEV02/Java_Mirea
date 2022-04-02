public class ParsingException extends Exception{
    String expected;
    Token token;
    public ParsingException(Token _token, String _expected){
        this.token = _token;
        this.expected = _expected;
    }
    public void printErrorMessage(Token _token, String _expected){
        System.out.println("expect " + _expected + " receive " + _token.type);
    }

}
