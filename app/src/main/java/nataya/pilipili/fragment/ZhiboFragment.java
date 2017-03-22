package nataya.pilipili.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyRecycleViewAdapter;
import nataya.pilipili.bean.ZhiboBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.GlideImageLoder;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;

/**
 * Created by 191624 on 2017/3/21.
 */

public class ZhiboFragment extends BaseFragment {
    private MyRecycleViewAdapter adapter;

    @InjectView(R.id.banner_zhibo)
    Banner bannerZhibo;
    @InjectView(R.id.recycleview_zhibo)
    RecyclerView recycleviewZhibo;

    final List<String> urls = new ArrayList<>();

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_zhibo, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        LoadFromNet.getFromNet(AppNetConfig.BASE_ZHIBO, new LoadNet() {
            @Override
            public void success(String context) {
                processData(context);
            }



            @Override
            public void failed(String error) {

            }
        });

    }

    private void processData(String context) {
        ZhiboBean zhiboBean = JSON.parseObject(context, ZhiboBean.class);
        for (int i = 0; i < 5; i++) {
            urls.add(zhiboBean.getData().getBanner().get(0).getImg());
        }
        bannerZhibo.setImageLoader(new GlideImageLoder());
        bannerZhibo.setImages(urls);
        bannerZhibo.setBannerStyle(BannerConfig.NOT_INDICATOR);
        bannerZhibo.isAutoPlay(false);
        bannerZhibo.start();


        adapter = new MyRecycleViewAdapter(getContext(),zhiboBean.getData());
        recycleviewZhibo.setAdapter(adapter);
//        recycleviewZhibo.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recycleviewZhibo.setLayoutManager(manager);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
