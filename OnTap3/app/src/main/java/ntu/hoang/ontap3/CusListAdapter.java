package ntu.hoang.ontap3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class CusListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CusList> CusLists;

    public CusListAdapter(Context context, List<CusList> CusLists) {
        this.context = context;
        this.CusLists = CusLists;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return CusLists.size();
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

        if (convertView == null)
            convertView = inflater.inflate(R.layout.cuslist,parent, false);
        TextView Custitle = convertView.findViewById(R.id.txtCus);
        ImageView Cusimg = convertView.findViewById(R.id.imgCus);

        CusList cusList = CusLists.get(position);
        Custitle.setText(cusList.getCusTitle());
        Cusimg.setImageResource(cusList.getCusImg());

        return convertView;
    }
}
