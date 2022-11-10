/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.controllers;

import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Room;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.exceptions.AlreadyExistsException;
import bookaroom.v1.models.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Team BookARoom
 */

public class RoomController {

    private static String roomName = "";
    private static String dayArrival = "";
    private static String dayDeparture ="";
    private static List<LocalDate> datesbooked;
    private static HashMap<String, List<LocalDate>> Map;

    public static void addRoomToBooking() {
        User user = LoginController.getUserLoggedIn();
        try {
            Room r = findRoomByNameInTheHotel();
            //var d = getRoomDayArrival();
            user.getBooking().addRoom(r);
            user.getBooking().addDatesBookedList(datesbooked);
            user.getBooking().addBookedRoomAndDates(Map);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
/*
    public static void addDatesToRoom() {
        User user = LoginController.getUserLoggedIn();
        try {
            Room r = findRoomByNameInTheHotel();
            //var d = getRoomDayArrival();
            user.getBooking().addRoom(r);
            user.getBooking().addDatesBookedList(datesbooked);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }
  */  
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

    protected static Room findRoomByNameInBooking() throws DoesNotExistException {
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
        //Hmap.get(); // if needed 
        return Hmap;
    }
    
    public static void setBookRoomAndDates(HashMap<String, List<LocalDate>> Map) {
        RoomController.Map = Map;
    }
    
    /*
    public static void setBookRoomAndDates(String BookedRoomName, List<LocalDate> BookedRoomDates,HashMap<String, List<LocalDate>> Map) {
        HashMap<String, List<LocalDate>> Hmap = new HashMap<>();
        Map.put(BookedRoomName,BookedRoomDates);
        RoomController.Map = Map;
    }
    /*
    public static void setBookRoomAndDates(HashMap<String, List<LocalDate>> Map) {
         RoomController.Map = Map;
    }*/
    
    public static void setRoomName(String roomName) {
        RoomController.roomName = roomName;
    }
    
    public static void setRoomDayArrival(String dayArrival) {
        RoomController.dayArrival = dayArrival;
    }
    
    public static void setRoomDayDeparture(String dayDeparture) {
        RoomController.dayDeparture = dayDeparture;
    }
    
    public static void setRoomDayDates(List<LocalDate> datesbooked) {
        RoomController.datesbooked = datesbooked;
    }
    
    
    
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
    
    // Find a solution to have the dates in Array if really needed
   
    /*
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> datesbooked  =    startDate.datesUntil(endDate).collect(Collectors.toList());
        //ArrayList<String> datesbooked = dates.stream().toArray(dates[]::new)
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //String datesbooked = dates.format(formatter);
        //datesbooked = new ArrayList<String>(dates);
        return  datesbooked;
    }
  */
    /*List
   protected static Room findRoomByNameAndByDateInBooking() throws AlreadyExistsException {
        for (Room r : LoginController.getUserLoggedIn().getBooking().getRooms()) {
            if (r.getName().equals(roomName)) {
                return r;
                for (Room r : LoginController.getUserLoggedIn().getDatesBetween()) {
                    if (r.getDates().equals(datesbooked)) {
                        return r;
                    }
            throw new AlreadyExistsException("Room " + datesbooked + " is not available.");
        }
        throw new AlreadyExistsException("Room " + roomName + " does not exist.");
    }*/

}
