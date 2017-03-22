package nataya.pilipili.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.adapter.GridAdapter;
import nataya.pilipili.bean.FenquBean;
import nataya.pilipili.bean.GridBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/21.
 */

public class FenquFragment extends BaseFragment {
    @InjectView(R.id.gv_fenqu)
    GridView gvFenqu;
    @InjectView(R.id.scrollview_fenqu)
    ScrollView scrollviewFenqu;
    @InjectView(R.id.ll_fenqu)
    LinearLayout llFenqu;
    private GridAdapter gridAdapter;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_fenqu, null);
        ButterKnife.inject(this, view);


        return view;

    }
    private void setChildViewVyInclude(View parent,int childID,FenquBean fenquBean,int position){
        View childview = parent.findViewById(childID);
        List<ImageView> imageViews = new ArrayList<>();
        ImageView image1 = (ImageView) childview.findViewById(R.id.iv_1_zhibo);
        ImageView image2 = (ImageView) childview.findViewById(R.id.iv_2_zhibo);
        ImageView image3 = (ImageView) childview.findViewById(R.id.iv_3_zhibo);
        ImageView image4 = (ImageView) childview.findViewById(R.id.iv_4_zhibo);
        imageViews.add(image1);
        imageViews.add(image2);
        imageViews.add(image3);
        imageViews.add(image4);


        List<TextView> names = new ArrayList<>();
        TextView name1 = (TextView) childview.findViewById(R.id.tv_name_1_zhibo);
        TextView name2 = (TextView) childview.findViewById(R.id.tv_name_2_zhibo);
        TextView name3 = (TextView) childview.findViewById(R.id.tv_name_3_zhibo);
        TextView name4 = (TextView) childview.findViewById(R.id.tv_name_4_zhibo);
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);

        List<TextView> play = new ArrayList<>();
        TextView uper1 = (TextView) childview.findViewById(R.id.tv_uper_1_zhibo);
        TextView uper2 = (TextView) childview.findViewById(R.id.tv_uper_2_zhibo);
        TextView uper3 = (TextView) childview.findViewById(R.id.tv_uper_3_zhibo);
        TextView uper4 = (TextView) childview.findViewById(R.id.tv_uper_4_zhibo);
        play.add(uper1);
        play.add(uper2);
        play.add(uper3);
        play.add(uper4);


        List<TextView> danmu = new ArrayList<>();
        TextView renshu1 = (TextView) childview.findViewById(R.id.tv_renshu_1_zhibo);
        TextView renshu2 = (TextView) childview.findViewById(R.id.tv_renshu_2_zhibo);
        TextView renshu3 = (TextView) childview.findViewById(R.id.tv_renshu_3_zhibo);
        TextView renshu4 = (TextView) childview.findViewById(R.id.tv_renshu_4_zhibo);
        danmu.add(renshu1);
        danmu.add(renshu2);
        danmu.add(renshu3);
        danmu.add(renshu4);

        for (int i=0;i<imageViews.size();i++){
            Glide.with(getContext()).load(fenquBean.getData().get(position).getBody().get(i).getCover()).into(imageViews.get(i));
            names.get(i).setText(fenquBean.getData().get(position).getBody().get(i).getTitle());

            play.get(i).setText(NumUtils.getNum(fenquBean.getData().get(position).getBody().get(i).getPlay()));
            danmu.get(i).setText(NumUtils.getNum(fenquBean.getData().get(position).getBody().get(i).getDanmaku()));

        }


        TextView zhiboshu = (TextView) childview.findViewById(R.id.tv_renshu_recycle_zhibo);
        zhiboshu.setText("进去看看");

        TextView fenqu = (TextView) childview.findViewById(R.id.tv_item_recycle_zhibo);
        fenqu.setText(fenquBean.getData().get(position).getTitle());
        ImageView fenquhead = (ImageView) childview.findViewById(R.id.iv_item_recycle_zhibo);
        Glide.with(getContext()).load(R.drawable.ic_head_live).into(fenquhead);


    }


    @Override
    public void initData() {
        super.initData();
        loadFromNet();
    }

    private void loadFromNet() {
        LoadFromNet.getFromNet(AppNetConfig.GV_FENQU, new LoadNet() {
            @Override
            public void success(String context) {
                GridBean gridbean = JSON.parseObject(context, GridBean.class);
                processData(gridbean);
            }

            @Override
            public void failed(String error) {

            }
        });

        LoadFromNet.getFromNet(AppNetConfig.FENQU, new LoadNet() {
            @Override
            public void success(String context) {
                FenquBean fenquBean = JSON.parseObject(context,FenquBean.class);
                processFenquData(fenquBean);
            }

            @Override
            public void failed(String error) {

            }
        });
    }

    private void processFenquData(FenquBean fenquBean) {
        setChildViewVyInclude(llFenqu,R.id.donghuaqu,fenquBean,0);
        setChildViewVyInclude(llFenqu,R.id.yinyuequ,fenquBean,1);
        setChildViewVyInclude(llFenqu,R.id.wudaoqu,fenquBean,2);
        setChildViewVyInclude(llFenqu,R.id.youxiqu,fenquBean,4);
        setChildViewVyInclude(llFenqu,R.id.guichuqu,fenquBean,5);
        setChildViewVyInclude(llFenqu,R.id.shenghuoqu,fenquBean,7);
        setChildViewVyInclude(llFenqu,R.id.kejiqu,fenquBean,9);
        setChildViewVyInclude(llFenqu,R.id.shishangqu,fenquBean,12);
        setChildViewVyInclude(llFenqu,R.id.guanggaoqu,fenquBean,13);
        setChildViewVyInclude(llFenqu,R.id.yulequ,fenquBean,14);
        setChildViewVyInclude(llFenqu,R.id.dianshijuqu,fenquBean,15);
        setChildViewVyInclude(llFenqu,R.id.dianyingqu,fenquBean,17);

    }

    private void processData(GridBean gridbean) {
        if (gridbean != null) {
            gridAdapter = new GridAdapter(getContext(), gridbean);
            gvFenqu.setAdapter(gridAdapter);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
