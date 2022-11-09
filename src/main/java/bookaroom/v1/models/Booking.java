package bookaroom.v1.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */
public class Booking {

    private ArrayList<Room> rooms;
    private List<LocalDate> datesbookedLists;
    private String arrivalday;
    private String departureday;
    //BCDelete: private double balance;

    public Booking() {
        this.rooms = new ArrayList<>();
        this.datesbookedLists = new ArrayList<>();
        //BCDelete: this.balance = 0.0;
    }
    
    /*BCDELETE:
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
        //datesbookedList[0]++;
        //BCdelete: balance += food.getPrice();
    }
    
    public void addDatesBookedList(List<LocalDate> datesbookedList){
            datesbookedLists.addAll(datesbookedList);
    }
    
    
    public void removeRoom(Room room) {
        rooms.remove(room);
        //BCDelete: balance -= food.getPrice();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    
    public List<LocalDate> getDatesBooked() {
        return datesbookedLists;
    }
    
    public String getArrivalDateBooking() {
        return arrivalday;
    }
    
    public String getDepartureDateBooking() {
        return departureday;
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
        return "Booking: " + Arrays.toString(rooms.toArray())+Arrays.toString(datesbookedLists.toArray());
    }
   
}
