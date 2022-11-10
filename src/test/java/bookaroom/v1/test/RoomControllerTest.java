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
import bookaroom.v1.database.MockDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * @author Team BookARoom
 */
public class RoomControllerTest {
    
    public RoomControllerTest() {
        System.out.println("RoomControllerTest constructor");
    }
    
    @Test
    public void testAddRoomToBooking() throws DoesNotExistException {
        System.out.println("@Test testAddRoomToBooking");
        
        // login as a user
        LoginController.setUsername("afarh");
        LoginController.setPassword("1234");
        LoginController.userLogsIn();
        
        // we need some mock data
        MockDatabase.getInstance().addRoom(new Room("Room 1", 200, new ArrayList<String>() {
            {
                add("One double bed");
                add("Maximum capacity: 1"); 
                add("r001");
            }
        }, new ArrayList<> (Arrays.asList())
        ));
        
        String roomName = "Room 1";
    
        // add the room to the booking
        RoomController.setRoomName(roomName);
        RoomController.addRoomToBooking();
        
        // find the room in the booking
        Room expectedRoom = null;
        for (Room r : LoginController.getUserLoggedIn().getBooking().getRooms()) {
            if (r.getName().equals(roomName)) {
                expectedRoom = r;
            }
        }
        // if the rood exists, expectedRoom must have a value
        Assert.assertNotNull(expectedRoom);
    }
    
    @Test(expectedExceptions = NumberFormatException.class)
    public void testNumberFormatException() {
        System.out.println("@Test testNumberFormatException");
        int n = Integer.parseInt(null);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void testClassCastException() {
        System.out.println("@Test testClassCastException");
        Object o = Integer.valueOf(42);
        String s = (String) o;

    }
}
