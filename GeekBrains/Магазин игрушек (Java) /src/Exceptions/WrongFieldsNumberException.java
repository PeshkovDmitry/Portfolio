package Exceptions;

public class WrongFieldsNumberException extends ToyLotteryException{
    public WrongFieldsNumberException(String message, String text, Integer fieldsCount) {
        super(message, text);
        this.fieldsCount = fieldsCount;    }
    private Integer fieldsCount;
}
