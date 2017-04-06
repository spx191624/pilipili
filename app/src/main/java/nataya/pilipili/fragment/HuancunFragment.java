package nataya.pilipili.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.utils.StorageUtil;
import nataya.pilipili.utils.MyListView;
import nataya.pilipili.view.BaseFragment;

/**
 * Created by 191624 on 2017/3/25.
 */

public class HuancunFragment extends BaseFragment {
    private boolean isSD = false;

    @InjectView(R.id.iv_none)
    ImageView ivNone;
    @InjectView(R.id.lv_huancun)
    MyListView lvHuancun;
    @InjectView(R.id.tv_neicunkongjian)
    TextView tvNeicunkongjian;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_huancun, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //是否挂载SD卡
//        isSD = StorageUtil.isSDCardAvailable();
        if (isSD) {
            tvNeicunkongjian.setText("主存储："+StorageUtil.getSDTotalSizeFormat()+"/可用："+StorageUtil.getSDAvailableSizeFormat());
        }else{
            tvNeicunkongjian.setText("主存储："+StorageUtil.getRamTotalSizeFormat(getContext())+"/可用："+StorageUtil.getRamAvailableSizeFormat(getContext()));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
