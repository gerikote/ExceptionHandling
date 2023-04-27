package exceptions;

public class NegativeAmountException extends Exception {
    public NegativeAmountException(String msg){
        super(msg);
    }
}
