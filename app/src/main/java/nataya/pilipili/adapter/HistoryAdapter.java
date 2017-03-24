package nataya.pilipili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.History;

/**
 * Created by 191624 on 2017/3/24.
 */
public class HistoryAdapter extends BaseAdapter {
    private final Context context;
    private final List<History> data;

    public HistoryAdapter(Context context, List<History> histories) {
        this.context = context;
        this.data = histories;
    }

    @Override
    public int getCount() {
        return data.size();
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
            convertView = View.inflate(context, R.layout.item_history, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvHistory.setText(data.get(position).getText());
        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.tv_history)
        TextView tvHistory;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
