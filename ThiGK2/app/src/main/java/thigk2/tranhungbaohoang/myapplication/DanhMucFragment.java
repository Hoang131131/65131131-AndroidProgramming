package thigk2.tranhungbaohoang.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class DanhMucFragment extends Fragment {

    private ArrayList<String> danhmuc;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    public DanhMucFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_danh_muc, container, false);
        listView = v.findViewById(R.id.lvDanhMuc);
        danhmuc = new ArrayList<>();
        danhmuc.add("Việt Nam");
        danhmuc.add("Lào");
        danhmuc.add("Trần Hưng Bảo Hoàng");
        danhmuc.add("Thái Lan");
        danhmuc.add("Singapore");
        danhmuc.add("Hàn Quốc");
        danhmuc.add("Nhật Bản");
        danhmuc.add("Hoa Kỳ");
        danhmuc.add("Pháp");
        danhmuc.add("Đức");

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,danhmuc);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return v;
    }
}