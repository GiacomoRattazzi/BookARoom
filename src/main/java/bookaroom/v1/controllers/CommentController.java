
package bookaroom.v1.controllers;

import java.util.ArrayList;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.models.Comment;
import bookaroom.v1.models.User;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
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
