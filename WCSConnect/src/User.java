import java.sql.*;
import java.util.Date;
import java.util.Random;

public class User {
    private String username;
    private Profile profile;
    private boolean isLoggedIn;  // Added status field for login status
    private Session session;
    private String password;
    private String firstName;
    private String lastName;
    private String email;



    public User(String username, String firstName, String lastName ,String email, String password) {
        this.username = username;
        this.profile = new Profile(firstName,lastName, email, password);
        this.isLoggedIn= false;







    }

    // Constructor to generate a username
    public User(String firstName, String lastName, String email, String password) {
        this.username=generateUsername(firstName, lastName);
        this.profile = new Profile(firstName, lastName, email, password);
        this.isLoggedIn = false;

        String URL = "jdbc:mysql://localhost:3306/user_registration";
        String USERNAME = "root";
        String PASSWORD = "Composer01!";



        // JDBC variables
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a database connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // SQL query to insert data
            String sql = "INSERT INTO users (firstName, surname, emailAddress, password) VALUES (?, ?, ?, ?)";

            // Create a prepared statement
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User added to the database successfully!");
            } else {
                System.out.println("Failed to add user to the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public String getUsername() {
        return username;
    }

    public Profile getProfile() {
        return profile;
    }


    public boolean isLoggedIn() {
        // TODO: Implement the login status check
        return isLoggedIn;
    }

    // Generate a username based on first name and last name
    private String generateUsername(String firstName, String lastName) {

        // Take the first character from the first name
        char firstChar = firstName.charAt(0);

        // Take the second character from the last name
        char secondChar = lastName.charAt(1);

        // Generate a random 4-digit number
        Random random = new Random();
        int randomDigits = 1000 + random.nextInt(9000);

        return firstChar +""+ secondChar+"" + randomDigits;
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

    public boolean login(String username, String password) {
        // TODO: Implement the login logic
        if (!isLoggedIn){
            //check fields
            if (this.getUsername().equals(username)
                    && this.getProfile().getPassword().equals(password)){
                createSession();
                return true;
            }
        }
        return false;
    }

    public void updateProfile( String firstName,String lastName, String email, String password) {
        profile.updateProfile(firstName,lastName ,email, password);
    }

    private void createSession() {
        // Create a new session when the user logs in
        String sessionId = generateSessionId();
        session = new Session(sessionId);
    }

    private String generateSessionId() {
        // Generate a unique session ID (you can implement this as needed)
        return "SessionID-" + System.currentTimeMillis();
    }

    public String toString(){
        return this.getProfile().toString() + "username: "+this.username +" active" +isLoggedIn;
    }

}
