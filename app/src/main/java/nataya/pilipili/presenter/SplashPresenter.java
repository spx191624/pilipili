package nataya.pilipili.presenter;

import nataya.pilipili.model.IsLoginModel;
import nataya.pilipili.model.LoginListener;
import nataya.pilipili.view.IsLogin;

/**
 * Created by 191624 on 2017/4/1.
 */

public class SplashPresenter {

    private final IsLogin view;
    private final IsLoginModel isLoginModel;

    public SplashPresenter(IsLogin view) {
        this.view =view ;
        this.isLoginModel = new IsLoginModel();
    }
    public void getIsLogin(){
        isLoginModel.getIsLogin(new PListener());
    }

    public class PListener implements LoginListener{

        @Override
        public void isLogin() {
            view.Login();
        }

        @Override
        public void notLogin() {
            view.notLogin();
        }
    }


}
