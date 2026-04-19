package ntu.hoang.ontap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.RecyclerListViewHolder> {

    private Context context;
    private ArrayList<ListRe> datas;
    private LayoutInflater inflater;

    public RecyclerListAdapter(Context context, ArrayList<ListRe> datas){
        this.context=context;
        this.datas=datas;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vItem = inflater.inflate(R.layout.recyclerlist, parent, false);
        RecyclerListViewHolder vholderCreated = new RecyclerListViewHolder(vItem);
        return vholderCreated;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListAdapter.RecyclerListViewHolder holder, int position) {
        ListRe list = datas.get(position);
        holder.TextVieList.setText(list.getName());
        holder.ImgList.setImageResource(list.getListid());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class RecyclerListViewHolder extends RecyclerView.ViewHolder {
        TextView TextVieList;
        ImageView ImgList;

        public RecyclerListViewHolder(View itemView) {
            super(itemView);
            TextVieList = itemView.findViewById(R.id.txtList);
            ImgList = itemView.findViewById(R.id.imgList);
        }
    }

}
