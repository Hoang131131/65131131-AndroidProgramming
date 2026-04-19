package ntu.hoang.ontap3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecycListFragment extends Fragment {

    private ArrayList<RecycList> ReLists;
    private RecyclerView recyclerView;
    private RecycListAdapter adapter;


    public RecycListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyc_list, container, false);
        // Inflate the layout for this fragment

        ReLists = new ArrayList<>();
        ReLists.add(new RecycList("Bánh kem", "Đặt hàng"));
        ReLists.add(new RecycList("Bánh mì", "Giảm giá"));

        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecycListAdapter(getContext(),ReLists);
        recyclerView.setAdapter(adapter);

        return v;
    }
}