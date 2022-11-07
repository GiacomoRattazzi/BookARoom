/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.models;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Giac
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
