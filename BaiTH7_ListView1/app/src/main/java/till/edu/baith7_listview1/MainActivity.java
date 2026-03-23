package till.edu.baith7_listview1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> danhSachDuLieu = new ArrayList<>();
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


        ListView lvDanhSach = findViewById(R.id.lv_danh_sach);


        danhSachDuLieu.add("Hà Nội");
        danhSachDuLieu.add("Hồ Chí Minh");
        danhSachDuLieu.add("Đồng Nai");
        danhSachDuLieu.add("Bình thuận");
        danhSachDuLieu.add("Ninh Thuận");
        danhSachDuLieu.add("Nha Trang");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, danhSachDuLieu
        );

        lvDanhSach.setAdapter(adapter);

        lvDanhSach.setOnItemClickListener(BoLangNghevaXL);


    }

    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String strdanhsach = danhSachDuLieu.get(position);

            Toast.makeText(MainActivity.this, strdanhsach, Toast.LENGTH_LONG).show();
        }
    };


}