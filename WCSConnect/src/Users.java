import java.util.ArrayList;
public class Users {
    private ArrayList<User> users;

    public Users(){
        users = new ArrayList<>();
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void removeUser(User user){
        this.users.remove(user);
    }
}
