package ntu.hoang.ontap3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plus);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView txtA = findViewById(R.id.txta);
        TextView txtB = findViewById(R.id.txtb);
        TextView txtresult = findViewById(R.id.txtResult);
        Button btnpl = findViewById(R.id.btnPlus);



        btnpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = txtA.getText().toString();
                int A= Integer.parseInt(a);
                String b = txtB.getText().toString();
                int B= Integer.parseInt(b);
                int Tong = A+B;
                String Result = String.valueOf(Tong);
                txtresult.setText(Result);
            }
        });





    }
}