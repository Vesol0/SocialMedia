import java.util.ArrayList;
public class NewsFeed {
;
    private ArrayList<Post> posts;

    public NewsFeed(){
        posts = new ArrayList<>();

    }

    public void createPost(User user, String content){
        posts.add(new Post(content, user.getUsername()));



    }
    public ArrayList<Post> getPosts(){
        return posts;
    }

   /* public void commentOnPost(User user, int postId, String commentContent){
        for(int i = 0; i < posts.size(); i++){
            if(posts.get(i).postId == postId){
                Comment comment;
                posts.get(i).addComment(Comment comment = new Comment(commentContent, user.getUsername()));
            }
        }
    }*/

}
