package store.Products.entities.reviews;

public class HeadsetReview {
    private String username;
    private String content;

    public HeadsetReview(){}

    public HeadsetReview(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
