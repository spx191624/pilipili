package nataya.pilipili.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.view.BaseFragment;
import nataya.pilipili.fragment.ZongheFragment;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.ThreadPool;

public class SearchShowActivity extends AppCompatActivity {

    @InjectView(R.id.back_search)
    ImageView backSearch;
    @InjectView(R.id.erweima_search)
    ImageView erweimaSearch;
    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.search_search)
    ImageView searchSearch;
    @InjectView(R.id.vp_search)
    ViewPager vpSearch;
    @InjectView(R.id.activity_search_show)
    LinearLayout activitySearchShow;

    private String[] titles = new String[]{"综合"};
    private List<BaseFragment> fragments;
    private MyViewPagerAdapter adapter;
    private ZongheFragment zongheFragment;


    private String key;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_show);
        ButterKnife.inject(this);
        key = getIntent().getStringExtra("key");
        initData();
        LoadData();
        etSearch.setText(key);
    }

    private void LoadData() {
        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {

                LoadFromNet.getFromNet(AppNetConfig.SEARCH_LEFT + key + AppNetConfig.SEARCH_RIGHT, new LoadNet() {
                    @Override
                    public void success(String context) {
                        zongheFragment.adapter.setData(context);
                        zongheFragment.adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failed(String error) {

                    }
                });
            }
        });

    }

    private void initData() {
        fragments = new ArrayList<>();
        zongheFragment = new ZongheFragment();
        fragments.add(zongheFragment);
        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        vpSearch.setAdapter(adapter);
    }

    @OnClick({R.id.back_search, R.id.erweima_search, R.id.search_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_search:
                finish();
                break;
            case R.id.erweima_search:
                break;
            case R.id.search_search:
                key = etSearch.getText().toString();
                LoadData();
                break;
        }
    }
}
