package till.edu.baith4_linearlayout_tong2so;

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
    }




    public void Plus(View view){
        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);

        int Tong = a+b;
        String TONG = String.valueOf((Tong));
        editTextKQ.setText(TONG);
    }

    public void Minus(View view){
        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);

        int Tong = a-b;
        String TONG = String.valueOf((Tong));
        editTextKQ.setText(TONG);
    }
    public void Multiply(View view){
        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);

        int Tong = a*b;
        String TONG = String.valueOf((Tong));
        editTextKQ.setText(TONG);
    }

    public void Divide(View view){
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