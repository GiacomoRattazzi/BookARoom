
package bookaroom.v1.models;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */

public class Comment {
    private String comment;
    
    public Comment(String comment) {
            this.comment = comment;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
       }

    
    @Override
    public String toString() {
        return "\n" +"\""+comment+"\"";
       
    }
    }
