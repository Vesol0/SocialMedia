import javax.swing.*;

public class test extends JFrame{
    private JList<Post> list1;
    private JPanel panel1;

    public test(){

        setContentPane(panel1);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        AppData.getInstance().getLoggedInUser().getProfile().getPosts().add(0, new Post("None", "Joe"));
        DefaultListModel<Post> listModel = new DefaultListModel<>();

        /*for(Post posts : AppData.getInstance().getLoggedInUser().getProfile().getPosts()){
            listModel.addElement(posts);
            System.out.println(posts.getContent());
        }*/

        for(int i = 0; i < AppData.getInstance().getLoggedInUser().getProfile().getPosts().size(); i++){
            listModel.addElement(AppData.getInstance().getLoggedInUser().getProfile().getPosts().get(i));
        }
        list1.setModel(listModel);
        list1.setSelectedIndex(0);
    }
}


