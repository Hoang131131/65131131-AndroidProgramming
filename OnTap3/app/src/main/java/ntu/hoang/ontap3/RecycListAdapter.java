package ntu.hoang.ontap3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycListAdapter extends RecyclerView.Adapter<RecycListAdapter.RecycListViewHolder> {

    private Context context;
    private List<RecycList> ReList;
    private LayoutInflater inflater;

    public RecycListAdapter(Context context, List<RecycList> ReList ){
        this.context=context;
        this.ReList=ReList;
        this.inflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecycListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recyclist,parent,false);
        RecycListViewHolder ReViewHolder = new RecycListViewHolder(v);
        return ReViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycListViewHolder holder, int position) {
        RecycList list = ReList.get(position);
        holder.txtReList.setText(list.getReTitle());
        holder.btnReList.setText(list.getReBtn());
    }

    @Override
    public int getItemCount() {
        return ReList.size();
    }

    class RecycListViewHolder extends RecyclerView.ViewHolder{
        TextView txtReList;
        Button btnReList;
        public RecycListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtReList = itemView.findViewById(R.id.txtRe);
            btnReList = itemView.findViewById(R.id.btnRe);
        }
    }

}