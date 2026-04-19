package ntu.hoang.ontap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SumFragment extends Fragment {


    public SumFragment() {
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
        View v = inflater.inflate(R.layout.fragment_sum, container, false);
        Button btnSum = v.findViewById(R.id.btnSum);
        TextView A = v.findViewById(R.id.edtextA);
        TextView B = v.findViewById(R.id.edtextB);
        TextView KQ = v.findViewById(R.id.edtextKQ);

        btnSum.setOnClickListener(view -> {
            String a = A.getText().toString();
            String b = B.getText().toString();
            double soA = Double.parseDouble(a);
            double soB = Double.parseDouble(b);
            double Sum = soA+soB;
            KQ.setText(String.valueOf(Sum));

        });

        return v;
    }
}