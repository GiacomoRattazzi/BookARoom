/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.controllers;
import static bookaroom.v1.controllers.RoomController.findRoomByNameInTheHotel;
import java.util.ArrayList;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Comment;
import bookaroom.v1.models.Room;
import bookaroom.v1.models.User;
import java.time.LocalDateTime;  
import java.time.YearMonth;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Giac
 */
public class CommentController {
 
    private static String comment = "";
    private static final LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter formatterComment = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            

    public static ArrayList<Comment> getComments() {
        return MockDatabase.getInstance().getComments();
    }
    
    public static String getComment() {
        return comment;
    }
    
    public static void setComment(String comment) {
        CommentController.comment = comment;
    }
    
    public static LocalDateTime getTodayDate() {
        return now;
    }
    

    public static void addCommentFromUser() {
        User user = LoginController.getUserLoggedIn();
        MockDatabase.getInstance().addAComment(new Comment(user.getUsername()+": "+comment+" ("+UserController.getCurrentTimeLong().format(formatterComment)+")"));
        

    }
 
}
