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
import nataya.pilipili.bean.HuatiBean;

/**
 * Created by 191624 on 2017/3/24.
 */
public class HuatiAdapter extends BaseAdapter {
    private final HuatiBean data;
    private final Context context;

    public HuatiAdapter(Context context, HuatiBean huatiBean) {
        this.context = context;
        this.data = huatiBean;
    }

    @Override
    public int getCount() {
        return data.getList().size();
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
            convertView = View.inflate(context, R.layout.item_huatizhongxin, null);
            viewHolder = new  ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(data.getList().get(position).getCover()).into(viewHolder.ivItemHuatizhongxin);
        viewHolder.tvItemHuatizhongxin.setText(data.getList().get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_item_huatizhongxin)
        ImageView ivItemHuatizhongxin;
        @InjectView(R.id.tv_item_huatizhongxin)
        TextView tvItemHuatizhongxin;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
