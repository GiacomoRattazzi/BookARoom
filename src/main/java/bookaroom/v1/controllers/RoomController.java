/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookaroom.v1.controllers;

import bookaroom.v1.exceptions.DoesNotExistException;
import bookaroom.v1.models.Room;
import bookaroom.v1.database.MockDatabase;
import bookaroom.v1.models.User;
import java.util.ArrayList;

/**
 *
 * @author Team BookARoom
 */

public class RoomController {

    private static String roomName = "";

    public static void addRoomToBooking() {
        User user = LoginController.getUserLoggedIn();
        try {
            Room r = findRoomByNameInTheHotel();
            user.getBooking().addRoom(r);
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
        throw new DoesNotExistException("Food " + roomName + " does not exist.");
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

    public static void setRoomName(String roomName) {
        RoomController.roomName = roomName;
    }

}
