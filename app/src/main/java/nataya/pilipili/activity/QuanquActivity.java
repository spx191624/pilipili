package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.view.BaseFragment;
import nataya.pilipili.fragment.Q1Fragment;
import nataya.pilipili.fragment.Q2Fragment;
import nataya.pilipili.fragment.Q3Fragment;
import nataya.pilipili.fragment.Q4Fragment;
import nataya.pilipili.fragment.Q5Fragment;
import nataya.pilipili.fragment.Q6Fragment;

public class QuanquActivity extends AppCompatActivity {
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
    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.tv_name)
    TextView tvName;

    private String[] titles = new String[]{"番剧", "动画", "音乐", "舞蹈", "游戏", "国创", "科技",
            "生活", "鬼畜", "时尚", "娱乐", "电影", "电视剧"};
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
        fragments.add(new Q1Fragment());
        fragments.add(new Q2Fragment());
        fragments.add(new Q3Fragment());
        fragments.add(new Q4Fragment());
        fragments.add(new Q5Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        fragments.add(new Q6Fragment());
        tv.setVisibility(View.GONE);
        tvName.setText("全区排行榜");
        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        viewPagerYuanchuang.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPagerYuanchuang);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }


    @OnClick({R.id.iv_back_yuanchuang, R.id.iv_download_yuanchuang, R.id.iv_search_yuanchuang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_download_yuanchuang:
                Toast.makeText(this, "下载管理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_search_yuanchuang:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.iv_back_yuanchuang:
                finish();
                break;

        }
    }
}
