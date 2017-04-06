package nataya.pilipili.model;

import nataya.pilipili.presenter.GetDataPresenter;
import nataya.pilipili.utils.RxUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by 191624 on 2017/4/6.
 */

public class GetDataModel {
    private RxUtils rxUtils = new RxUtils();
    public void getData(String url, final GetDataPresenter.DataListenerImp listener){
        rxUtils.getData(url).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                listener.data(s);
            }
        });
    }
}
