package thigk2.tranhungbaohoang.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RectangleFragment extends Fragment {


    public RectangleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rectangle, container, false);
        TextView Dai = v.findViewById(R.id.txtDai);
        TextView Rong = v.findViewById(R.id.txtRong);
        TextView ChuVi = v.findViewById(R.id.txtChuVi);
        TextView DienTich = v.findViewById(R.id.txtDienTich);
        Button btn = v.findViewById(R.id.btnCalcu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = Dai.getText().toString();
                String B = Rong.getText().toString();
                float a = Float.parseFloat(A);
                float b = Float.parseFloat(B);
                float CV = 2*(a+b);
                float DT = a*b;

                String cv = String.valueOf(CV);
                String dt  =String.valueOf(DT);

                ChuVi.setText(cv);
                DienTich.setText(dt);


            }
        });


        // Inflate the layout for this fragment
        return v;
    }
}