package nataya.pilipili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.ZhiboBean;

/**
 * Created by 191624 on 2017/3/21.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private static final int ITEM = 1;
    private final Context context;
    private final ZhiboBean.DataBean datas;
    private final LayoutInflater inflater;
    public int type =ITEM;

    public MyRecycleViewAdapter(Context context, ZhiboBean.DataBean data) {
        this.context = context;
        this.datas = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position >0){
            type=ITEM;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM){
            return new MyViewHolder(context, inflater.inflate(R.layout.item_recycleview_zhibo, null));
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==ITEM){
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.setData(datas.getPartitions().get(position));
        }

    }


    @Override
    public int getItemCount() {
        return datas.getPartitions().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tv_item_recycle_zhibo)
        TextView tvItemRecycleZhibo;
        @InjectView(R.id.tv_renshu_recycle_zhibo)
        TextView tvRenshuRecycleZhibo;
        @InjectView(R.id.gv_recycle_zhibo)
        GridView gvRecycleZhibo;
        GridAdapter adapter;
        public MyViewHolder(Context context, View item) {
            super(item);
            ButterKnife.inject(this, item);
        }


        public void setData(ZhiboBean.DataBean.PartitionsBean partitionsBean) {
//            adapter = new GridAdapter(context,partitionsBean);
//            gvRecycleZhibo.setAdapter(adapter);
            tvItemRecycleZhibo.setText(partitionsBean.getPartition().getName());
            tvRenshuRecycleZhibo.setText("当前"+partitionsBean.getPartition().getCount()+"个直播");
        }
    }




}
