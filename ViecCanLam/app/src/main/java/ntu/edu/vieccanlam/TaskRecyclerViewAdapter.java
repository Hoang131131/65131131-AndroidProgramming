package ntu.edu.vieccanlam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ItemViewHolder> {
    private List<Task> dataSource;

    public TaskRecyclerViewAdapter(List<Task> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Task task = dataSource.get(position);
        holder.tvTenViec.setText(task.getName());
        holder.tvThoiGian.setText(task.getDate());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTenViec, tvThoiGian;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenViec = itemView.findViewById(R.id.tv_ten_viec);
            tvThoiGian = itemView.findViewById(R.id.tv_thoi_gian);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Task task = dataSource.get(pos);
            Toast.makeText(v.getContext(), "Bạn chọn: " + task.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}

