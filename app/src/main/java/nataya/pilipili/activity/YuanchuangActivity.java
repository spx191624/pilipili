package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.view.BaseFragment;
import nataya.pilipili.fragment.FanjuFragment;
import nataya.pilipili.fragment.QuanzhanFragment;
import nataya.pilipili.fragment.YuanchuangFragment;

public class YuanchuangActivity extends AppCompatActivity {
    @InjectView(R.id.iv_back_yuanchuang)
    ImageView ivBackYuanchuang;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager_yuanchuang)
    ViewPager viewPagerYuanchuang;
    @InjectView(R.id.iv_download_yuanchuang)
    ImageView ivDownloadYuanchuang;
    @InjectView(R.id.iv_search_yuanchuang)
    ImageView ivSearchYuanchuang;
    private String[] titles = new String[]{"原创", "全站", "番剧"};
    private List<BaseFragment> fragments;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuanchuang);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new YuanchuangFragment());
        fragments.add(new QuanzhanFragment());
        fragments.add(new FanjuFragment());
        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        viewPagerYuanchuang.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPagerYuanchuang);


    }

   

    @OnClick({R.id.iv_back_yuanchuang,R.id.iv_download_yuanchuang, R.id.iv_search_yuanchuang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_download_yuanchuang:
                Toast.makeText(this, "下载管理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_search_yuanchuang:
                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.iv_back_yuanchuang:
                finish();
                break;
            
        }
    }
}
