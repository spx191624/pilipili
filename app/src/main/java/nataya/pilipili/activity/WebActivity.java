package nataya.pilipili.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;

public class WebActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back_huodong)
    ImageView ivBackHuodong;
    @InjectView(R.id.tv_title_web)
    TextView tvTitleWeb;
    @InjectView(R.id.iv_more_web)
    ImageView ivMoreWeb;
    @InjectView(R.id.webview)
    WebView webview;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        String title = getIntent().getStringExtra("title");
        tvTitleWeb.setText(title);
        String url = getIntent().getStringExtra("url");
        //设置支持JavaScript
        settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
//        //设置双击变大变小
//        settings.setUseWideViewPort(true);
//        //增加缩放按钮
//        settings.setBuiltInZoomControls(true);
        //设置默认文本文字的大小
        settings.setTextZoom(100);//正常字体大小
        //让进度条不让从当前网页跳转到系统的浏览器中
        webview.setWebViewClient(new WebViewClient() {
            @Override
            //结束后
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //进度条消失
//                pb_news_detail.setVisibility(View.GONE);
            }
        });
        webview.loadUrl(url);//用WebView去加载数据
    }

    @OnClick({R.id.iv_back_huodong, R.id.iv_more_web})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_huodong:
                finish();
                break;
            case R.id.iv_more_web:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
