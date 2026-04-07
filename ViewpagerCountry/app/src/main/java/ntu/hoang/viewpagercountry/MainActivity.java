package ntu.hoang.viewpagercountry;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);

        countryList = new ArrayList<>();
        countryList.add(new Country("Việt Nam", "Vịnh Hạ Long - Di sản thiên nhiên thế giới với hàng ngàn đảo đá vôi.", R.drawable.vietnam));
        countryList.add(new Country("Pháp", "Tháp Eiffel - Biểu tượng văn hóa của Paris và kiến trúc thép độc đáo.", R.drawable.france));
        countryList.add(new Country("Nhật Bản", "Núi Phú Sĩ - Ngọn núi cao nhất Nhật Bản với vẻ đẹp hùng vĩ quanh năm.", R.drawable.japan));

        adapter = new CountryAdapter(countryList);
        viewPager2.setAdapter(adapter);

    }
}