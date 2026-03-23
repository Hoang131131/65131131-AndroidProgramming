package hoang.com.baith9_recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ItemLandscapeHolder> {

    Context context;
    ArrayList<Landscape> landscapes;

    public LandscapeAdapter(Context context, ArrayList<Landscape> landscapes) {
        this.context = context;
        this.landscapes = landscapes;
    }

    @NonNull
    @Override
    public ItemLandscapeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.landscape_item, parent, false);
        ItemLandscapeHolder vholderCreated = new ItemLandscapeHolder(vItem);
        return vholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandscapeHolder holder, int position) {
        Landscape landscapeHienThi = landscapes.get(position);
        String caption = landscapeHienThi.getName();
        String image = landscapeHienThi.getImg();
        holder.Caption.setText(caption);
        String packageName = holder.itemView.getContext().getPackageName();
        int imgid = holder.itemView.getResources().getIdentifier(image, "mipmap", packageName);
        holder.Image.setImageResource(imgid);

    }

    @Override
    public int getItemCount() {
        return landscapes.size();
    }

    class ItemLandscapeHolder extends RecyclerView.ViewHolder{
        TextView Caption;
        ImageView Image;
        public ItemLandscapeHolder(@NonNull View itemView) {
            super(itemView);
                Caption = itemView.findViewById(R.id.txtName);
                Image = itemView.findViewById(R.id.imgPlace);
        }
    }
}
