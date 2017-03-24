package nataya.pilipili.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import nataya.pilipili.utils.UIUtils;
import nataya.pilipili.view.MyScrollView;

/**
 * Created by 191624 on 2017/3/21.
 */

public class FaxianFragment extends BaseFragment {


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
    @InjectView(R.id.scrollview_faxian)
    MyScrollView scrollviewFaxian;
    @InjectView(R.id.line_more)
    LinearLayout lineMore;

    private Boolean isShowAll = false;
    private TagBean tagBean;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_faxian, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initNet();
        initListener();
        showTag(isShowAll);
    }

    private void initListener() {
        lineMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowAll = !isShowAll;
                showTag(isShowAll);


            }
        });
        scrollviewFaxian.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (isShowAll) {
                    return false;
                }
                return true;
            }
        });

        flowFaxian.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getContext(),tagBean.getData().getList().get(position).getKeyword(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    private void showTag(Boolean isShowAll) {


        ViewGroup.LayoutParams params = scrollviewFaxian.getLayoutParams();
        TextView tv = (TextView) lineMore.findViewById(R.id.tv_line_more);
        if (isShowAll) {
            tv.setText("收起");

            params.height = UIUtils.dip2px(getContext(), 360);
        } else {
            tv.setText("查看更多");
            params.height = UIUtils.dip2px(getContext(), 180);
        }
        scrollviewFaxian.setLayoutParams(params);
        //动态改变textview drawable图片
     /*   Drawable nav_up=getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tv.setCompoundDrawables(null, null, nav_up, null);*/


    }

    private void initNet() {
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
        tagBean = JSON.parseObject(context, TagBean.class);
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < tagBean.getData().getList().size(); i++) {
            tags.add(tagBean.getData().getList().get(i).getKeyword());
        }


        flowFaxian.setAdapter(new TagAdapter(tags) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tv = (TextView) getLayoutInflater(null).inflate(R.layout.tv, flowFaxian, false);
                tv.setText((String) o);
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
