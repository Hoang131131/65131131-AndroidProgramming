package thigk2.tranhungbaohoang.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DuLichAdapter extends BaseAdapter {

    private Context context;
    private List<DuLich> DanhMucDuLich;
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return DanhMucDuLich.size();
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
        if (convertView==null)
            convertView = inflater.inflate(R.layout.dulich,parent,false);

        TextView Title = convertView.findViewById(R.id.txtDiaDiem);
        TextView Desc = convertView.findViewById(R.id.txtDiaChi);
        ImageView imageView = convertView.findViewById(R.id.imgDuLich);

        DuLich duLich = DanhMucDuLich.get(position);
        Title.setText(duLich.getDiaDiem());
        Desc.setText(duLich.getDiaChi());
        imageView.setImageResource(duLich.getImgID());




        return convertView;
    }



}
