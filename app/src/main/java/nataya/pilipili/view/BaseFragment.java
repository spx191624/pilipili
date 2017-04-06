package nataya.pilipili.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import nataya.pilipili.presenter.GetDataPresenter;

/**
 * Created by 191624 on 2017/3/21.
 */

public abstract class BaseFragment extends Fragment {


    public abstract View initView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

    }

    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


}