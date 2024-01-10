import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile extends JFrame{


    private JButton backButton;
    private JTextField txtUsername;
    private JTextField txtBio;
    private JTextField txtName;
    private JTextField txtSurname;
    private JButton confirmButton;
    private JButton btnConfirm;
    private JPanel pnlEditProfile;

    public EditProfile() {
        setContentPane(pnlEditProfile);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("WCSConnect/src/images/reshot-icon-back-2SMVD3RHX6.svg");
        Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        backButton.setIcon(icon);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtName.getText().length() >1 && txtSurname.getText().length() >1 && txtUsername.getText().length() > 1 && txtBio.getText().length() > 1){
                    
                }

            }
        });
    }
}
