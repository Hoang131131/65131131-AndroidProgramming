package ntu.hoang.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<News> list;
    Context context;

    public NewsAdapter(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, desc;

        public ViewHolder(View v) {
            super(v);
            img = v.findViewById(R.id.img);
            title = v.findViewById(R.id.title);
            desc = v.findViewById(R.id.desc);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int i) {
        News n = list.get(i);

        h.title.setText(n.title);
        h.desc.setText(n.description);

        Picasso.get().load(n.imageUrl).into(h.img);

        h.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra("link", n.link);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
