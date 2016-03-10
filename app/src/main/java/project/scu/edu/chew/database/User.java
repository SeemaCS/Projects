package project.scu.edu.chew.database;

/**
 * Created by lakshitha on 3/2/16.
 */
public class User {
    private static int counter = 0;

    String name;
    String email;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String password) {
        counter++;

        this.id = counter;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }
}
