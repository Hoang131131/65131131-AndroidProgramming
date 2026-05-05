package ntu.edu.bonuslogin;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    String loggedInUser;
    TextView tvHello;
    ListView lvFoods;
    ArrayList<String> listNames;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        loggedInUser = getIntent().getStringExtra("USERNAME");

        lvFoods = findViewById(R.id.lvFoods);
        listNames = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNames);
        lvFoods.setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(v -> showAddDialog());
        findViewById(R.id.btnRandom).setOnClickListener(v -> pickRandomFood());

        loadDataFromFirestore();
    }

    private void loadDataFromFirestore() {
        db.collection("foods").whereEqualTo("owner", loggedInUser)
                .addSnapshotListener((value, error) -> {
                    if (value != null) {
                        listNames.clear();
                        for (QueryDocumentSnapshot doc : value) {
                            listNames.add(doc.getString("name"));
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setHint("Nhập tên món ăn...");
        input.setPadding(50, 40, 50, 40);

        builder.setTitle("Thêm món mới")
                .setView(input)
                .setCancelable(true)
                .setPositiveButton("THÊM", (dialog, id) -> {
                    String foodName = input.getText().toString().trim();
                    if (!foodName.isEmpty()) {
                        saveToFirestore(foodName);
                    }
                });
        builder.create().show();
    }

    private void saveToFirestore(String name) {
        Map<String, Object> food = new HashMap<>();
        food.put("name", name);
        food.put("owner", loggedInUser);

        db.collection("foods").add(food)
                .addOnSuccessListener(aVoid -> Toast.makeText(this, "Đã thêm!", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private void pickRandomFood() {
        db.collection("foods").whereEqualTo("owner", loggedInUser).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        List<String> foodList = new ArrayList<>();
                        for (QueryDocumentSnapshot doc : task.getResult()) {
                            foodList.add(doc.getString("name"));
                        }

                        if (foodList.size() > 0) {
                            int index = new Random().nextInt(foodList.size());
                            showResultDialog(foodList.get(index));
                        } else {
                            Toast.makeText(this, "Hãy thêm món ăn trước đã!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void showResultDialog(String foodName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kết quả ngẫu nhiên:")
                .setMessage("Hôm nay bạn hãy ăn:\n\n" + foodName.toUpperCase())
                .setPositiveButton("TUYỆT!", null)
                .setCancelable(true);
        builder.create().show();
    }
}