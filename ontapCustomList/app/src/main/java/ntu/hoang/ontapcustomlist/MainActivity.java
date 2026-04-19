package ntu.hoang.ontapcustomlist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listMonAn;
    ArrayList<MonAn> arrayList;
    MonAnAdapter adapter;

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

        listMonAn = findViewById(R.id.lstfood);
        arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Bánh kem",android.R.drawable.ic_menu_report_image));
        arrayList.add(new MonAn("Bánh tráng",android.R.drawable.ic_menu_report_image));
        arrayList.add(new MonAn("Bánh mì",android.R.drawable.ic_menu_report_image));

        adapter = new MonAnAdapter(this,arrayList);
        listMonAn.setAdapter(adapter);








    }
}