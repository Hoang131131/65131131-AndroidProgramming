package till.edu.weatherforecast;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgWeather;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWeather = findViewById(R.id.imgWeather);
        txtMessage = findViewById(R.id.txtMessage);

        getWeather();
    }

    private void getWeather() {
        new Thread(() -> {
            try {
                String apiKey = "555f6b582f3ad5b9bf601a9380617851";

                String link = "https://api.openweathermap.org/data/2.5/forecast?q=Nha%20Trang,VN&appid="
                        + apiKey + "&units=metric";

                URL url = new URL(link);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                JSONObject json = new JSONObject(result.toString());

                JSONArray list = json.getJSONArray("list");

                JSONObject firstItem = list.getJSONObject(0);

                String weather = firstItem.getJSONArray("weather")
                        .getJSONObject(0)
                        .getString("main");

                double pop = firstItem.getDouble("pop"); // xác suất mưa

                runOnUiThread(() -> {

                    if (weather.equals("Rain") || pop > 0.5) {
                        Glide.with(this).load(R.drawable.rain).into(imgWeather);
                        txtMessage.setText("🌧️ Trời hôm nay sẽ mưa đấy, bạn đừng quên cầm ô nhé!");

                    } else if (weather.equals("Clouds")) {
                        Glide.with(this).load(R.drawable.cloud).into(imgWeather);
                        txtMessage.setText("☁️ Trời nhiều mây, để đảm bảo bạn nhớ cầm theo ô nhé!");

                    } else if (weather.equals("Clear")) {
                        Glide.with(this).load(R.drawable.sun).into(imgWeather);
                        txtMessage.setText("☀️ Chúc bạn một ngày đẹp trời, hôm nay là một ngày nắng!");
                    }

                });

            } catch (Exception e) {
                e.printStackTrace();

                runOnUiThread(() ->
                        txtMessage.setText("Lỗi lấy dữ liệu thời tiết!")
                );
            }
        }).start();
    }
}