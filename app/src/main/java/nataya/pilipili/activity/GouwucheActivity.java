package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
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
import nataya.pilipili.adapter.ShopAdapter;
import nataya.pilipili.bean.GoodBean;
import nataya.pilipili.bean.ShopBannerBean;
import nataya.pilipili.bean.ShopBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.GlideImageLoder;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;

public class GouwucheActivity extends AppCompatActivity {

    @InjectView(R.id.banner)
    Banner banner;
    @InjectView(R.id.rg)
    RadioGroup rg;
    @InjectView(R.id.gv_shop)
    GridView gvShop;
    @InjectView(R.id.iv_back_huodong)
    ImageView ivBackHuodong;
    @InjectView(R.id.iv_more_web)
    ImageView ivMoreWeb;
    private ShopAdapter adapter;
    private ShopBean shopBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gouwuche);
        ButterKnife.inject(this);
        rg.check(R.id.quanbu);
        initData();
        adapter = new ShopAdapter(this);
        gvShop.setAdapter(adapter);
        gvShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(GouwucheActivity.this,GWCActivity.class);
                GoodBean good = new GoodBean(1,shopBean.getResult().getRecords().get(position).getSalvePrice(),shopBean.getResult().getRecords().get(position).getTitle());
                Bundle bundle =new Bundle();
                bundle.putSerializable("good",good);
                intent.putExtra("good",bundle);
                startActivity(intent);
            }
        });
    }

    private void initBanner(final ShopBannerBean bean) {
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < bean.getResult().getModelDetails().size(); i++) {
            urls.add(bean.getResult().getModelDetails().get(i).getSmallImageUrl());
        }

        banner.setImageLoader(new GlideImageLoder());
        banner.setImages(urls);
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        banner.isAutoPlay(false);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                int i = position;

                if (position != 0) {
                    i = position % bean.getResult().getModelDetails().size();
                }
                Intent intent = new Intent(GouwucheActivity.this, WebActivity.class);
                intent.putExtra("title", bean.getResult().getModelDetails().get(position).getBigTitle());
                intent.putExtra("url", bean.getResult().getModelDetails().get(position).getImgLink());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        LoadFromNet.getFromNet(AppNetConfig.SHOP_BANNER, new LoadNet() {
            @Override
            public void success(String context) {
                ShopBannerBean bean = JSON.parseObject(context, ShopBannerBean.class);
                initBanner(bean);
            }

            @Override
            public void failed(String error) {

            }
        });
        LoadFromNet.getFromNet(AppNetConfig.SHOP, new LoadNet() {
            @Override
            public void success(String context) {
                shopBean = JSON.parseObject(context, ShopBean.class);
                processData(shopBean);

            }

            @Override
            public void failed(String error) {

            }
        });
    }

    private void processData(ShopBean shopBean) {
        if (shopBean != null) {
            adapter.setData(shopBean);
            adapter.notifyDataSetChanged();

        }
    }

    @OnClick({R.id.iv_back_huodong, R.id.iv_more_web})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_huodong:
                finish();
                break;
            case R.id.iv_more_web:
                Toast.makeText(this, "more", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
