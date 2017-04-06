package nataya.pilipili.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import nataya.pilipili.R;
import nataya.pilipili.activity.LoginActivity;
import nataya.pilipili.presenter.SplashPresenter;


public class SplashActivity extends AppCompatActivity implements IsLogin{
    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter = new SplashPresenter(SplashActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashPresenter.getIsLogin();
            }
        },2000);

    }




    @Override
    public void Login() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void notLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
