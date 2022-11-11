package bookaroom.v1.controllers;

import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Room;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
@author Team BookARoom
 */

public class RoomController {

    private static String roomName = "";
    private static String dayArrival = "";
    private static String dayDeparture ="";
    private static String datesbooked = "";
    private static HashMap<String, List<LocalDate>> Map;


    public static void addDatesToBooking() {
        User user = LoginController.getUserLoggedIn();
        user.getBooking().addBookedRoomAndDates(roomName, datesbooked);
        }
    
    
    public static void setRoomDates(String roomanddates) {
        RoomController.datesbooked = roomanddates;
    }
  
    public static void addRoomToBooking() {
        User user = LoginController.getUserLoggedIn();
        try {
            Room r = findRoomByNameInTheHotel();
            //var d = getRoomDayArrival();
            user.getBooking().addRoom(r);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    
    public static boolean checkRoomExists() {
        for (Room r : MockDatabase.getInstance().getRooms()) {
            if (r.getName().equals(roomName)) {
                return true;
            }
        }
        return false;
    }
  
    public static void removeRoomFromBooking() {
        User user = LoginController.getUserLoggedIn();
        try {
            if (doesRoomExistInBooking()) {
                user.getBooking().removeRoom(findRoomByNameInBooking());
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }
// TODO put this in form of an exception
    protected static boolean doesRoomExistInBooking() {
        for (Room r : LoginController.getUserLoggedIn().getBooking().getRooms()) {
            if (r.getName().equals(roomName)) {
                return true;
            }
        }
        return false;
    }

    protected static Room findRoomByNameInTheHotel() throws DoesNotExistException {
        for (Room r : MockDatabase.getInstance().getRooms()) {
            if (r.getName().equals(roomName)) {
                return r;
            }
        }
        throw new DoesNotExistException("Room " + roomName + " does not exist.");
    }

    public static Room findRoomByNameInBooking() throws DoesNotExistException {
        for (Room r : LoginController.getUserLoggedIn().getBooking().getRooms()) {
            if (r.getName().equals(roomName)) {
                return r;
            }
        }
        throw new DoesNotExistException("Room " + roomName + " does not exist or is not booked.");
    }

    public static ArrayList<Room> getRooms() {
        return MockDatabase.getInstance().getRooms();
    }

    //TEST
    public static HashMap<String, ArrayList<LocalDate>> getBookedDates() {
        return MockDatabase.getInstance().getBookedDates();
    }
    //END TEST

    public static String getRoomName() {
        return roomName;
    }
    
      public static String getRoomDayArrival() {
        return dayArrival;
    }
    
    public static String getRoomDayDeparture() {
        return dayDeparture;
    }
    
    public static HashMap<String, List<LocalDate>> getBookRoomAndDates(String BookedRoomName, List<LocalDate> BookedRoomDates) {
        HashMap<String, List<LocalDate>> Hmap = new HashMap<>();
        Hmap.put(BookedRoomName,BookedRoomDates);
        return Hmap;
    }
    
    public static void setBookRoomAndDates(HashMap<String, List<LocalDate>> Map) {
        RoomController.Map = Map;
    }
    
    public static void setRoomName(String roomName) {
        RoomController.roomName = roomName;
    }
    
    public static void setRoomDayArrival(String dayArrival) {
        RoomController.dayArrival = dayArrival;
    }
    
    public static void setRoomDayDeparture(String dayDeparture) {
        RoomController.dayDeparture = dayDeparture;
    }
    /*
    public static void setRoomDayDates(List<LocalDate> datesbooked) {
        RoomController.datesbooked = datesbooked;
    }
*/
    
    //GET PRICE
    public static double getRoomPriceTest() {
        User user = LoginController.getUserLoggedIn();
        double p = 0;
        try {
            Room r = findRoomByNameInTheHotel();
            p = user.getBooking().GetRoomPrice(r);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    

}
