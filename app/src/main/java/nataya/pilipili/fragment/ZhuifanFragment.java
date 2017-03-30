package nataya.pilipili.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.FanjuBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.NumUtils;
import nataya.pilipili.utils.ThreadPool;

/**
 * Created by 191624 on 2017/3/21.
 */

public class ZhuifanFragment extends BaseFragment {

    private static final int GUOMAN=0;
    private static final int FANJU=1;
    @InjectView(R.id.ll_zhuifan)
    LinearLayout llZhuifan;
    @InjectView(R.id.ll_tuijian)
    LinearLayout llTuijian;
    @InjectView(R.id.ll_guoman)
    LinearLayout llGuoman;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_zhuifan, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                initFromNet();
            }
        });

    }

    private void setChildViewVyInclude(View parent, int childID, FanjuBean fanjuBean, int position,int type) {

        View childview = parent.findViewById(childID);
        ImageView imageView = (ImageView) childview.findViewById(R.id.iv_item_tuijian_small);
        TextView tv_renshu = (TextView) childview.findViewById(R.id.tv_renshu_item_tuijian_small);
        TextView tv_title = (TextView) childview.findViewById(R.id.tv_title_item_tuijian_small);
        TextView tv_des = (TextView) childview.findViewById(R.id.tv_des_item_tuijian_small);
        if (type==1){
            Glide.with(getActivity()).load(fanjuBean.getResult().getPrevious().getList().get(position).getCover()).into(imageView);
            tv_renshu.setText(NumUtils.getNum(Integer.parseInt(fanjuBean.getResult().getPrevious().getList().get(position).getFavourites())) + "人追番");
            tv_title.setText(fanjuBean.getResult().getPrevious().getList().get(position).getTitle() + "");
            tv_des.setText("更新至第" + fanjuBean.getResult().getPrevious().getList().get(position).getNewest_ep_index() + "话");
        }else{
            Glide.with(getActivity()).load(fanjuBean.getResult().getSerializing().get(position).getCover()).into(imageView);
            tv_renshu.setText(NumUtils.getNum(Integer.parseInt(fanjuBean.getResult().getSerializing().get(position).getFavourites()))+"人追番");
            tv_title.setText(fanjuBean.getResult().getSerializing().get(position).getTitle() + "");
            tv_des.setText("更新至第" + fanjuBean.getResult().getSerializing().get(position).getNewest_ep_index() + "话");
        }


    }

    private void setBigViewVyInclude(View parent, int childID, FanjuBean fanjuBean, int position) {

        View childview = parent.findViewById(childID);
        ImageView imageView = (ImageView) childview.findViewById(R.id.iv_item_zhuifan_big);
        TextView tv_title = (TextView) childview.findViewById(R.id.tv_title_item_zhuifan_big);
        TextView tv_des = (TextView) childview.findViewById(R.id.tv_des_item_zhuifan_big);
        Glide.with(getActivity()).load(fanjuBean.getResult().getAd().getHead().get(position).getImg()).into(imageView);
        tv_title.setText(fanjuBean.getResult().getAd().getHead().get(position).getTitle());
        tv_des.setText("抓不到数据包了\n我能怎么办\n我也很绝望啊");

    }

    private void initFromNet() {
        LoadFromNet.getFromNet(AppNetConfig.FANJUTUIJIAN, new LoadNet() {
            @Override
            public void success(String context) {
                if (context != null) {
                    FanjuBean fanjuBean = JSON.parseObject(context, FanjuBean.class);
                    processData(fanjuBean);

                }
            }

            @Override
            public void failed(String error) {

            }
        });

    }

    private void processData(FanjuBean fanjuBean) {
        if (getActivity()==null ){
            return;
        }

        setChildViewVyInclude(llZhuifan, R.id.fanju1, fanjuBean, 0,FANJU);
        setChildViewVyInclude(llZhuifan, R.id.fanju2, fanjuBean, 1,FANJU);
        setChildViewVyInclude(llZhuifan, R.id.fanju3, fanjuBean, 2,FANJU);
        setBigViewVyInclude(llTuijian, R.id.fanju_big, fanjuBean, 0);
        setChildViewVyInclude(llGuoman, R.id.guoman1, fanjuBean, 0,GUOMAN);
        setChildViewVyInclude(llGuoman, R.id.guoman2, fanjuBean, 1,GUOMAN);
        setChildViewVyInclude(llGuoman, R.id.guoman3, fanjuBean, 2,GUOMAN);
        setBigViewVyInclude(llTuijian, R.id.guoman_big, fanjuBean, 1);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
