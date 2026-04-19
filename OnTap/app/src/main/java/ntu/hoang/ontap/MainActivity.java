package ntu.hoang.ontap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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

        //Lệnh hiện fragment tính tổng khi mở
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new SumFragment()).commit();

        //Khai báo nav
        BottomNavigationView navigation = findViewById(R.id.navigation);
        //Khi nhấn vào nút trên nav
        navigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            if(id==R.id.sum)
                selectedFragment = new SumFragment();
            else if (id == R.id.list)
                selectedFragment = new ListFragment();
            else if (id == R.id.image)
                selectedFragment = new ImagesFragment();
            else if (id == R.id.profile)
                selectedFragment = new ProfileFragment();

            if (selectedFragment!=null)
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, selectedFragment).commit();

            return true;
        });


    }
}