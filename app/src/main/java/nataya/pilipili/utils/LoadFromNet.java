package nataya.pilipili.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 191624 on 2017/3/21.
 */

public class LoadFromNet {
    public static void getFromNet(String url, final LoadNet loadNet){

        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                if (loadNet!=null){
                    loadNet.failed(e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, String s) {
                if (loadNet!=null){
                    loadNet.success(s);
                }
            }
        });
    }
}
