package ntu.hoang.baith12fragmentdong;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import ntu.hoang.baith12fragmentdong.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager  = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frameContent, new ContentFragment())
                .add(R.id.frameFooter, new FooterFragment())
                .commit();
    }
}