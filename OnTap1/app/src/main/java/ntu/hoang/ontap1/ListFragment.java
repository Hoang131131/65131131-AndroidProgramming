package ntu.hoang.ontap1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private ArrayList<String> SList;
    private ListView listView;
    private ArrayAdapter<String> adapter;


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
        View v =inflater.inflate(R.layout.fragment_list, container, false);

        SList = new ArrayList<>();
        SList.add("Xin chào");
        SList.add("Tạm biệt");

        listView = v.findViewById(R.id.lvList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Chào " + text, Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1, SList);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return v;
    }
}