package ntu.hoang.ontap;

public class ListRe {
    private String Name;
    private int Listid;

    public ListRe(String name, int listid) {
        Name = name;
        Listid = listid;
    }

    public ListRe() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getListid() {
        return Listid;
    }

    public void setListid(int listid) {
        Listid = listid;
    }
}
