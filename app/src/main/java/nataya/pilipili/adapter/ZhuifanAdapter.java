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
import nataya.pilipili.bean.FanjuBean;

/**
 * Created by 191624 on 2017/3/23.
 */
public class ZhuifanAdapter extends BaseAdapter {
    private final Context context;
    private final FanjuBean data;

    public ZhuifanAdapter(Context context, FanjuBean fanjuBean) {
        this.context = context;
        this.data = fanjuBean;
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView = View.inflate(context, R.layout.item_tuijian_small, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Glide.with(context).load(data.getResult().getPrevious().getList().get(0).getCover()).into(viewHolder.ivItemTuijianSmall);

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_item_tuijian_small)
        ImageView ivItemTuijianSmall;
        @InjectView(R.id.tv_renshu_item_tuijian_small)
        TextView tvRenshuItemTuijianSmall;
        @InjectView(R.id.tv_title_item_tuijian_small)
        TextView tvTitleItemTuijianSmall;
        @InjectView(R.id.tv_des_item_tuijian_small)
        TextView tvDesItemTuijianSmall;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
