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
import nataya.pilipili.bean.TuijianBean;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/23.
 */
public class TuijianAdapter extends BaseAdapter {
    private final Context context;
    private final TuijianBean data;

    public TuijianAdapter(Context context, TuijianBean tuijianBean) {
        this.context = context;
        this.data = tuijianBean;
    }

    @Override
    public int getCount() {
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
            convertView = View.inflate(context, R.layout.item_tuijian1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(data.getData().get(position).getCover()).into(viewHolder.ivItemTuijian1);
        viewHolder.tvItemTuijian1Danmu.setText(NumUtils.getNum(data.getData().get(position).getDanmaku()));
        viewHolder.tvItemTuijian1Miaoshu.setText(data.getData().get(position).getDesc() + "");
        viewHolder.tvItemTuijian1Play.setText(NumUtils.getNum(data.getData().get(position).getPlay()));
        viewHolder.tvItemTuijian1Shijian.setText(NumUtils.getTime(data.getData().get(position).getDuration()));
        viewHolder.tvItemTuijian1Title.setText(data.getData().get(position).getTname() + "");

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.iv_item_tuijian1)
        ImageView ivItemTuijian1;
        @InjectView(R.id.tv_item_tuijian1_play)
        TextView tvItemTuijian1Play;
        @InjectView(R.id.tv_item_tuijian1_danmu)
        TextView tvItemTuijian1Danmu;
        @InjectView(R.id.tv_item_tuijian1_shijian)
        TextView tvItemTuijian1Shijian;
        @InjectView(R.id.tv_item_tuijian1_title)
        TextView tvItemTuijian1Title;
        @InjectView(R.id.tv_item_tuijian1_miaoshu)
        TextView tvItemTuijian1Miaoshu;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
