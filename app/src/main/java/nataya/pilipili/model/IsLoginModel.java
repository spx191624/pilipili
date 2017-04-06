package nataya.pilipili.model;

import nataya.pilipili.presenter.SplashPresenter;
import nataya.pilipili.utils.MyApplication;

/**
 * Created by 191624 on 2017/4/1.
 */

public class IsLoginModel {


    public boolean getIsLogin(SplashPresenter.PListener listener) {
        boolean flag = MyApplication.getInstances().spUtils.getBoolean(MyApplication.isLogin);
        if (flag){
            listener.isLogin();
        }else{
            listener.notLogin();
        }
        return flag;
    }
}
