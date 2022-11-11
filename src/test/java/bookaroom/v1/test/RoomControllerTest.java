/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.test;

import bookaroom.v1.controllers.RoomController;
import bookaroom.v1.controllers.LoginController;
import bookaroom.v1.controllers.UserController;
import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Room;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;
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
        System.out.println("RoomControllerTest constructor");
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
    String dayArrival = "01/01/2023";
    String dayDeparture = "01/02/2023";
    
    LocalDate dayArrivalD = LocalDate.parse(dayArrival, UserController.getDateFormatter());  
    LocalDate dayDepartureD = LocalDate.parse(dayDeparture, UserController.getDateFormatter());
    List<LocalDate> bookedDate = dayArrivalD.datesUntil(dayDepartureD).collect(Collectors.toList());
    RoomController.getBookRoomAndDates(roomName, bookedDate);                          
    HashMap<String, List<LocalDate>> Hmap;
    Hmap = RoomController.getBookRoomAndDates(roomName, bookedDate);
    HashMap<String, List<LocalDate>> Map2;
    Map2 = new HashMap<>();
    Map2.putAll(Hmap);                                                   
    RoomController.setBookRoomAndDates(Hmap);
    
    // add the room to the booking
    RoomController.setRoomName(roomName);
    RoomController.setRoomDayArrival(dayArrival);
    RoomController.setRoomDayDeparture(dayDeparture);   
    RoomController.setRoomDayDates(bookedDate);
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
    
    
    @Test
    public void testRemoveRoomFromBooking() throws DoesNotExistException {
        System.out.println("@Test testRemoveRoomFromBooking");
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
        },new ArrayList<> (Arrays.asList())
        ));
        
        String roomName = "Room 10";
        
        // remove the room
        RoomController.setRoomName(roomName);
        RoomController.removeRoomFromBooking();
        
        // it should not exist in the booking
        Room expectedRoom = null;
        for (Room f : LoginController.getUserLoggedIn().getBooking().getRooms()) {
            if (f.getName().equals(roomName)) {
                expectedRoom = f;
            }
        }
        // if the room does not exist, expectedRoom must be null
        Assert.assertNull(expectedRoom);
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

    @Test(expectedExceptions = ArithmeticException.class)
    public void testArithmeticException() {
        System.out.println("@Test testArithmeticException");
        int result = 7 / 0;
    }
}
