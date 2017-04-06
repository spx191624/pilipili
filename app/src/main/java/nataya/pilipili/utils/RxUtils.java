package nataya.pilipili.utils;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by 191624 on 2017/4/2.
 */

public class RxUtils {
    OkHttpClient client;

    public RxUtils() {
        client = new OkHttpClient();
    }

    public Observable<String> getData(final String path, final Map<String, String> params) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                FormBody.Builder form = new FormBody.Builder();
                if (params != null && params.size() > 0) {
                    for (Map.Entry<String, String> map : params.entrySet()) {
                        form.add(map.getKey(), map.getValue());
                    }
                }
                RequestBody requestBody = form.build();
                Request request = new Request.Builder().url(path).post(requestBody).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure" + e.getMessage());
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("TAG", "onResponse");
                        if (response.isSuccessful()) {
                            subscriber.onNext(response.body().string());
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        }).subscribeOn(Schedulers.newThread());
    }

    public Observable<byte[]> getBmp(final String path) {
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
                final Request request = new Request.Builder().url(path).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure" + e.getMessage());
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("TAG", "onResponse");
                        byte[] data = response.body().bytes();
                        if (data != null) {
                            subscriber.onNext(data);
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        }).subscribeOn(Schedulers.newThread());
    }

    public Observable<String> getData(final String url){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                LoadFromNet.getFromNet(url, new LoadNet() {
                    @Override
                    public void success(String context) {
                        if (context != null) {
                            MyApplication.getInstances().spUtils.putString(MyApplication.zhibo, context);
                            if (!subscriber.isUnsubscribed()){
                                if (context!=null){
                                    subscriber.onNext(context);
                                }
                            }
                            subscriber.onCompleted();
                        }
                    }

                    @Override
                    public void failed(String error) {
                        if (MyApplication.getInstances().spUtils.getString(MyApplication.zhibo) != null) {
                            subscriber.onCompleted();
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
