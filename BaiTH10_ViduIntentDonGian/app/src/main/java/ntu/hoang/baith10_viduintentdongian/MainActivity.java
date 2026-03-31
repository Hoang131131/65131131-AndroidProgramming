package ntu.hoang.baith10_viduintentdongian;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView numberBox;

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

        numberBox = findViewById(R.id.Number);

        setNumberClick(R.id.btn1);
        setNumberClick(R.id.btn2);
        setNumberClick(R.id.btn3);
        setNumberClick(R.id.btn4);
        setNumberClick(R.id.btn5);
        setNumberClick(R.id.btn6);
        setNumberClick(R.id.btn7);
        setNumberClick(R.id.btn11);
        setNumberClick(R.id.btn9);
        setNumberClick(R.id.btn);
        setNumberClick(R.id.btn10);
        setNumberClick(R.id.btn8);

        MaterialButton btnDel = findViewById(R.id.btndel);
        btnDel.setOnClickListener(v -> {
            String current = numberBox.getText().toString();
            if (!current.isEmpty()) {
                numberBox.setText(current.substring(0, current.length() - 1));
            }
        });

        MaterialButton btnCall = findViewById(R.id.btncal);
        btnCall.setOnClickListener(v -> {
            String phone = numberBox.getText().toString();
            if (!phone.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
    }

    private void setNumberClick(int id) {
        Button btn = findViewById(id);
        btn.setOnClickListener(v -> {
            String current = numberBox.getText().toString();
            String value = btn.getText().toString();
            numberBox.setText(current + value);
        });
    }
}