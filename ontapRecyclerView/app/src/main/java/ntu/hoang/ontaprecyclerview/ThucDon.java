package ntu.hoang.ontaprecyclerview;

public class ThucDon {
    private String Title;
    private String Description;
    private int imgId;

    public ThucDon(String title, String description, int imgId) {
        Title = title;
        Description = description;
        this.imgId = imgId;
    }

    public ThucDon() {
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getImgId() {
        return imgId;
    }
}
