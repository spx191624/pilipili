package nataya.pilipili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anye.greendao.gen.GoodBeanDao;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.GoodBean;
import nataya.pilipili.utils.MyApplication;
import nataya.pilipili.utils.NumChangeListener;

/**
 * Created by 191624 on 2017/3/28.
 */
public class GoodsAdapter extends BaseAdapter {
    private final Context context;
    private List<GoodBean> data;
    private GoodBeanDao dao;
    private List<GoodBean> olddata;
    private NumChangeListener listener;

    public GoodsAdapter(Context context, NumChangeListener listener) {
        this.context = context;
        this.listener = listener;
        dao = MyApplication.getInstances().getDaoSession().getGoodBeanDao();
        olddata = dao.loadAll();
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.popupwindow_add_product, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (data == null) {
            return convertView;
        }
        viewHolder.num.setText(data.get(position).getNum() + "");
        viewHolder.tvGoodinfoName.setText(data.get(position).getName());
        viewHolder.tvGoodinfoPrice.setText(data.get(position).getPrice() + "");
        Glide.with(context).load(data.get(position).getUrl()).into(viewHolder.ivGoodinfoPhoto);
        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.num.setText(Integer.parseInt(String.valueOf(viewHolder.num.getText()))+1+"");
                for (int i = 0; i <olddata.size() ; i++) {
                    if (olddata.get(i).getShuid()==data.get(position).getShuid()){
                        data.get(position).setNum(data.get(position).getNum()+1);
                        dao.update(data.get(position));
                    }
                }
                listener.changed();
            }
        });
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.num.setText(Integer.parseInt(String.valueOf(viewHolder.num.getText()))-1+"");
                for (int i = 0; i <olddata.size() ; i++) {
                    if (olddata.get(i).getShuid()==data.get(position).getShuid()){
                        data.get(position).setNum(data.get(position).getNum()-1);
                        if (data.get(position).getNum()==0){
                            dao.delete(data.get(position));
                            data.remove(position);
                            listener.changed();
                            notifyDataSetChanged();
                            return;
                        }

                        dao.update(data.get(position));
                    }
                }
                listener.changed();
            }
        });

        return convertView;
    }

    public void setData(List<GoodBean> list) {
        this.data = list;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_goodinfo_photo)
        ImageView ivGoodinfoPhoto;
        @InjectView(R.id.tv_goodinfo_name)
        TextView tvGoodinfoName;
        @InjectView(R.id.tv_goodinfo_price)
        TextView tvGoodinfoPrice;
        @InjectView(R.id.add)
        TextView add;
        @InjectView(R.id.num)
        TextView num;
        @InjectView(R.id.delete)
        TextView delete;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
