package nataya.pilipili.fragment;

import android.view.View;

import butterknife.ButterKnife;
import nataya.pilipili.R;

/**
 * Created by 191624 on 2017/3/25.
 */

public class DownloadFragment extends BaseFragment {


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_download, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
