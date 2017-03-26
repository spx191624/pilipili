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
import nataya.pilipili.bean.ZhiboBean;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/27.
 */
public class ZhiboGridAdapter extends BaseAdapter {


    private final Context context;
    private List<ZhiboBean.DataBean.PartitionsBean.LivesBean> datas;

    public ZhiboGridAdapter(Context context) {
        this.context =context;
    }

    @Override
    public int getCount() {
        if (datas != null) {
            return datas.size();
        }
        return 0;

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
            convertView = View.inflate(context, R.layout.item_zhibo, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (datas == null) {
            return convertView;
        }
        viewHolder.tvItemTuijian1Title.setText(datas.get(position).getTitle());
        viewHolder.tvItemZhiboName.setText(datas.get(position).getOwner().getName());
        viewHolder.tvItemZhiboRenshu.setText(NumUtils.getNum(datas.get(position).getOnline()));

        Glide.with(context).load(datas.get(position).getCover().getSrc()).into(viewHolder.ivItemTuijian1);

        return convertView;
    }

    public void setData(List<ZhiboBean.DataBean.PartitionsBean.LivesBean> lives) {
        this.datas = lives;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_item_tuijian1)
        ImageView ivItemTuijian1;
        @InjectView(R.id.tv_item_tuijian1_title)
        TextView tvItemTuijian1Title;
        @InjectView(R.id.tv_item_zhibo_name)
        TextView tvItemZhiboName;
        @InjectView(R.id.tv_item_zhibo_renshu)
        TextView tvItemZhiboRenshu;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
