package nataya.pilipili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.ZhiboBean;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/21.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private static final int ITEM = 1;
    private final Context context;
    private final ZhiboBean.DataBean datas;
    private final LayoutInflater inflater;

    public int type = ITEM;


    public MyRecycleViewAdapter(Context context, ZhiboBean.DataBean data) {
        this.context = context;
        this.datas = data;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 0) {
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
            viewHolder.setData(datas.getPartitions().get(position));
        }


    }


    @Override
    public int getItemCount() {
        return datas.getPartitions().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_item_recycle_zhibo)
        ImageView ivItemRecycleZhibo;
        @InjectView(R.id.tv_item_recycle_zhibo)
        TextView tvItemRecycleZhibo;
        @InjectView(R.id.tv_renshu_recycle_zhibo)
        TextView tvRenshuRecycleZhibo;
        @InjectView(R.id.iv_1_zhibo)
        ImageView iv1Zhibo;
        @InjectView(R.id.tv_name_1_zhibo)
        TextView tvName1Zhibo;
        @InjectView(R.id.tv_uper_1_zhibo)
        TextView tvUper1Zhibo;
        @InjectView(R.id.tv_renshu_1_zhibo)
        TextView tvRenshu1Zhibo;
        @InjectView(R.id.iv_2_zhibo)
        ImageView iv2Zhibo;
        @InjectView(R.id.tv_name_2_zhibo)
        TextView tvName2Zhibo;
        @InjectView(R.id.tv_uper_2_zhibo)
        TextView tvUper2Zhibo;
        @InjectView(R.id.tv_renshu_2_zhibo)
        TextView tvRenshu2Zhibo;
        @InjectView(R.id.iv_3_zhibo)
        ImageView iv3Zhibo;
        @InjectView(R.id.tv_name_3_zhibo)
        TextView tvName3Zhibo;
        @InjectView(R.id.tv_uper_3_zhibo)
        TextView tvUper3Zhibo;
        @InjectView(R.id.tv_renshu_3_zhibo)
        TextView tvRenshu3Zhibo;
        @InjectView(R.id.iv_4_zhibo)
        ImageView iv4Zhibo;
        @InjectView(R.id.tv_name_4_zhibo)
        TextView tvName4Zhibo;
        @InjectView(R.id.tv_uper_4_zhibo)
        TextView tvUper4Zhibo;
        @InjectView(R.id.tv_renshu_4_zhibo)
        TextView tvRenshu4Zhibo;
        @InjectView(R.id.tv_item_more)
        TextView tvItemMore;
        @InjectView(R.id.tv_item_shuaxin)
        TextView tvItemShuaxin;




        public MyViewHolder(Context context, View item) {
            super(item);
            ButterKnife.inject(this, item);
        }


        public void setData(ZhiboBean.DataBean.PartitionsBean partitionsBean) {
            if (partitionsBean != null) {

                tvName1Zhibo.setText(partitionsBean.getLives().get(0).getTitle());
                tvName2Zhibo.setText(partitionsBean.getLives().get(1).getTitle());
                tvName3Zhibo.setText(partitionsBean.getLives().get(2).getTitle());
                tvName4Zhibo.setText(partitionsBean.getLives().get(3).getTitle());


                Glide.with(context).load(partitionsBean.getLives().get(0).getCover().getSrc()).into(iv1Zhibo);
                Glide.with(context).load(partitionsBean.getLives().get(1).getCover().getSrc()).into(iv2Zhibo);
                Glide.with(context).load(partitionsBean.getLives().get(2).getCover().getSrc()).into(iv3Zhibo);
                Glide.with(context).load(partitionsBean.getLives().get(3).getCover().getSrc()).into(iv4Zhibo);

                tvRenshu1Zhibo.setText(NumUtils.getNum(partitionsBean.getLives().get(0).getOnline()));
                tvRenshu2Zhibo.setText(NumUtils.getNum(partitionsBean.getLives().get(1).getOnline()));
                tvRenshu3Zhibo.setText(NumUtils.getNum(partitionsBean.getLives().get(2).getOnline()));
                tvRenshu4Zhibo.setText(NumUtils.getNum(partitionsBean.getLives().get(3).getOnline()));

                tvUper1Zhibo.setText(partitionsBean.getLives().get(0).getOwner().getName());
                tvUper2Zhibo.setText(partitionsBean.getLives().get(1).getOwner().getName());
                tvUper3Zhibo.setText(partitionsBean.getLives().get(2).getOwner().getName());
                tvUper4Zhibo.setText(partitionsBean.getLives().get(3).getOwner().getName());

                tvItemRecycleZhibo.setText(partitionsBean.getPartition().getName());
//                tvRenshuRecycleZhibo.setText("当前" + partitionsBean.getPartition().getCount() + "个直播");

                tvItemMore.setText("查看更多");

                String str="当前"+"<font color='#FB7299'>"+partitionsBean.getPartition().getCount()+"</font>"+"个直播";


                tvItemShuaxin.setText(partitionsBean.getPartition().getCount()+"条新动态，点击刷新！");
                tvRenshuRecycleZhibo.setText(Html.fromHtml(str));




                Glide.with(context).load(partitionsBean.getPartition().getSub_icon().getSrc()).into(ivItemRecycleZhibo);
            }

        }


    }


}
