package ntu.hoang.ontaprecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThucDonAdapter extends RecyclerView.Adapter<ThucDonAdapter.MyViewHolder> {
    public List<ThucDon> Datas;
    public Context context;
    public ThucDonAdapter(List<ThucDon> datas, Context context){
        this.Datas=datas;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.monan,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ThucDon thucDon = Datas.get(position);
        holder.txtTitle.setText(thucDon.getTitle());
        holder.txtDesc.setText(thucDon.getDescription());
        holder.imgFood.setImageResource(thucDon.getImgId());
    }

    @Override
    public int getItemCount() {
        return Datas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtDesc;
        ImageView imgFood;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            imgFood = itemView.findViewById(R.id.imgFood);
        }
    }

}
