import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignIn extends JFrame{
    private JPanel pnlSignIn;
    private JTextField txtUsername;
    private JPasswordField pswdPassword;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JButton signInButton;
    private User currentUser;

    public SignIn(User user) {
        setContentPane(pnlSignIn);
        setTitle("Sign In");
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUsername.getText();
                char[] password = pswdPassword.getPassword();
                for(int i = 0; i < AppData.getInstance().getAllUsers().size(); i++) {
                    if (txtUsername.getText().equals(AppData.getInstance().getAllUsers().get(i).getProfile().getEmail()) && AppData.getInstance().getAllUsers().get(i).getProfile().getPassword().equals(Arrays.toString(password))) {
                        for (User user : AppData.getInstance().getAllUsers()){
                            user.getUsername().equals(userName);
                            AppData.getInstance().setLoggedInUser(user);

                        }
                        JOptionPane.showConfirmDialog(pnlSignIn, AppData.getInstance().getLoggedInUser().getUsername() + "has signed in");
                        ProfilePage profilePage = new ProfilePage(AppData.getInstance().getLoggedInUser());

                        profilePage.setVisible(true);
                        profilePage.setTitle(AppData.getInstance().getLoggedInUser().getUsername() + " Profile");
                        dispose();




                    } else {
                        JOptionPane.showMessageDialog(pnlSignIn, "The email or password does not match");
                        JOptionPane.showMessageDialog(pnlSignIn, Arrays.toString(password));
                    }
                }











            }
        });
    }
}
