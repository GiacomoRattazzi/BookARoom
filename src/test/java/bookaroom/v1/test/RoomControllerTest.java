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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author Team BookARoom
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
    
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod setUp");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod tearDown");
    }

    // test IndexOutOfBoundsException
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        System.out.println("@Test testIndexOutOfBoundsException");
        MockDatabase.getInstance().getUsers().get(100);
    }

    // test timeout
    @Test(timeOut = 1000)
    public void testTimeOut() throws InterruptedException {
        System.out.println("@Test testTimeOut");
        Thread.sleep(500);
    }
    
}
