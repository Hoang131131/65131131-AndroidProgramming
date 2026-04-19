package ntu.hoang.ontap2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new FoodFragment()).commit();

        BottomNavigationView navigation = findViewById(R.id.btmnav);
        navigation.setOnItemSelectedListener(item -> {
            Fragment fragmentselection = null;
            int id = item.getItemId();
            if (id==R.id.Home)
                fragmentselection = new FoodFragment();


            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentselection).commit();

            return true;

        });







    }
}