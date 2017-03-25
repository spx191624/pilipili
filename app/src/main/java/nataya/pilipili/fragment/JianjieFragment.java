package nataya.pilipili.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import nataya.pilipili.R;
import nataya.pilipili.bean.TuijianBean;

/**
 * Created by 191624 on 2017/3/25.
 */

public class JianjieFragment extends BaseFragment {


    @InjectView(R.id.tv_title_jianjie)
    TextView tvTitleJianjie;
    @InjectView(R.id.tv_playnum_jianjie)
    TextView tvPlaynumJianjie;
    @InjectView(R.id.tv_danmunum_jianjie)
    TextView tvDanmunumJianjie;
    @InjectView(R.id.tv_des_jianjie)
    TextView tvDesJianjie;
    @InjectView(R.id.num_fenxiang)
    TextView numFenxiang;
    @InjectView(R.id.fenxiang)
    LinearLayout fenxiang;
    @InjectView(R.id.num_yingbi)
    TextView numYingbi;
    @InjectView(R.id.yingbi)
    LinearLayout yingbi;
    @InjectView(R.id.num_shoucang)
    TextView numShoucang;
    @InjectView(R.id.shoucang)
    LinearLayout shoucang;
    @InjectView(R.id.xiazai)
    LinearLayout xiazai;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_jianjie, null);
        ButterKnife.inject(this, view);
        setData();
        return view;
    }

    @Override
    public void initData() {
        super.initData();

    }

    private void setData() {

        tvTitleJianjie.setText("不知道是什么标题");
        tvDanmunumJianjie.setText("" + (int) (Math.random() * 10000));
        tvPlaynumJianjie.setText("" + (int) (Math.random() * 10000));
        tvDesJianjie.setText("不知道是什么数据\n我能怎么办\n我也很绝望啊");
        //得不到数据  我也很绝望啊
        numFenxiang.setText("" + (int) (Math.random() * 10000));
        numShoucang.setText("" + (int) (Math.random() * 10000));
        numYingbi.setText("" + (int) (Math.random() * 10000));

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }




    @OnClick({R.id.fenxiang, R.id.yingbi, R.id.shoucang, R.id.xiazai})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fenxiang:
                Toast.makeText(getContext(), "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yingbi:
                Toast.makeText(getContext(), "硬币", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shoucang:
                Toast.makeText(getContext(), "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiazai:
                Toast.makeText(getContext(), "下载", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
