package ntu.hoang.ontapcustomlist;

public class MonAn {
    private String Name;
    private int ImgId;

    public MonAn(String name, int imgId) {
        Name = name;
        ImgId = imgId;
    }

    public MonAn() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }
}
