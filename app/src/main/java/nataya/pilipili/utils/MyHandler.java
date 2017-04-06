package nataya.pilipili.utils;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import nataya.pilipili.view.SplashActivity;

/**
 * Created by 191624 on 2017/3/31.
 */

public class MyHandler extends Handler {
    private final WeakReference<SplashActivity> mActivity;

    public MyHandler(SplashActivity activity) {
        mActivity = new WeakReference<SplashActivity>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        SplashActivity activity = mActivity.get();
        if (activity != null) {
            // ...
        }
    }
}
