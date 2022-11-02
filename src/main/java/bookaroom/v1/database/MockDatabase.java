package bookaroom.v1.database;

import bookaroom.v1.models.Room;
import bookaroom.v1.models.User;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */
public class MockDatabase {

    private static ArrayList<User> users = new ArrayList<User>() {
        {
            add(new User("lisa", "lisa", "simpson", "lisa@simpson.com", "1234"));
            add(new User("homer", "homer", "simpson", "homer@simpson.com", "1234"));
            add(new User("marge", "marge", "simpson", "marge@simpson.com", "1234"));
            add(new User("bart", "bart", "simpson", "bart@simpson.com", "1234"));
        }
    };
    private static ArrayList<Room> rooms = new ArrayList<Room>() {
        {
            add(new Room("Room 1", 330, new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                    add("test");
                }
            }));
            add(new Room("Room 2", 200, new ArrayList<String>() {
                {
                    add("1 bed");
                    add("test");
                }
            }));
            add(new Room("Room 3", 100, new ArrayList<String>() {
                {
                    add("no beds");
                    add("test");
                    add("mtest");
                }
            }));
        }
    };

    public static void addAUser(User user) {
        users.add(user);
    }

    public static void addFood(Room room) {
        rooms.add(room);
    }

    public static void removeAUser(User user) {
        users.remove(user);
    }

    public static void removeRoom(Room room) {

    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
