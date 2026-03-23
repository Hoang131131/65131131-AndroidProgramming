package hoang.com.baith8_tuychinhlv;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Country> CountryList; // Lưu dữ liệu được nạp từ DataSource cho Adapter
    private LayoutInflater layoutInflater; // Chuyển đổi Layout XML thành View java
    private Context context;

    public CustomListAdapter(Context aContext, List<Country> CountryList) {
        this.CountryList = CountryList;
        this.context = aContext;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return CountryList.size();
    }

    @Override
    public Object getItem(int position) {
        return CountryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHienHanh = view;
        if (viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.custom_item, null);
        Country country = CountryList.get(i);
        TextView textView_Name = (TextView) viewHienHanh.findViewById(R.id.txtName);
        TextView textView_Population = (TextView) viewHienHanh.findViewById(R.id.txtPopulation);
        ImageView imageView_Flag = (ImageView) viewHienHanh.findViewById(R.id.imgFlag);

        textView_Name.setText(country.getName());
        textView_Population.setText(country.getPopulation());
        imageView_Flag.setImageResource(country.getFlag());

        return viewHienHanh;
    }
}
