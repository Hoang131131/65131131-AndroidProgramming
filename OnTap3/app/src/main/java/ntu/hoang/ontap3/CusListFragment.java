package ntu.hoang.ontap3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class CusListFragment extends Fragment {

    private ArrayList<CusList> CusLists;
    private ListView CusListView;
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
        View v =inflater.inflate(R.layout.fragment_cus_list, container, false);
        // Inflate the layout for this fragment

        CusLists = new ArrayList<>();
        CusLists.add(new CusList("Bánh kem", R.drawable.ic_launcher_background));
        CusLists.add(new CusList("Bánh mì", R.drawable.ic_launcher_background));

        CusListView = v.findViewById(R.id.CustomList);

        adapter = new CusListAdapter(getContext(), CusLists);
        CusListView.setAdapter(adapter);

        return v;
    }
}