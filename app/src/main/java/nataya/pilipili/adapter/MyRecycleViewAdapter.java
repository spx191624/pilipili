package nataya.pilipili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.ZhiboActivity;
import nataya.pilipili.bean.ZhiboBean;
import nataya.pilipili.utils.NumUtils;
import nataya.pilipili.utils.MyGridView;

/**
 * Created by 191624 on 2017/3/21.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private static final int ITEM = 1;
    private final Context context;
    private ZhiboBean.DataBean datas =null;
    private final LayoutInflater inflater;

    public int type = ITEM;


    public MyRecycleViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == ITEM) {
            type = ITEM;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM) {
            return new MyViewHolder(context, inflater.inflate(R.layout.item, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.setData(datas.getPartitions().get(position).getLives(),position);

        }


    }


    @Override
    public int getItemCount() {
        if (datas == null) {
            return 0;
        } else {
            return datas.getPartitions().size();
        }
    }

    public void setData(ZhiboBean zhiboBean) {
        if (zhiboBean == null) {
            return;
        }
        this.datas = zhiboBean.getData();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        @InjectView(R.id.iv_item_recycle_zhibo)
        ImageView ivItemRecycleZhibo;
        @InjectView(R.id.tv_item_recycle_zhibo)
        TextView tvItemRecycleZhibo;
        @InjectView(R.id.tv_renshu_recycle_zhibo)
        TextView tvRenshuRecycleZhibo;
        @InjectView(R.id.gv_zhibo)
        MyGridView gvZhibo;
        @InjectView(R.id.tv_item_more)
        TextView tvItemMore;
        @InjectView(R.id.tv_item_shuaxin)
        TextView tvItemShuaxin;
        ZhiboGridAdapter adapter;

        public MyViewHolder(Context context, View view) {
            super(view);
            ButterKnife.inject(this, view);
        }


        public void setData(final List<ZhiboBean.DataBean.PartitionsBean.LivesBean> lives,int position) {
            adapter = new ZhiboGridAdapter(context);
            adapter.setData(lives);
            gvZhibo.setAdapter(adapter);
            gvZhibo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String cover = lives.get(position).getCover().getSrc();
                    String url = lives.get(position).getPlayurl();
                    String title = lives.get(position).getTitle();
                    String des = "假的！\n这里的一切都是假的！";
                    String play =NumUtils.getNum(lives.get(position).getOnline());
                    String danmu =NumUtils.getNum(0);

                    String[] data = new String[]{cover,url,title,des,play,danmu};
                    Intent intent = new Intent(context, ZhiboActivity.class);
                    intent.putExtra("data",data);
                    context.startActivity(intent);


                }
            });
            tvItemRecycleZhibo.setText(datas.getPartitions().get(position).getPartition().getName());
            String str = "当前" + "<font color='#FB7299'>" + datas.getPartitions().get(position).getPartition().getCount() + "</font>" + "个直播";

            tvItemMore.setText("查看更多");
            tvItemShuaxin.setText((int)(Math.random()*100) + "条新动态，点击刷新！");
            tvRenshuRecycleZhibo.setText(Html.fromHtml(str));

            Glide.with(context).load(datas.getPartitions().get(position).getPartition().getSub_icon().getSrc()).into(ivItemRecycleZhibo);

        }


    }
}
