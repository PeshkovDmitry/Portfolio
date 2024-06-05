package Exceptions;

public class WrongIdException extends ToyLotteryException{
    public WrongIdException(String message, String text) {
        super(message, text);
    }
}
