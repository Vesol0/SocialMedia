import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfilePage extends JFrame{
    private JPanel pnlProfile;
    private JLabel lblWelcome;
    private JPanel pnlContent;
    private JButton btnNewsFeed;
    private JPanel pnlNewsfeed;
    private JButton btnCreatePost;
    private JPanel pnlMyPosts;
    private JButton editProfileButton;
    private JList<Post> listMyPosts;
    private JTextField txtName;
    private JTextField txtUserName;
    private JTextField txtBio;
    private JTextField txtFollowers;
    private JPanel pnlProfileInfo;
    private User currentUser;
    private ArrayList<Post> posts;
    private NewsFeed newsFeed;


    public ProfilePage(User user){
        this.currentUser = user;
        newsFeed = new NewsFeed();


        setContentPane(pnlProfile);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txtBio.setText(currentUser.getProfile().getBio());
        txtName.setText(currentUser.getProfile().getFirstName() + " " + currentUser.getProfile().getLastName());
        txtUserName.setText(currentUser.getUsername());
        txtFollowers.setText(Integer.toString(currentUser.getProfile().getFollowers()));


        DefaultListModel<Post> listModel = new DefaultListModel<>();

        /*for(Post posts : AppData.getInstance().getLoggedInUser().getProfile().getPosts()){
            listModel.addElement(posts);
            System.out.println(posts.getContent());
        }*/

        for(int i = 0; i < AppData.getInstance().getLoggedInUser().getProfile().getPosts().size(); i++){
            listModel.addElement(AppData.getInstance().getLoggedInUser().getProfile().getPosts().get(i));
        }
        listMyPosts.setModel(listModel);
        listMyPosts.setSelectedIndex(0);



        btnNewsFeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posts = new ArrayList<>();



                btnNewsFeed.setVisible(false);
                btnNewsFeed.setEnabled(false);
                pnlNewsfeed.setVisible(false);
                pnlNewsfeed.setEnabled(false);

                btnCreatePost.setVisible(true);
                btnCreatePost.setEnabled(true);
                pnlContent.setVisible(true);
                pnlContent.setEnabled(true);

                // display posts;





            }
        });
        btnCreatePost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPost CreatePost = new createPost(currentUser);
                CreatePost.setVisible(true);
                CreatePost.setTitle("Create a post");


                pnlProfile.setVisible(false);

                dispose();
            }
        });
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditProfile editProfile = new EditProfile();
                editProfile.setSize(500, 500);
                editProfile.setTitle("Edit Profile");
                editProfile.setVisible(true);

                dispose();

            }
        });
    }



}
