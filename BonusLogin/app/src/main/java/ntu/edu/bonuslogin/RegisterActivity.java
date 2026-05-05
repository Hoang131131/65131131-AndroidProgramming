package ntu.edu.bonuslogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    EditText edtUser, edtPass, edtConfirm;
    Button btnReg;
    TextView tvToLogin;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        edtUser = findViewById(R.id.edtUserNameReg);
        edtPass = findViewById(R.id.edtPasswordReg);
        edtConfirm = findViewById(R.id.edtConfirmPasswordReg);
        btnReg = findViewById(R.id.btnRegister);
        tvToLogin = findViewById(R.id.tvToLogin);

        btnReg.setOnClickListener(v -> {
            String user = edtUser.getText().toString().trim();
            String pass = edtPass.getText().toString().trim();
            String confirm = edtConfirm.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (user.contains(".") || user.contains("#") || user.contains("$") || user.contains("[") || user.contains("]")) {
                Toast.makeText(this, "Username không được chứa ký tự đặc biệt!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(confirm)) {
                Toast.makeText(this, "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show();
                return;
            }

            mDatabase.child("Users").child(user).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        Toast.makeText(RegisterActivity.this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();
                    } else {
                        User newUser = new User(user, pass);
                        mDatabase.child("Users").child(user).setValue(newUser)
                                .addOnSuccessListener(aVoid -> {
                                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                                    finish(); // Đóng màn hình đăng ký để về màn hình đăng nhập
                                })
                                .addOnFailureListener(e -> {
                                    Toast.makeText(RegisterActivity.this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                });
                    }
                }
                @Override
                public void onCancelled(DatabaseError error) {}
            });
        });
        tvToLogin.setOnClickListener(v -> finish());
    }
}