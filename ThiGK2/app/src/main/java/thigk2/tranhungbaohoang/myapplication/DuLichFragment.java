package thigk2.tranhungbaohoang.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class DuLichFragment extends Fragment {
    private ArrayList<DuLich> duLiches;
    private ListView listView;
    private DuLichAdapter adapter;


    public DuLichFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_du_lich, container, false);
        listView = v.findViewById(R.id.lvDuLich);
        duLiches = new ArrayList<>();
        duLiches.add(new DuLich("Vịnh Hạ Long", "Quảng Ninh", R.drawable.halong));
        duLiches.add(new DuLich("Phố Cổ Hội An", "Quảng Nam", R.drawable.hoian));
        duLiches.add(new DuLich("Đảo Phú Quốc", "Kiên Giang", R.drawable.phuquoc));
        duLiches.add(new DuLich("Sapa", "Lào Cai", R.drawable.sapa));
        duLiches.add(new DuLich("Tràng An", "Ninh Bình", R.drawable.trangan));

        adapter = new DuLichAdapter(getContext(),duLiches);
        listView.setAdapter(adapter);

        return v;
    }
}