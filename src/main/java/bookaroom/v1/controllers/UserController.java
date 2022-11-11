
package bookaroom.v1.controllers;

import bookaroom.v1.exceptions.AlreadyExistsException;
import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.exceptions.InvalidCreditCardException;
import bookaroom.v1.exceptions.InvalidCreditCardDateException;
import bookaroom.v1.models.User;
import bookaroom.v1.database.MockDatabase;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
    
/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */

public class UserController {

    private static String username = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String password = "";
    private static String CCnumber = "";
    private static String CCcode = "";
    private static String CCexpirationdate = "";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
    private static final YearMonth CurrentTime = YearMonth.now();
    private static final DateTimeFormatter Dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final LocalDate CurrentTimeLong = LocalDate.now();
   
    // all of this doesn't work (emailExists, ccNumberCorrect, usernameExists, ExpiredCC) => test ?
    
    public static void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                MockDatabase.getInstance().addAUser(new User(username, firstName, lastName, email, password, CCnumber, CCcode, CCexpirationdate));
            }
        } catch (AlreadyExistsException | DoesNotExistException ex ) {
            System.out.println(ex.getMessage());
        }
    }   
    
    protected static User findByUsername(String username) throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    protected static boolean emailExists() throws AlreadyExistsException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already in use.");
            }
        }
        return false;
    }
    
    protected static boolean ccNumberCorrect() throws InvalidCreditCardException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getCCnumber() !=16) {
                throw new InvalidCreditCardException("this shit wrong");
            }
        }
        return false;
    }

    protected static boolean usernameExists() throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                throw new DoesNotExistException("The username " + username + " already in use.");
            }
        }
        return false;
    }
    
    protected static boolean ExpiredCC() throws InvalidCreditCardDateException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            YearMonth userexpdateFormat = YearMonth.parse(user.getCCExpirationDate(), formatter); 
            boolean expired = CurrentTime.isBefore(userexpdateFormat);
                    if (expired==true) {
                        System.out.println("Credit Card is still valid.");
                    } else {
                        throw new InvalidCreditCardDateException("Credit Card has expired.");
                    } 
        }
        return false;
    }

    public static String getEmail() {
        return email;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
        
    public static String getCCnumber() {
        return CCnumber;
    }
    
    public static String getCCCode() {
        return CCcode;
    }
    
    public static String getCCExpirationDate() {
        return CCexpirationdate;
    }
    
    public static YearMonth getCurrentTime() {
        return CurrentTime;
    }

    public static LocalDate getCurrentTimeLong() {
        return CurrentTimeLong;
    }
    
    
    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
    
    public static DateTimeFormatter getDateFormatter() {
        return Dateformatter;
    }
    
    public static void setEmail(String email) {
        UserController.email = email;
    }

    public static void setFirstName(String firstName) {
        UserController.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        UserController.lastName = lastName;
    }

    public static void setPassword(String password) {
        UserController.password = password;
    }

    public static void setUsername(String username) {
        UserController.username = username;
    }
    
    public static void setCCnumber(String CCnumber) {
         UserController.CCnumber = CCnumber;
    }
    
    public static void setCCcode(String CCcode) {
         UserController.CCcode = CCcode;
    }
    
    public static void setCCexpirationDate(String CCexpirationdate) {
        UserController.CCexpirationdate = CCexpirationdate;
    } 
    
    public static void completeBooking() {
        try {
            LoginController.getUserLoggedIn().completeBooking();
        } catch (InvalidCreditCardDateException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

}
