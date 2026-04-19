package ntu.hoang.ontap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ImagesFragment extends Fragment {


    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_images, container, false);
        // Inflate the layout for this fragment
        ListView GalleryList = v.findViewById(R.id.galyList);
        ArrayList<Gallery> galleries = new ArrayList<Gallery>();

        galleries.add(new Gallery("Việt Nam", android.R.drawable.ic_menu_gallery));

        CustomListAdapter adapter = new CustomListAdapter(getContext(), galleries);
        GalleryList.setAdapter(adapter);







        return v;
    }
}