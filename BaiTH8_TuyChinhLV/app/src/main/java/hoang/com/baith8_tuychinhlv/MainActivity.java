package hoang.com.baith8_tuychinhlv;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        ListView CountryList = (ListView) findViewById(R.id.list_country);

        ArrayList<Country> countrylist = new ArrayList<Country>();

        countrylist.add(new Country("Việt Nam",R.drawable.vn, "102300000"));
        countrylist.add(new Country("United State",R.drawable.us, "341800000"));
        countrylist.add(new Country("Russia", R.drawable.rus, "143700000"));

        CustomListAdapter adapter = new CustomListAdapter(this, countrylist);

        CountryList.setAdapter(adapter);

        CountryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Country choosenCountry = countrylist.get(i);
                Toast.makeText(MainActivity.this, choosenCountry.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

}

