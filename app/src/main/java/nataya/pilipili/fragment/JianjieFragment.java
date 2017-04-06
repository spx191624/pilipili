package nataya.pilipili.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import cn.sharesdk.onekeyshare.OnekeyShare;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.view.BaseFragment;


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
    private PlayActivity playActivity;
    private String[] data;

    @Override
    public View initView() {
        playActivity = (PlayActivity) getActivity();
        View view = View.inflate(getContext(), R.layout.fragment_jianjie, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        data=playActivity.getData();
        setData();
    }

    private void setData() {

        tvTitleJianjie.setText(data[2]);
        tvDanmunumJianjie.setText(data[5]);
        tvPlaynumJianjie.setText(data[4]);
        tvDesJianjie.setText(data[3]);
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
                showShare();
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

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("这有一个好玩的视频，不来看看吗？");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://www.bilibili.com/");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(data[2]);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(data[0]);
//        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://www.bilibili.com/");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(data[3]);
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://www.bilibili.com/");

// 启动分享GUI
        oks.show(getActivity());
    }


}
