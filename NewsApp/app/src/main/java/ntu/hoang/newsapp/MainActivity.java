package ntu.hoang.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<News> list = new ArrayList<>();
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsAdapter(list, this);
        recyclerView.setAdapter(adapter);

        new Thread(() -> {
            List<News> data = RSSParser.getRSS("https://vnexpress.net/rss/giao-duc.rss");

            runOnUiThread(() -> {
                list.addAll(data);
                adapter.notifyDataSetChanged();
            });
        }).start();
    }
}