package Exceptions;

public class AbstractException extends Exception {

    public AbstractException(String message, String text) {
        super(message);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private String text;
}
