package bookaroom.v1.exceptions;

/**
 *
 * @author danie
 */
public class InvalidCreditCardException extends Exception {
    private String message;

    public InvalidCreditCardException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}   