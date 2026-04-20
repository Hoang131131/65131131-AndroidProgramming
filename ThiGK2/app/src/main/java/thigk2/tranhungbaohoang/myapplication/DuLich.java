package thigk2.tranhungbaohoang.myapplication;

public class DuLich {
    private String DiaDiem;
    private String DiaChi;
    private int ImgID;

    public DuLich(String diaDiem, String diaChi, int imgID) {
        DiaDiem = diaDiem;
        DiaChi = diaChi;
        ImgID = imgID;
    }

    public String getDiaDiem() {
        return DiaDiem;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public int getImgID() {
        return ImgID;
    }
}
