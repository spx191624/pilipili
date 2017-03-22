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
import nataya.pilipili.bean.ZhiboBean;

/**
 * Created by 191624 on 2017/3/21.
 */
public class GridAdapter extends BaseAdapter {
    private final Context context;
    private final ZhiboBean.DataBean.PartitionsBean data;




    public GridAdapter(Context context, ZhiboBean.DataBean.PartitionsBean partitionsBean) {
        this.context = context;
        this.data = partitionsBean;
    }

    @Override
    public int getCount() {
        return data.getLives().size();
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
            convertView = View.inflate(context, R.layout.item_gridview_zhibo, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ZhiboBean.DataBean.PartitionsBean.LivesBean livesBean =data.getLives().get(position);
        Glide.with(context).load(livesBean.getCover().getSrc()).into(viewHolder.ivGridZhibo);
        viewHolder.tvRenshuGridZhibo.setText(livesBean.getOnline()+"");
        viewHolder.tvNameGridZhibo.setText(livesBean.getTitle());
        viewHolder.tvUperGridZhibo.setText(livesBean.getOwner().getName());

        return null;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_grid_zhibo)
        ImageView ivGridZhibo;
        @InjectView(R.id.tv_name_grid_zhibo)
        TextView tvNameGridZhibo;
        @InjectView(R.id.tv_uper_grid_zhibo)
        TextView tvUperGridZhibo;
        @InjectView(R.id.tv_renshu_grid_zhibo)
        TextView tvRenshuGridZhibo;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
