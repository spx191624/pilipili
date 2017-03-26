package nataya.pilipili.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import nataya.pilipili.R;
import nataya.pilipili.adapter.MyViewPagerAdapter;
import nataya.pilipili.bean.TuijianBean;
import nataya.pilipili.fragment.BaseFragment;
import nataya.pilipili.fragment.JianjieFragment;
import nataya.pilipili.fragment.Q6Fragment;


public class PlayActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @InjectView(R.id.tv_play)
    TextView tvPlay;
    @InjectView(R.id.iv_back_play)
    ImageView ivBackPlay;
    @InjectView(R.id.tv_avid_play)
    TextView tvAvidPlay;
    @InjectView(R.id.iv_more)
    ImageView ivMore;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.vp_play)
    ViewPager vpPlay;
    @InjectView(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;
    @InjectView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @InjectView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @InjectView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    private String[] titles = new String[]{"直播", "推荐"};
    private List<BaseFragment> fragments = new ArrayList<>();
    private MyViewPagerAdapter adapter;
    private JCVideoPlayer videoController;
    private JianjieFragment jianjie;


    public int position = 0;
    public TuijianBean tuijianBean=null;
    public String[] data;
    public String[] getData(){
        return data;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.inject(this);
        initUniversalImageLoader();

        initData();
    }
    private void initUniversalImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(new ColorDrawable(Color.parseColor("#f0f0f0")))
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
//                .displayer(new FadeInBitmapDisplayer(1000)) // 设置图片渐显的时间
                .delayBeforeLoading(300)  // 下载前的延迟时间
                .build();

        int memClass = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        // Use 1/8th of the available memory for this memory cache.
        int memCacheSize = 1024 * 1024 * memClass / 8;

        File cacheDir = new File(Environment.getExternalStorageDirectory().getPath() + "/jiecao/cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3) // default  线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2) // default 设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(new UsingFreqLimitedMemoryCache(memCacheSize)) // You can pass your own memory cache implementation/
                .memoryCacheSize(memCacheSize) // 内存缓存的最大值
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .defaultDisplayImageOptions(options)
//                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
    private void initData() {
        passData();
        initViewPager();
        initVideo();
    }

    private void passData() {

        position = getIntent().getIntExtra("position",0);
        Log.e("TAG","position =="+position);
        tuijianBean= (TuijianBean) getIntent().getSerializableExtra("bean");
        jianjie = new JianjieFragment();
        fragments.add(jianjie);
        fragments.add(new Q6Fragment());

    }

    private void initVideo() {
        data = getIntent().getStringArrayExtra("data");
        String cover = data[0];
//        String url = data[1];
        String trueUrl = "http://vfx.mtime.cn/Video/2017/03/15/mp4/170315222409670447.mp4";
        String title = data[2];
        String des = data[3];
        videoController = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        videoController.setUp(trueUrl,cover,title);
    }

    private void initViewPager() {
        adapter = new MyViewPagerAdapter(this.getSupportFragmentManager(), fragments, titles);
        vpPlay.setAdapter(adapter);
        tablayout.setupWithViewPager(vpPlay);
    }





    @OnClick({ R.id.tv_play, R.id.iv_back_play, R.id.iv_more})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_play:
                Toast.makeText(this, "tv_play", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_back_play:
                finish();
                break;
            case R.id.iv_more:
                Toast.makeText(this, "iv_more", Toast.LENGTH_SHORT).show();
                break;
        }
    }



    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset>-255){
            tvPlay.setVisibility(View.INVISIBLE);

        }
        else{
            tvPlay.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appBarLayout.removeOnOffsetChangedListener(this);
    }



}
