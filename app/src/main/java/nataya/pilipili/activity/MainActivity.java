package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.fragment.BaseFragment;
import nataya.pilipili.fragment.FaxianFragment;
import nataya.pilipili.fragment.FenquFragment;
import nataya.pilipili.fragment.TuijianFragment;
import nataya.pilipili.fragment.ZhiboFragment;
import nataya.pilipili.fragment.ZhuifanFragment;
import nataya.pilipili.utils.MyApplication;


public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.iv_tool)
    ImageView ivTool;
    @InjectView(R.id.iv_tool2)
    ImageView ivTool2;
    @InjectView(R.id.iv_tool_sousuo)
    ImageView ivToolSousuo;
    @InjectView(R.id.iv_tool_xiazai)
    ImageView ivToolXiazai;
    @InjectView(R.id.iv_tool_youxi)
    ImageView ivToolYouxi;
    @InjectView(R.id.navigation_layout)
    RelativeLayout navigationLayout;
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
    @InjectView(R.id.username_main)
    TextView usernameMain;

    private String[] titles = new String[]{"直播", "推荐", "追番", "分区", "发现"};
    private List<BaseFragment> fragments;
    private MyViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        if (MyApplication.getInstances().spUtils.getBoolean(MyApplication.isqq)){
            ivTool2.setImageResource(R.drawable.ic_share_qq);
        }
        ivTool2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.getInstances().spUtils.putBoolean(MyApplication.isLogin,false);
                finish();
            }
        });
        initData();
    }

    private void initData() {
        usernameMain.setText(MyApplication.getInstances().spUtils.getString(MyApplication.USERNAME));
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


    @OnClick({R.id.iv_tool_sousuo, R.id.iv_tool_xiazai, R.id.iv_tool_youxi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tool_sousuo:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
            case R.id.iv_tool_xiazai:
                startActivity(new Intent(MainActivity.this, DownloadActivity.class));
                break;
            case R.id.iv_tool_youxi:
                Toast.makeText(this, "游戏管理", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
