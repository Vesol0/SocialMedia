import java.util.ArrayList;

public class Profile {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<Post> posts;
    private ArrayList<User> followedUsers;
    private NewsFeed newsFeed;
    private String bio;
    private int followers;


    public Profile( String firstName, String lastName, String email, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bio = "I am new to Social Media";
        posts = new ArrayList<>();
        followedUsers = new ArrayList<>();
        this.followers = 0;



    }

    public void updateProfile(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getBio(){
        return bio;
    }
    public int getFollowers(){
        return followers;
    }

    public void followUser(User targetUser){
        followedUsers.add(targetUser);
    }
    public ArrayList<Post> getPosts(){
        return posts;
    }



    /**
     * Check if the provided username is valid.
     * A valid username must have the format: "LLNNNN" (L - Letter, N - Number).
     *
     * @param username The username to be checked.
     * @return true if the username is valid, false otherwise.
     */
    public boolean isValidUsername(String username) {
        // TODO: Implement the validation logic here
        return false;  // Replace with the actual implementation
    }

    @Override
    public String toString() {
        return "Profile{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }
}
