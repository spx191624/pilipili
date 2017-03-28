package nataya.pilipili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.ShopBean;

/**
 * Created by 191624 on 2017/3/28.
 */
public class ShopAdapter extends BaseAdapter {
    private final Context context;
    private ShopBean data;

    public ShopAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.getResult().getRecords().size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_shop, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (data==null){
            return convertView;
        }
        viewHolder.title.setText(data.getResult().getRecords().get(position).getTitle());
        viewHolder.price.setText(data.getResult().getRecords().get(position).getSalvePrice()+"");
        Glide.with(context).load(data.getResult().getRecords().get(position).getImgUrl()).into(viewHolder.iv);

        return convertView;
    }

    public void setData(ShopBean shopBean) {
        this.data = shopBean;
    }

    static class ViewHolder {
        @InjectView(R.id.iv)
        ImageView iv;
        @InjectView(R.id.title)
        TextView title;
        @InjectView(R.id.price)
        TextView price;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
