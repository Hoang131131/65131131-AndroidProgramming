package ntu.hoang.ontap1;

public class CusList {
    private String Title;
    private int imgID;

    public CusList(String title, int imgID) {
        Title = title;
        this.imgID = imgID;
    }

    public String getTitle() {
        return Title;
    }

    public int getImgID() {
        return imgID;
    }
}
