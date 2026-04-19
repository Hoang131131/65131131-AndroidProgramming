package ntu.hoang.ontap2;

public class Food {
    private String Title;
    private int Imgid;

    public Food(String title, int imgid) {
        Title = title;
        Imgid = imgid;
    }

    public Food() {
    }

    public String getTitle() {
        return Title;
    }

    public int getImgid() {
        return Imgid;
    }
}
