package ntu.edu.vieccanlam;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddTaskActivity extends AppCompatActivity {
    EditText edtName, edtMsg, edtDate, edtPriority;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtName = findViewById(R.id.edt_ten_viec);
        edtMsg = findViewById(R.id.edt_message);
        edtDate = findViewById(R.id.edt_date);
        edtPriority = findViewById(R.id.edt_priority);

        myRef = FirebaseDatabase.getInstance().getReference("tasks");

        findViewById(R.id.fab_save).setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String msg = edtMsg.getText().toString();
            String date = edtDate.getText().toString();
            String priority = edtPriority.getText().toString();

            Task task = new Task(name, msg, date, priority);

            String key = myRef.push().getKey();

            Map<String, Object> item = new HashMap<>();
            item.put(key, task.toFirebaseObject());

            myRef.updateChildren(item, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    if (error == null) {
                        finish();
                    }
                }
            });
        });
    }
}

