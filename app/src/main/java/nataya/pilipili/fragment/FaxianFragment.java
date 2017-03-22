package nataya.pilipili.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.bean.TagBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;

/**
 * Created by 191624 on 2017/3/21.
 */

public class FaxianFragment extends BaseFragment {


    @InjectView(R.id.line_more)
    LinearLayout lineMore;
    @InjectView(R.id.xingququan_faxian)
    TextView xingququanFaxian;
    @InjectView(R.id.huati_faxian)
    TextView huatiFaxian;
    @InjectView(R.id.huodong_faxian)
    TextView huodongFaxian;
    @InjectView(R.id.xiaoheiwu_faxian)
    TextView xiaoheiwuFaxian;
    @InjectView(R.id.yuanchuang_faxian)
    TextView yuanchuangFaxian;
    @InjectView(R.id.quanqu_faxian)
    TextView quanquFaxian;
    @InjectView(R.id.youxizhongxin_faxian)
    TextView youxizhongxinFaxian;
    @InjectView(R.id.zhoubian_faxian)
    TextView zhoubianFaxian;
    @InjectView(R.id.flow_faxian)
    TagFlowLayout flowFaxian;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_faxian, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LoadFromNet.getFromNet(AppNetConfig.TAG_URL, new LoadNet() {
            @Override
            public void success(String context) {
                processData(context);
            }

            @Override
            public void failed(String error) {

            }
        });
    }

    private void processData(String context) {
        TagBean tagBean = JSON.parseObject(context, TagBean.class);
        List<String> tags = new ArrayList<>();
        for (int i = 0; i <tagBean.getData().getList().size() ; i++) {
            tags.add(tagBean.getData().getList().get(i).getKeyword());
        }
//        Log.e("TAG", "processData: "+tagBean.getData().getList().get(0).getKeyword().toString());
        flowFaxian.setAdapter(new TagAdapter(tags) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tv = (TextView) getLayoutInflater(null).inflate(R.layout.tv,flowFaxian,false);
                tv.setText((String)o);
                return tv;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
