package ntu.hoang.ontap3;

public class CusList {
    private String CusTitle;
    private int CusImg;

    public CusList(String cusTitle, int cusImg) {
        CusTitle = cusTitle;
        CusImg = cusImg;
    }

    public CusList() {
    }

    public String getCusTitle() {
        return CusTitle;
    }

    public int getCusImg() {
        return CusImg;
    }
}
