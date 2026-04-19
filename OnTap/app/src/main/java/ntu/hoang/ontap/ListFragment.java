package ntu.hoang.ontap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    RecyclerView recyclerViewList;
    RecyclerListAdapter adapter;
    ArrayList<ListRe> recyclerLists;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerLists = new ArrayList<>();
        recyclerLists.add(new ListRe("Bánh kem", android.R.drawable.ic_menu_gallery));

        recyclerViewList = view.findViewById(R.id.RecyList);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(getContext());
        recyclerViewList.setLayoutManager(layoutLinear);

        adapter = new RecyclerListAdapter(getContext(), recyclerLists);
        recyclerViewList.setAdapter(adapter);

        return view;
    }
}