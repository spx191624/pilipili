package nataya.pilipili.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

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
    private ZhiboBean zhiboBean;
    final List<String> urls = new ArrayList<>();

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_zhibo, null);
        ButterKnife.inject(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);

        recycleviewZhibo.setLayoutManager(layoutManager);
        recycleviewZhibo.setHasFixedSize(true);
        recycleviewZhibo.setNestedScrollingEnabled(false);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        LoadFromNet.getFromNet(AppNetConfig.BASE_ZHIBO, new LoadNet() {
            @Override
            public void success(String context) {
                if (context!=null){
                    processData(context);
                }
            }
            @Override
            public void failed(String error) {

            }
        });

    }

    private void processData(String context) {
        zhiboBean = JSON.parseObject(context, ZhiboBean.class);
        initBanner(zhiboBean);
        adapter = new MyRecycleViewAdapter(getContext(),zhiboBean.getData());
        recycleviewZhibo.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recycleviewZhibo.setLayoutManager(manager);

    }

    private void initBanner(final ZhiboBean zhiboBean) {
        for (int i = 0; i < zhiboBean.getData().getBanner().size(); i++) {
            urls.add(zhiboBean.getData().getBanner().get(i).getImg());
        }

        bannerZhibo.setImageLoader(new GlideImageLoder());
        bannerZhibo.setImages(urls);
        bannerZhibo.setBannerStyle(BannerConfig.NOT_INDICATOR);
        bannerZhibo.isAutoPlay(false);
        bannerZhibo.start();

        bannerZhibo.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                int i=position;
                if (position!=0){
                    i=position%zhiboBean.getData().getBanner().size();
                }
                Toast.makeText(getContext(), zhiboBean.getData().getBanner().get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
