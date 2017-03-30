package nataya.pilipili.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.bean.SearchBean;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/30.
 */
public class ZongheAdapter extends BaseAdapter {
    private final Context context;
    private List<SearchBean.DataBean.ItemsBean.ArchiveBean> list;

    public ZongheAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_zonghe, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (list == null) {
            return convertView;
        }

        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvUper.setText(list.get(position).getAuthor());
        viewHolder.tvDanmu.setText(NumUtils.getNum(list.get(position).getDanmaku()));
        viewHolder.tvPlay.setText(NumUtils.getNum(list.get(position).getPlay()));
        Glide.with(context).load(list.get(position).getCover()).into(viewHolder.ivItemYuanchuang);
        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cover = list.get(position).getCover();
                String url = list.get(position).getUri();
                String title = list.get(position).getTitle();
                String des = list.get(position).getDesc();
                String play = NumUtils.getNum(list.get(position).getPlay());
                String danmu = NumUtils.getNum(list.get(position).getDanmaku());

                String[] data = new String[]{cover, url, title, des, play, danmu};
                Intent intent = new Intent(context, PlayActivity.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public void setData(String context) {
        SearchBean searchBean = JSON.parseObject(context, SearchBean.class);
        list = searchBean.getData().getItems().getArchive();
    }



    static class ViewHolder {
        @InjectView(R.id.iv_item_yuanchuang)
        ImageView ivItemYuanchuang;
        @InjectView(R.id.tv_title)
        TextView tvTitle;
        @InjectView(R.id.tv_uper)
        TextView tvUper;
        @InjectView(R.id.tv_play)
        TextView tvPlay;
        @InjectView(R.id.tv_danmu)
        TextView tvDanmu;
        @InjectView(R.id.item)
        LinearLayout item;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
