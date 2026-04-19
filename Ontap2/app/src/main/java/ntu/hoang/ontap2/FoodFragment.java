package ntu.hoang.ontap2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FoodFragment extends Fragment {


    private ArrayList<Food> Datas;
    private ListView listView;
    private FoodAdapter adapter;

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_food, container, false);
        // Inflate the layout for this fragment

        listView = v.findViewById(R.id.listview);
        Datas = new ArrayList<>();
        Datas.add(new Food("Bánh kem",R.drawable.ic_launcher_background));
        Datas.add(new Food("Bánh mì",R.drawable.ic_launcher_background));

        adapter = new FoodAdapter(Datas, getContext());
        listView.setAdapter(adapter);









        return v;
    }
}