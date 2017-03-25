package nataya.pilipili.fragment;

import android.content.Intent;
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

        return view;
    }


    @Override
    public void initData() {
        super.initData();

        LoadFromNet.getFromNet(AppNetConfig.BASE_ZHIBO, new LoadNet() {
            @Override
            public void success(String context) {
                if (context != null) {
                    processData(context);
                }
            }

            @Override
            public void failed(String error) {

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
                intent.putExtra("title",zhiboBean.getData().getBanner().get(i).getRemark());
                intent.putExtra("url",zhiboBean.getData().getBanner().get(i).getLink());
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
}
