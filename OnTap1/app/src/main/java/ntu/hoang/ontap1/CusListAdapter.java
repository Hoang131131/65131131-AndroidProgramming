package ntu.hoang.ontap1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CusListAdapter extends BaseAdapter {
    private Context context;
    private List<CusList> SCusList;
    private LayoutInflater inflater;

    public CusListAdapter(Context context, List<CusList> SCusList) {
        this.context = context;
        this.SCusList = SCusList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return SCusList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView ==null)
            convertView = inflater.inflate(R.layout.cuslist, parent, false);
        TextView txtCuslist = convertView.findViewById(R.id.txtCusList);
        ImageView imageCuslist = convertView.findViewById(R.id.imgCusList);

        CusList cuslist = SCusList.get(position);
        txtCuslist.setText(cuslist.getTitle());
        imageCuslist.setImageResource(cuslist.getImgID());

        return convertView;
    }
}
