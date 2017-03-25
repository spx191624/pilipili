package nataya.pilipili.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.adapter.YuanchuangAdapter;
import nataya.pilipili.bean.YuanchuangBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.view.MyListView;

/**
 * Created by 191624 on 2017/3/24.
 */

public class Q4Fragment extends BaseFragment {


    @InjectView(R.id.lv_yuanchuang)
    MyListView lvYuanchuang;
    private YuanchuangBean yuanchuangBean;
    private YuanchuangAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_yuanchuang, null);
        ButterKnife.inject(this, view);
        adapter = new YuanchuangAdapter(getActivity());
        lvYuanchuang.setAdapter(adapter);
        initListener();
        return view;
    }

    private void initListener() {
        lvYuanchuang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), yuanchuangBean.getData().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();

        LoadFromNet.getFromNet(AppNetConfig.Q_WUDAO, new LoadNet() {
            @Override
            public void success(String context) {
                if (context != null) {
                    yuanchuangBean = JSON.parseObject(context, YuanchuangBean.class);
                    if (yuanchuangBean==null){
                        return;
                    }
                    processData(yuanchuangBean);
                }
            }

            @Override
            public void failed(String error) {

            }
        });

    }

    private void processData(YuanchuangBean yuanchuangBean) {
        if (getActivity()==null ){
            return;
        }
       adapter.setData(yuanchuangBean);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}
