public class Comment {
    String content;
    User user;
    String username;

    public Comment(String content, String username){
        this.content = content;
        this.username = username;
    }

    public String getContent(){
        return this.content;
    }
    public String getUsername(){
        return this.username;
    }
    @Override
    public String toString(){
        return getUsername() + "commented: "+getContent();
    }



}
