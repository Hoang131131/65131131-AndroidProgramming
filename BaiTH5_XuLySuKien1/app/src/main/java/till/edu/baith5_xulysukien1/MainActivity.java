package till.edu.baith5_xulysukien1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;


    void TimDieuKhuyen(){
        editTextA = findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        editTextKQ = findViewById(R.id.edtKQ);
        nutCong = findViewById(R.id.btnplus);
        nutTru = findViewById(R.id.btnminus);
        nutNhan = findViewById(R.id.btnmultiply);
        nutChia = findViewById(R.id.btndivide);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimDieuKhuyen();

        View.OnClickListener bolangnghecong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = editTextA.getText().toString();
                String B = editTextB.getText().toString();

                int a = Integer.parseInt(A);
                int b = Integer.parseInt(B);

                int Tong = a+b;
                String TONG = String.valueOf((Tong));
                editTextKQ.setText(TONG);
            }
        };
        nutCong.setOnClickListener(bolangnghecong);

        View.OnClickListener bolangnghetru = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = editTextA.getText().toString();
                String B = editTextB.getText().toString();

                int a = Integer.parseInt(A);
                int b = Integer.parseInt(B);

                int Tong = a-b;
                String TONG = String.valueOf((Tong));
                editTextKQ.setText(TONG);
            }
        };
        nutTru.setOnClickListener(bolangnghetru);

        View.OnClickListener bolangnghenhan = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Multiply();
            }
        };
        nutNhan.setOnClickListener(bolangnghenhan);

        View.OnClickListener bolanggnghechia = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Divide();
            }
        };
        nutChia.setOnClickListener(bolanggnghechia);

    }


    void Multiply(){
        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);

        int Tong = a*b;
        String TONG = String.valueOf((Tong));
        editTextKQ.setText(TONG);
    }

    void Divide(){
        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        if (b==0)
            editTextKQ.setText("Khong the chia");
        else{
            double Tong = 1.0*a/b;
            String TONG = String.valueOf((Tong));
            editTextKQ.setText(TONG);
        }
    }
}