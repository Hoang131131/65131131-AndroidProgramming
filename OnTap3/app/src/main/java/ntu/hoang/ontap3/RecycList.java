package ntu.hoang.ontap3;

import androidx.recyclerview.widget.RecyclerView;

public class RecycList{

    private String ReTitle;
    private String ReBtn;

    public RecycList(String reTitle, String reBtn) {
        ReTitle = reTitle;
        ReBtn = reBtn;
    }

    public RecycList() {
    }

    public String getReTitle() {
        return ReTitle;
    }

    public String getReBtn() {
        return ReBtn;
    }
}
