import java.util.ArrayList;
import java.util.Date;
public class Post {
    private int postId;
    private String content;
    private String username;
    private Date datePosted;
    private int likes;
    private User userPosted;


    ArrayList<Comment> comments = new ArrayList<>();

    private static int nextPostId=1;

    public Post(String content, String username){
        this.postId = nextPostId++;
        this.content = content;
        this.username = username;
        datePosted = new Date();
        likes = 0;
    }

    public String getContent(){
        return content;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void showAllComments(){
        for(Comment comment : comments){
            System.out.println(comment.toString());

        }
    }

    public int getNumberOfLikes(){
        return likes;
    }

    public void likePost(){
        likes++;
    }


}

