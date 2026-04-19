package ntu.hoang.ontap1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CusListFragment extends Fragment {
    private ArrayList<CusList> ACusList;
    private ListView listView;
    private CusListAdapter adapter;


    public CusListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cus_list, container, false);

        ACusList = new ArrayList<>();
        ACusList.add(new CusList("Nhà trọ", R.drawable.ic_launcher_background));
        ACusList.add(new CusList("Khách sạn",R.drawable.ic_launcher_background));
        ACusList.add(new CusList("Homestay", R.drawable.ic_launcher_background));

        listView = v.findViewById(R.id.lvCusList);

        adapter = new CusListAdapter(getContext(),ACusList);
        listView.setAdapter(adapter);


        return v;
    }
}