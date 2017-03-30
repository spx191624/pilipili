package nataya.pilipili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.greendao.gen.UserDao;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.bean.User;
import nataya.pilipili.utils.MyApplication;
import nataya.pilipili.utils.ThreadPool;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.forget_pwd)
    TextView forgetPwd;
    @InjectView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @InjectView(R.id.ic22)
    ImageView ic22;
    @InjectView(R.id.ic33)
    ImageView ic33;
    @InjectView(R.id.username)
    EditText username;
    @InjectView(R.id.pwd)
    EditText pwd;
    @InjectView(R.id.zhuce)
    TextView zhuce;
    @InjectView(R.id.login)
    TextView login;
    @InjectView(R.id.activity_login)
    LinearLayout activityLogin;
    @InjectView(R.id.qqlogin)
    TextView qqlogin;
    private UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                    ic22.setImageResource(R.drawable.ic_22);
                    ic33.setImageResource(R.drawable.ic_33);
                } else {
                    // 此处为失去焦点时的处理内容
                    ic22.setImageResource(R.drawable.ic_22_hide);
                    ic33.setImageResource(R.drawable.ic_33_hide);
                }
            }
        });

        dao = MyApplication.getInstances().getDaoSession().getUserDao();


    }

    @OnClick({R.id.iv_back, R.id.forget_pwd, R.id.zhuce, R.id.login, R.id.qqlogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.forget_pwd:
                Toast.makeText(this, "密码忘记了哦", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhuce:

                String user = username.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                if (user == null || user.length() == 0) {
                    Toast.makeText(this, "你没有告诉我你的名字哦", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass == null || pass.length() == 0) {
                    Toast.makeText(this, "你还没有想好密码吗？", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<User> list1 = MyApplication.getInstances().getDaoSession().getUserDao().loadAll();
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getUsername().toString().equals(user)) {
                        Toast.makeText(this, "用户名已存在", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                User newuser = new User(user, pass);
                dao.save(newuser);
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login:
                String user1 = username.getText().toString().trim();
                String pass1 = pwd.getText().toString().trim();
                if (user1 == null || user1.length() == 0) {
                    Toast.makeText(this, "你没有告诉我你的名字哦", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass1 == null || pass1.length() == 0) {
                    Toast.makeText(this, "你还没有想好密码吗？", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<User> list = dao.loadAll();
                for (int i = 0; i < list.size(); i++) {
                    if (user1.equals(list.get(i).getUsername())) {
                        if (pass1.equals(list.get(i).getPwd())) {
                            startActivity(new Intent(this, MainActivity.class));
                            MyApplication.getInstances().spUtils.putBoolean(MyApplication.isLogin, true);
                            MyApplication.getInstances().spUtils.putString(MyApplication.USERNAME, user1);
                            return;
                        }
                    }
                }
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qqlogin:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);
                mShareAPI.doOauthVerify(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);


                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);


    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, final Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
                @Override
                public void run() {
                    MyApplication.getInstances().spUtils.putBoolean(MyApplication.isqq, true);
                    MyApplication.getInstances().spUtils.putBoolean(MyApplication.isLogin, true);
                    MyApplication.getInstances().spUtils.putString(MyApplication.USERNAME, "QQ游客");
                }
            });
            finish();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


}
