import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Register extends JFrame{
    public JPanel pnlRegister;
    private JTextField txtFirstName;
    private JTextField txtSurname;
    private JTextField txtEmail;
    private JPasswordField pswdPassword;
    private JPasswordField pswdConfirm;
    private JButton btnSubmit;


    public Register() {

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName= txtFirstName.getText();
                String lName= txtSurname.getText();
                String email = txtEmail.getText();
                char[] password = pswdPassword.getPassword();
                char[] pass2 = pswdConfirm.getPassword();

                if(fName.length()>1 && lName.length()>1 && email.length()>1){

                    if(Arrays.equals(password, pass2)) {


                        JOptionPane.showConfirmDialog(null, "registering " + fName + " " + lName);

                        User user = new User(fName, lName, email, Arrays.toString(password));

                        AppData.getInstance().addUser(user);
                        // Create an instance of HomePage and pass the newUser
                        homePage homeForm = new homePage();
                        homeForm.setVisible(true);

                        // Optionally, you can dispose of the Register form if it's no longer needed

                    }
                    else{
                        JOptionPane.showMessageDialog(pnlRegister, "The passwords do not match");
                    }

                }

                else{
                    JOptionPane.showMessageDialog(pnlRegister, "This information must not be null");

                }

            }
        });
    }
}
