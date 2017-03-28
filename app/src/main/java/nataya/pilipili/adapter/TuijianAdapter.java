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
import nataya.pilipili.bean.TuijianBean;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/23.
 */
public class TuijianAdapter extends BaseAdapter {
    private final Context context;
    private List<TuijianBean.DataBean> list;

    public TuijianAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list==null){
            return 0;
        }else{
            return list.size();
        }
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
            convertView = View.inflate(context, R.layout.item_tuijian, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (list==null){
            return convertView;
        }
        Glide.with(context).load(list.get(position).getCover()).into(viewHolder.ivItemTuijian1);
        viewHolder.tvItemTuijian1Danmu.setText(NumUtils.getNum(list.get(position).getDanmaku()));
        viewHolder.tvItemTuijian1Miaoshu.setText(list.get(position).getTname() + "");
        viewHolder.tvItemTuijian1Play.setText(NumUtils.getNum(list.get(position).getPlay()));
        viewHolder.tvItemTuijian1Shijian.setText(NumUtils.getTime(list.get(position).getDuration()));
        viewHolder.tvItemTuijian1Title.setText(list.get(position).getTitle() + "");

        return convertView;
    }

    public void setData(List datas) {
        if (datas!=null){
            this.list = datas;
        }

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
