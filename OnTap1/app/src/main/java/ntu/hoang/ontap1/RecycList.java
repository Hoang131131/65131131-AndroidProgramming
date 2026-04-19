package ntu.hoang.ontap1;

public class RecycList {
    private String Title;
    private int ImgID;

    public RecycList(String title, int imgID) {
        Title = title;
        ImgID = imgID;
    }

    public String getTitle() {
        return Title;
    }

    public int getImgID() {
        return ImgID;
    }
}
