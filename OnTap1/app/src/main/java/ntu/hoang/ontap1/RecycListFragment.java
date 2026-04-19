package ntu.hoang.ontap1;

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
    private ArrayList<RecycList> ARecycList;
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyc_list, container, false);
        ARecycList = new ArrayList<>();
        ARecycList.add(new RecycList("Đóng cửa",R.drawable.ic_launcher_background));
        ARecycList.add(new RecycList("Mở cửa",R.drawable.ic_launcher_background));
        ARecycList.add(new RecycList("Mai nghỉ",R.drawable.ic_launcher_background));

        recyclerView = v.findViewById(R.id.recyclist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RecycListAdapter(getContext(), ARecycList);
        recyclerView.setAdapter(adapter);




        return v;
    }
}