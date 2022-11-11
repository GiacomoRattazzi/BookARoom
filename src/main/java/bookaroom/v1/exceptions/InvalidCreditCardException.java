package bookaroom.v1.exceptions;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
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