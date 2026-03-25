package ntu.hoang.newsapp;

public class News {
    public String title;
    public String link;
    public String pubDate;
    public String imageUrl;
    public String description;

    public News(String title, String link, String pubDate, String imageUrl, String description) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.imageUrl = imageUrl;
        this.description = description;
    }
}