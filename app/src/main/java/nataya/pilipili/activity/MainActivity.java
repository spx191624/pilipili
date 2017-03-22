package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.fragment.BaseFragment;
import nataya.pilipili.fragment.FaxianFragment;
import nataya.pilipili.fragment.FenquFragment;
import nataya.pilipili.fragment.TuijianFragment;
import nataya.pilipili.fragment.ZhiboFragment;
import nataya.pilipili.fragment.ZhuifanFragment;


public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    @InjectView(R.id.navigation_view)
    NavigationView navigationView;
    @InjectView(R.id.id_drawer_layout)
    DrawerLayout idDrawerLayout;
    @InjectView(R.id.iv_tool_sousuo)
    ImageView ivToolSousuo;
    @InjectView(R.id.iv_tool_xiazai)
    ImageView ivToolXiazai;
    @InjectView(R.id.iv_tool_youxi)
    ImageView ivToolYouxi;
    private String[] titles = new String[]{"直播", "推荐", "追番", "分区", "发现"};
    private List<BaseFragment> fragments;
    private MyViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initData();
        initListener();
    }

    private void initListener() {
        ivToolSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiboFragment());
        fragments.add(new TuijianFragment());
        fragments.add(new ZhuifanFragment());
        fragments.add(new FenquFragment());
        fragments.add(new FaxianFragment());
        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);






    }


}
