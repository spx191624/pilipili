package nataya.pilipili.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.fragment.BaseFragment;
import nataya.pilipili.fragment.DownloadFragment;
import nataya.pilipili.fragment.HuancunFragment;

public class DownloadActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back_download)
    ImageView ivBackDownload;
    @InjectView(R.id.ic_download_edit)
    ImageView icDownloadEdit;
    @InjectView(R.id.ic_download_setting)
    ImageView icDownloadSetting;
    @InjectView(R.id.iv_search_yuanchuang)
    ImageView ivSearchYuanchuang;
    @InjectView(R.id.view_pager_download)
    ViewPager viewPagerDownload;
    @InjectView(R.id.tablayout_download)
    TabLayout tablayoutDownload;
    private String[] titles = new String[]{"           已缓存           ", "           缓存中           "};
    private List<BaseFragment> fragments;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.inject(this);

        initData();
    }


    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new HuancunFragment());
        fragments.add(new DownloadFragment());

        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        viewPagerDownload.setAdapter(adapter);
        tablayoutDownload.setupWithViewPager(viewPagerDownload);



    }

    @OnClick({R.id.iv_back_download, R.id.ic_download_edit, R.id.ic_download_setting, R.id.iv_search_yuanchuang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_download:
                break;
            case R.id.ic_download_edit:
                break;
            case R.id.ic_download_setting:
                break;
            case R.id.iv_search_yuanchuang:
                break;
        }
    }
}
