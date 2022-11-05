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
    
    private static MockDatabase instance;

    private static ArrayList<User> users = new ArrayList<User>() {
        {
            add(new User("jwang", "jingmin", "wang", "jingmin.wang@unil.ch", "1234"));
            add(new User("gratt", "giacomo", "rattazzi", "giacomo.rattazzi@gmail.com", "1234"));
            add(new User("danes", "daniel", "do vale anes", "daniel.dovaleanes@gmail.com", "1234"));
            add(new User("afarh", "ahmed", "farhat", "ahmed.farhat@gmail.com", "1234"));
        }
    };
    private static ArrayList<Room> rooms = new ArrayList<Room>() {
        {
            add(new Room("Room 1", 200, "One double bed", new ArrayList<String>() {
                {
                    add("1 bed");
                    add("test");
                    add("test");
                }
            }));
            add(new Room("Room 2", 250, "Two double beds", new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                }
            }));
            add(new Room("Room 3", 280, "Two bunk beds", new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                    add("mtest");
                }
            }));
             add(new Room("Room 4", 200, "One double bed", new ArrayList<String>() {
                {
                    add("1 bed");
                    add("test");
                    add("mtest");
                }
            }));
            
             add(new Room("Room 5", 250, "Two double beds", new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                    add("mtest");
                }
            }));
            
             add(new Room("Room 6", 280, "Two bunk beds", new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                    add("mtest");
                }
            }));
             add(new Room("Room 7", 200, "One double bed",  new ArrayList<String>() {
                {
                    add("1 bed");
                    add("test");
                    add("mtest");
                }
            }));
              add(new Room("Room 8", 250, "Two double beds", new ArrayList<String>() {
                {
                    add("2 beds");
                    add("test");
                    add("mtest");
                }
            }));
              add(new Room("Room 9", 280, "Two bunk beds", new ArrayList<String>() {
                {
                    add("no beds");
                    add("test");
                    add("mtest");
                }
            }));
               add(new Room("Room 10", 200, "One double bed", new ArrayList<String>() {
                {
                    add("no beds");
                    add("test");
                    add("mtest");
                }
            }));
               
             
             
        }
    };
    public static MockDatabase getInstance() {
        if (instance == null) {
            instance = new MockDatabase();
        }
        return instance;
    }
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
