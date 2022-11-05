package bookaroom.v1.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class InvalidCreditCardDateException extends Exception {
    private String message;
    
    public InvalidCreditCardDateException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
