package nataya.pilipili.fragment;

import android.util.Log;
import android.view.View;

import nataya.pilipili.R;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;

/**
 * Created by 191624 on 2017/3/21.
 */

public class TuijianFragment extends BaseFragment {


    @Override
    public View initView() {
        return View.inflate(getContext(),R.layout.fragment_tuijian,null);
    }

    @Override
    public void initData() {
        super.initData();

        LoadFromNet.getFromNet(AppNetConfig.BASE_TUIJIAN, new LoadNet() {
            @Override
            public void success(String context) {
//                TuijianBean tuijianBean = JSON.parseObject(context,TuijianBean.class);
//                Log.e("TAG",tuijianBean.getData().get(0).getDesc());

            }

            @Override
            public void failed(String error) {
//                Log.e("TAG",error);
            }
        });

    }
}
