/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.test;

import bookaroom.v1.controllers.RoomController;
import bookaroom.v1.controllers.LoginController;
import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Room;
import bookaroom.v1.models.User;
import bookaroom.v1.database.MockDatabase;
import java.util.ArrayList;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 *
 * @author jingminwang
 */
public class RoomControllerTest {
    
    public RoomControllerTest() {
        System.out.println("FoodControllerTest constructor");
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("@BeforeClass setUpClass");
        // we initialize our UserList (database for users) and add users to it
         MockDatabase.getInstance().addAUser(new User("jwang", "jingmin", "wang", "jingmin.wang@unil.ch", "1234","0000000000000000","123","10/26"));
         MockDatabase.getInstance().addAUser(new User("gratt", "giacomo", "rattazzi", "giacomo.rattazzi@gmail.com", "1234", "0000000000000000","123","10/26"));
         MockDatabase.getInstance().addAUser(new User("danes", "daniel", "do vale anes", "daniel.dovaleanes@gmail.com", "1234","0000000000000000","123","10/26"));
         MockDatabase.getInstance().addAUser(new User("afarh", "ahmed", "farhat", "ahmed.farhat@gmail.com", "1234", "0000000000000000","123","10/26"));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@AfterClass tearDownClass");
        MockDatabase.getInstance().getUsers().clear();
    }
    
    
    
    
}
