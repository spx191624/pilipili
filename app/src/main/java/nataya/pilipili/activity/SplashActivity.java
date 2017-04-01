package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;

import nataya.pilipili.R;
import nataya.pilipili.utils.MyApplication;

public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runnable = new Runnable() {
            @Override
            public void run() {
                if (MyApplication.getInstances().spUtils.getBoolean(MyApplication.isLogin)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        handler.postDelayed(runnable, 2000);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SPX","移除消息");
        handler.removeCallbacks(runnable);
    }
}
