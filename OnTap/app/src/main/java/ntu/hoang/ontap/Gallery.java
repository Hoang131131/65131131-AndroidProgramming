package ntu.hoang.ontap;

public class Gallery {
    private String Title;
    private int idImg;

    public Gallery(String title, int idImg) {
        Title = title;
        this.idImg = idImg;
    }

    public Gallery() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
