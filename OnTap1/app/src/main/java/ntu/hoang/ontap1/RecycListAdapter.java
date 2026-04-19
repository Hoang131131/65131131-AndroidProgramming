package ntu.hoang.ontap1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycListAdapter extends RecyclerView.Adapter<RecycListAdapter.RecycListViewHolder> {

    private Context context;
    private List<RecycList> SRecycList;
    private LayoutInflater inflater;

    public RecycListAdapter(Context context, List<RecycList> SRecycList) {
        this.context = context;
        this.SRecycList = SRecycList;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecycListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recyclist,parent,false);
        RecycListViewHolder RLViewHolder =new RecycListViewHolder(v);
        return RLViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycListViewHolder holder, int position) {
        RecycList list = SRecycList.get(position);
        holder.txtRecycList.setText(list.getTitle());
        holder.imgRecycList.setImageResource(list.getImgID());

    }

    @Override
    public int getItemCount() {
        return SRecycList.size();
    }

    class RecycListViewHolder extends RecyclerView.ViewHolder{

        TextView txtRecycList;
        ImageView imgRecycList;
        public RecycListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRecycList = itemView.findViewById(R.id.txtRecList);
            imgRecycList = itemView.findViewById(R.id.imgRecList);
        }
    }

}
