package ntu.hoang.baith10_viduintentdongian;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class CallActivity extends AppCompatActivity {

    TextView tvPhoneNumber;
    MaterialButton btnEndCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called);

        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        btnEndCall = findViewById(R.id.btnEndCall);

        String phone = getIntent().getStringExtra("phone");
        tvPhoneNumber.setText(phone);

        btnEndCall.setOnClickListener(v -> finish());
    }
}
