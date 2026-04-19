package ntu.hoang.ontaprecyclerview;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ThucDonAdapter adapter;
    ArrayList<ThucDon> Menu;
    RecyclerView recyclerView;

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
        Menu = new ArrayList<>(); //Nhớ thêm cái này
        Menu.add(new ThucDon("Bánh kem", "Bánh kem kích thước L vị dâu tây",R.drawable.ic_launcher_background));
        Menu.add(new ThucDon("Bánh mì", "Bánh mì kẹp thịt pate và trứng", R.drawable.ic_launcher_background));
        Menu.add(new ThucDon("Bánh Tart", "Bánh tart trứng", R.drawable.ic_launcher_background));

        recyclerView=findViewById(R.id.RecyclerV);

        //recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        //Xếp theo hàng dọc
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ThucDonAdapter(Menu,this);
        recyclerView.setAdapter(adapter);





    }
}