package nataya.pilipili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.YuanchuangBean;

/**
 * Created by 191624 on 2017/3/24.
 */
public class YuanchuangAdapter extends BaseAdapter {
    private final Context context;
    private YuanchuangBean data;

    public YuanchuangAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        if (data==null){
            return 0;
        }
        return data.getData().size();
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
            if (position==0){
                convertView = View.inflate(context, R.layout.item_yuanchuang1, null);
            }else if (position==1){
                convertView = View.inflate(context, R.layout.item_yuanchuang2, null);
            }else if (position==2){
                convertView = View.inflate(context, R.layout.item_yuanchuang3, null);
            }else{
                convertView = View.inflate(context, R.layout.item_yuanchuang, null);
            }
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (data==null){
            return convertView;
        }
        viewHolder.tvNumItemYuanchuang.setText(1+position+"");
        viewHolder.tvPingfenItemYuanchuang.setText("综合评分："+data.getData().get(position).getPts()+"");
        viewHolder.tvTitleItemYuanchuang.setText(data.getData().get(position).getTitle());
        viewHolder.tvUperItemYuanchuang.setText(data.getData().get(position).getName());
        Glide.with(context).load(data.getData().get(position).getCover()).into(viewHolder.ivItemYuanchuang);
        return convertView;
    }

    public void setData(YuanchuangBean yuanchuangBean) {
        this.data = yuanchuangBean;
    }


    static class ViewHolder {
        @InjectView(R.id.tv_num_item_yuanchuang)
        TextView tvNumItemYuanchuang;
        @InjectView(R.id.iv_item_yuanchuang)
        ImageView ivItemYuanchuang;
        @InjectView(R.id.tv_title_item_yuanchuang)
        TextView tvTitleItemYuanchuang;
        @InjectView(R.id.tv_uper_item_yuanchuang)
        TextView tvUperItemYuanchuang;
        @InjectView(R.id.tv_pingfen_item_yuanchuang)
        TextView tvPingfenItemYuanchuang;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
