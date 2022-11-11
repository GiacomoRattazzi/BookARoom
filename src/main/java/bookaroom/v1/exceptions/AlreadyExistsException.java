
package bookaroom.v1.exceptions;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */

public class AlreadyExistsException extends Exception {

    private String message;

    public AlreadyExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
