package ntu.hoang.ontap;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Gallery> ListData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context context, List<Gallery> ListData){
        this.ListData=ListData;
        this.context = context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return ListData.size(); }

    @Override
    public Object getItem(int position) { return ListData.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Sử dụng luôn biến convertView mà Android cung cấp
        if (convertView == null) {
            // PHẢI dùng layout của DÒNG (ví dụ đặt tên là list_item_layout), KHÔNG dùng layout của Fragment
            convertView = layoutInflater.inflate(R.layout.gallerylist, parent, false);
        }

        // 2. Lấy dữ liệu tại vị trí hiện tại
        Gallery gallery = ListData.get(position);

        // 3. Ánh xạ PHẢI thông qua convertView
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        ImageView imgGaly = convertView.findViewById(R.id.imggly);

        // 4. Đổ dữ liệu
        tvTitle.setText(gallery.getTitle());

        // 5. Trả về convertView (Cái đĩa đã có thức ăn)
        return convertView;
    }





}
