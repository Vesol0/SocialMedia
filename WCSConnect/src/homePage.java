import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage extends JFrame{
    private JPanel pnlHomePage;
    private JButton btnRegister;
    private JButton btnSignIn;
    private JPanel pnlLandingPage;
    private User currentUser;

    public homePage() {

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Register registerForm = new Register();
                registerForm.setContentPane(registerForm.pnlRegister);
                registerForm.setTitle("Register");
                registerForm.setSize(500,500);
                registerForm.setDefaultCloseOperation(EXIT_ON_CLOSE);
                registerForm.setVisible(true);


            }
        });

        setTitle("Home Page");
        // Add components, set layout, etc.
        setContentPane(pnlHomePage);

        setTitle("Home Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn signIn = new SignIn(currentUser);
                signIn.setVisible(true);

            }
        });
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
