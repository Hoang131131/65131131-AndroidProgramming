package ntu.hoang.ontap2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class FoodAdapter extends BaseAdapter {

    private List<Food> Datas;
    private LayoutInflater inflater;
    private Context context;

    public FoodAdapter(List<Food> datas, Context context) {
        this.Datas = datas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return Datas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
            convertView=inflater.inflate(R.layout.food, parent, false);

        TextView txtTitle = convertView.findViewById(R.id.txtfood);
        ImageView imgFood = convertView.findViewById(R.id.imgfood);

        Food food = Datas.get(position);

        txtTitle.setText(food.getTitle());
        imgFood.setImageResource(food.getImgid());



        return convertView;
    }
}
