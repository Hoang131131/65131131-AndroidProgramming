package ntu.hoang.ontap3;

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
    private ListView listv;
    private ArrayList<String> ThanhPho;
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
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        listv = v.findViewById(R.id.ListView);

        ThanhPho= new ArrayList<>();

        ThanhPho.add("Hà Nội");
        ThanhPho.add("Hồ Chí Minh");
        ThanhPho.add("Cần Thơ");
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), selected + "Đã được chọn", Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,ThanhPho);

        listv.setAdapter(adapter);


        // Inflate the layout for this fragment
        return v;
    }
}