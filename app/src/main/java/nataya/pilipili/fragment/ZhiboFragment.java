package nataya.pilipili.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.activity.WebActivity;
import nataya.pilipili.adapter.MyRecycleViewAdapter;
import nataya.pilipili.bean.ZhiboBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.GlideImageLoder;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.MyApplication;
import nataya.pilipili.utils.ThreadPool;

/**
 * Created by 191624 on 2017/3/21.
 */

public class ZhiboFragment extends BaseFragment {
    @InjectView(R.id.tv_guanzhu_zhibo)
    TextView tvGuanzhuZhibo;
    @InjectView(R.id.tv_zhongxin_zhibo)
    TextView tvZhongxinZhibo;
    @InjectView(R.id.tv_sousuo_zhibo)
    TextView tvSousuoZhibo;
    @InjectView(R.id.tv_fenlei_zhibo)
    TextView tvFenleiZhibo;
    @InjectView(R.id.refresh)
    MaterialRefreshLayout refresh;
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
        adapter = new MyRecycleViewAdapter(getContext());
        recycleviewZhibo.setAdapter(adapter);
        recycleviewZhibo.setLayoutManager(layoutManager);
        recycleviewZhibo.setHasFixedSize(true);
        recycleviewZhibo.setNestedScrollingEnabled(false);


        refresh.setWaveColor(Color.parseColor("#88FB7299"));
        refresh.setIsOverLay(true);
        refresh.setWaveShow(true);
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                initData();
                refresh.finishRefresh();
            }
        });
        return view;
    }


    @Override
    public void initData() {

        super.initData();
        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                LoadFromNet.getFromNet(AppNetConfig.BASE_ZHIBO, new LoadNet() {
                    @Override
                    public void success(String context) {
                        if (context != null) {
                            processData(context);
                            Log.e("SPX", "从网络获取数据");
                            MyApplication.getInstances().spUtils.putString(MyApplication.zhibo, context);
                        }
                    }

                    @Override
                    public void failed(String error) {
                        if (MyApplication.getInstances().spUtils.getString(MyApplication.zhibo) != null) {
                            Log.e("SPX", "从SP获取数据");
                            Toast.makeText(getActivity(), "好可怜，没有网络连接了", Toast.LENGTH_SHORT).show();
                            processData(MyApplication.getInstances().spUtils.getString(MyApplication.zhibo));
                        }
                    }
                });
            }
        });
    }


    private void processData(String context) {
        if (getActivity() == null) {
            return;
        }

        zhiboBean = JSON.parseObject(context, ZhiboBean.class);
        if (zhiboBean == null) {
            return;
        }
        adapter.setData(zhiboBean);
        adapter.notifyDataSetChanged();

        initBanner(zhiboBean);
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
                int i = position;

                if (position != 0) {
                    i = position % zhiboBean.getData().getBanner().size();
                }
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("title", zhiboBean.getData().getBanner().get(i).getRemark());
                intent.putExtra("url", zhiboBean.getData().getBanner().get(i).getLink());
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick({R.id.tv_guanzhu_zhibo, R.id.tv_zhongxin_zhibo, R.id.tv_sousuo_zhibo, R.id.tv_fenlei_zhibo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_guanzhu_zhibo:
                Toast.makeText(getContext(), "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_zhongxin_zhibo:
                Toast.makeText(getContext(), "中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_sousuo_zhibo:
                Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_fenlei_zhibo:
                Toast.makeText(getContext(), "分类", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }
}
