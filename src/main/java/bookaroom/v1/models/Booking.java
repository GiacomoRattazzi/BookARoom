package bookaroom.v1.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */
public class Booking {

    private ArrayList<Room> rooms;
    //BCDelete: private double balance;

    public Booking() {
        this.rooms = new ArrayList<>();
        //BCDelete: this.balance = 0.0;
    }

    public double emptyBooking() {
        rooms.clear();
        //BCDelete: double tmp = balance;
        //BCDelete: balance = 0.0;
        //BCDelete: return tmp;
    }
    /** BCDelete:
    *public double getBalance() {
    *    return balance;
    *}
    */
    public void addRoom(Room room) {
        rooms.add(room);
        //BCdelete: balance += food.getPrice();
    }

    public void removeFood(Room room) {
        rooms.remove(room);
        //BCDelete: balance -= food.getPrice();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    /** BCdelete:
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Booking) {
            Booking sc = (Booking) obj;
            if (sc.getBalance() == balance) {
                ArrayList<String> scFoods = new ArrayList<>();
                for (Food f : foods) {
                    scFoods.add(Objects.toString(f, null));
                }
                ArrayList<String> thisSC = new ArrayList<>();
                for (Food f : foods) {
                    thisSC.add(Objects.toString(f, null));
                }
                Collections.sort(scFoods);
                Collections.sort(thisSC);
                if (scFoods.containsAll(thisSC)) {
                    return true;
                }
            }
        }
        return false;
    }
    */

    @Override
    public String toString() {
        return "Booking: " + Arrays.toString(rooms.toArray());
    }

}
