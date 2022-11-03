package bookaroom.v1.models;

//import ch.unil.doplab.grocerystorewebsite.v1.exceptions.InsufficientBalanceException;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author team BookARoom
 */
public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int password;
    private int CCnumber;
    private int CCcode;
    private String CCexpirationdate;
    //TODO: set up booking class:
    private Booking booking;

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password.hashCode();
        this.CCnumber = 0;
        this.CCcode = 0;
        this.CCexpirationdate = "";
        this.booking = new Booking();
    }

    public Booking getBooking() {
        return booking;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    
    public int getPaymentNumber() {
        return CCnumber;
    }
    
    public int getCCCode() {
        return CCcode;
    }
    
    public String getCCExpirationDate() {
        return CCexpirationdate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentNumber(int CCnumber) {
        this.CCnumber = CCnumber;
    }
    
    public void setCCCode(int CCcode) {
         this.CCcode = CCcode;
    }
    
    public void setCCexpirationDate(String CCexpirationdate) {
        this.CCexpirationdate = CCexpirationdate;
    }        

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }
    
    @Override
    public boolean equals(Object obj) {
        return ((User) obj).getUsername().equals(this.username);
    }

    @Override
    public String toString() {
        return "Username: " + this.username
                + "\nFirst name: " + this.firstName
                + "\nLast name: " + this.lastName
                + "\nEmail: " + this.email;
                //+ "\nBalance: " + this.balance
                //+ "\n" + this.shoppingCart.toString();
    }

}
