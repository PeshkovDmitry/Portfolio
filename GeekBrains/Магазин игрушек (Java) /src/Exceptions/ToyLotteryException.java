package Exceptions;

public class ToyLotteryException extends Exception{
    private String text;
    public ToyLotteryException(String message, String text) {
        super(message);
        this.text = text;
    }
}
