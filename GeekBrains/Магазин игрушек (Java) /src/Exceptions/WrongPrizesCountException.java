package Exceptions;

public class WrongPrizesCountException extends ToyLotteryException{
    public WrongPrizesCountException(String message, String text) {
        super(message, text);
    }
}
