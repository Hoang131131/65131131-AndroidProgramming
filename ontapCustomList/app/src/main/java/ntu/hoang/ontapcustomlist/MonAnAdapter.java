package ntu.hoang.ontapcustomlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;


/// Phải có base adapter
public class MonAnAdapter extends BaseAdapter {
    private Context context;
    private List<MonAn> listmonan;

    public MonAnAdapter(Context context, List<MonAn> listmonan){
        this.context=context;
        this.listmonan=listmonan;

    }



    @Override
    public int getCount() {
        return listmonan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.moman,null);

        TextView txtmonan = convertView.findViewById(R.id.txtfood);
        ImageView imgmonan = convertView.findViewById(R.id.imgfood);

        MonAn monan = listmonan.get(position);
        txtmonan.setText(monan.getName());
        imgmonan.setImageResource(monan.getImgId());


        return convertView;
    }
}
