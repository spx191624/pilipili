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
import nataya.pilipili.bean.GridBean;

/**
 * Created by 191624 on 2017/3/21.
 */
public class GridAdapter extends BaseAdapter {
    private final Context context;
    private GridBean data;

    public GridAdapter(Context context) {
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
            convertView = View.inflate(context, R.layout.item_gridview_fenqu, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (data==null){
            return convertView;
        }

        viewHolder.tvGrid.setText(data.getData().get(position).getName());
        Glide.with(context).load(data.getData().get(position).getLogo()).into(viewHolder.ivGrid);


        return convertView;
    }

    public void setData(GridBean gridbean) {
        this.data = gridbean;
    }

    class ViewHolder {
        @InjectView(R.id.iv_grid)
        ImageView ivGrid;
        @InjectView(R.id.tv_grid)
        TextView tvGrid;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
