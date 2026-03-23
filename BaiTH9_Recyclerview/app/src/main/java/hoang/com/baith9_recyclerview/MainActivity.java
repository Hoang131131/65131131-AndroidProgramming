package hoang.com.baith9_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandscapeAdapter landscapeAdapter;
    ArrayList<Landscape> recyclerlandscapes;

    RecyclerView recyclerViewlandscape;


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

        recyclerlandscapes = getDataforRecyclerView();
        recyclerViewlandscape = findViewById(R.id.ls);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewlandscape.setLayoutManager(layoutLinear);
        landscapeAdapter = new LandscapeAdapter(this, recyclerlandscapes);
        recyclerViewlandscape.setAdapter(landscapeAdapter);



    }

    ArrayList<Landscape> getDataforRecyclerView(){
        ArrayList<Landscape> DSLandscape = new ArrayList<Landscape>();
        DSLandscape.add(new Landscape("Cột cờ Hà Nội", "hn"));
        DSLandscape.add(new Landscape("Tháp Effle", "ef"));
        DSLandscape.add(new Landscape("Cung điện Buckingham", "bh"));
        DSLandscape.add(new Landscape("Tượng Nữ Thần Tự Do", "us"));
        return DSLandscape;

    }
}