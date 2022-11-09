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
import java.util.ArrayList;
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

    public static void addRoomToBooking() {
        User user = LoginController.getUserLoggedIn();
        try {
            Room r = findRoomByNameInTheHotel();
            //var d = getRoomDayArrival();
            user.getBooking().addRoom(r);
          //user.getBooking().addDatesBookedList(datesbooked);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
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
        throw new DoesNotExistException("Room " + roomName + " does not exist.");
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
    
    public static void setRoomName(String roomName) {
        RoomController.roomName = roomName;
    }
    
    public static void setRoomDayArrival(String dayArrival) {
        RoomController.dayArrival = dayArrival;
    }
    
    public static void setRoomDayDeparture(String dayDeparture) {
        RoomController.dayDeparture = dayDeparture;
    }
    
    
    // Find a solution to have the dates in Array if really needed
    /*
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        LocalDate dates  =    startDate.datesUntil(endDate).collect(Collectors.toList());
        datesbooked = new ArrayList<LocalDate>(dates);
        return  datesbooked;
    }*/
  
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
