package Exceptions;

public class WrongWeightException extends ToyLotteryException{
    public WrongWeightException(String message, String text) {
        super(message, text);
    }
}
