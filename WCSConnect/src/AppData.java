import java.util.*;
public class AppData {
    private static final AppData instance = new AppData();
    private User loggedInUser;
    private List<User> allUsers;
    private List<Post> newsFeed;
    private AppData() {
        allUsers = new ArrayList<>();
        newsFeed = new ArrayList<>();
    }
    public static AppData getInstance() {
        return instance;
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }
    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }
    public List<User> getAllUsers() {
        return allUsers;
    }
    public User getUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
    public void addUser(User user) {
        allUsers.add(user);
    }
    public List<Post> getNewsFeed() {
        return newsFeed;
    }
    public void addPost(Post post) {
        newsFeed.add(post);
    }
}
