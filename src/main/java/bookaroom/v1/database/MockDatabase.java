package bookaroom.v1.database;

import bookaroom.v1.models.Room;
import bookaroom.v1.models.User;
import bookaroom.v1.models.Comment;
import java.util.ArrayList;
import java.time.*;
/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Team BookARoom
 */
public class MockDatabase {
    
    private static MockDatabase instance;

    private ArrayList<User> users;
    private ArrayList<Room> rooms;
    private ArrayList<Comment> comments;
    
    private MockDatabase() {
        users = new ArrayList<User>();
        users.add(new User("jwang", "jingmin", "wang", "jingmin.wang@unil.ch", "1234","0000000000000000","123","10/26"));
        users.add(new User("gratt", "giacomo", "rattazzi", "giacomo.rattazzi@gmail.com", "1234", "0000000000000000","123","10/26"));
        users.add(new User("danes", "daniel", "do vale anes", "daniel.dovaleanes@gmail.com", "1234","0000000000000000","123","10/26"));
        users.add(new User("afarh", "ahmed", "farhat", "ahmed.farhat@gmail.com", "1234", "0000000000000000","123","10/26"));

    
        rooms = new ArrayList<Room>();
        rooms.add(new Room("Room 1", 200, new ArrayList<String>() {
            {
                add("One double bed");
                add("Maximum capacity: 1"); 
                add("r001");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 2", 250, new ArrayList<String>() {
            {
                add("Two double beds");
                add("Maximum capacity: 2");
                add("r002");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 3", 280, new ArrayList<String>() {
            {
                add("2 beds");
                add("Maximum capacity: 4");
                add("r003");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 4", 200, new ArrayList<String>() {
            {
                add("1 bed");
                add("Maximum capacity: 1");
                add("r004");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));

        rooms.add(new Room("Room 5", 250, new ArrayList<String>() {
            {
                add("2 beds");
                add("Maximum capacity: 2");
                add("r005");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));

        rooms.add(new Room("Room 6", 280, new ArrayList<String>() {
            {
                add("2 beds");
                add("Maximum capacity: 4");
                add("r006");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 7", 200,  new ArrayList<String>() {
            {
                add("1 bed");
                add("Maximum capacity: 1");
                add("r007");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 8", 250, new ArrayList<String>() {
            {
                add("2 beds");
                add("Maximum capacity: 2");
                add("r008");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 9", 280, new ArrayList<String>() {
            {
                add("2 bunk beds");
                add("Maximum capacity: 4");
                add("r009");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
        rooms.add(new Room("Room 10", 200, new ArrayList<String>() {
            {
                add("1 bed");
                add("Maximum capacity: 1");
                add("r010");
            }
        }, new ArrayList<String>() {
            {
                add(LocalDate.of(2012,12,11).toString());
            }
        }));
               
        comments = new ArrayList<Comment>();
        comments.add(new Comment("this is great"));
        comments.add(new Comment("this is terrible"));
        
             
        }
    
        
    public static MockDatabase getInstance() {
        if (instance == null) {
            instance = new MockDatabase();
        }
        return instance;
    }
    public void addAUser(User user) {
        users.add(user);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    public void addAComment(Comment comment) {
        comments.add(comment);
    }


    public void removeAUser(User user) {
        users.remove(user);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    
    public ArrayList<Comment> getComments() {
        return comments;
    }


}
