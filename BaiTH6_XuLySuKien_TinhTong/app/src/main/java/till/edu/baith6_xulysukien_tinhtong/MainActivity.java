package till.edu.baith6_xulysukien_tinhtong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }



    public void XuLyTong(View view){
        EditText editTextA = findViewById(R.id.A);
        EditText editTextB = findViewById(R.id.B);
        EditText editTextTong = findViewById(R.id.Tong);

        String A = editTextA.getText().toString();
        String B = editTextB.getText().toString();
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int tong = a+b;
        String TONG = String.valueOf(tong);
        editTextTong.setText(TONG);

    }
}