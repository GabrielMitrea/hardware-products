package store.Products.model.reviews;

public class LaptopReview {

    private String userName;
    private String Content;


    public LaptopReview(){}

    public LaptopReview(String userName, String content) {
        this.userName = userName;
        Content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
