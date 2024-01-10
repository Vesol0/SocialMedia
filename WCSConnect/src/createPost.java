import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createPost extends JFrame {
    private JLabel lblContent;
    private JTextField txtContent;
    private JTextField txtUsername;
    private JButton createPostButton;
    private JPanel pnlCreatePost;
    private User currentUser;
    private NewsFeed newsFeed;


    public createPost(User user1) {

        setContentPane(pnlCreatePost);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        this.currentUser = AppData.getInstance().getLoggedInUser();
        createPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String content = txtContent.getText();



                //check if the fields are not empty

                if( content.length() > 1){
                    /*newsFeed = new NewsFeed();
                    newsFeed.createPost(currentUser, content);*/

                    AppData.getInstance().addPost(new Post(content, currentUser.getUsername()));

                    ProfilePage profilePage = new ProfilePage(currentUser);
                    profilePage.setVisible(true);

                    JPanel postPanel = new JPanel();
                    JLabel txtPostedBy = new JLabel();
                    txtPostedBy.setText(currentUser.getUsername());


                    postPanel.add(txtPostedBy);


                    profilePage.add(postPanel);



                    dispose();

                }
                else{
                    JOptionPane.showMessageDialog(pnlCreatePost, "The fields must not be null.");

                }



            }
        });
    }
}
