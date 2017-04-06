package nataya.pilipili.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.adapter.YuanchuangAdapter;
import nataya.pilipili.bean.YuanchuangBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.NumUtils;
import nataya.pilipili.utils.ThreadPool;
import nataya.pilipili.utils.MyListView;
import nataya.pilipili.view.BaseFragment;

/**
 * Created by 191624 on 2017/3/24.
 */

public class YuanchuangFragment extends BaseFragment {


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
                String cover = yuanchuangBean.getData().get(position).getCover();
                String url = "www.bilibili.com/video/av"+yuanchuangBean.getData().get(position).getParam()+"/";
                String title = yuanchuangBean.getData().get(position).getTitle();
                String des = "";
                String play = NumUtils.getNum(yuanchuangBean.getData().get(position).getPlay());
                String danmu =NumUtils.getNum(yuanchuangBean.getData().get(position).getDanmaku());

                String[] data = new String[]{cover,url,title,des,play,danmu};
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra("data",data);




                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                LoadFromNet.getFromNet(AppNetConfig.YUANCHUANG, new LoadNet() {
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
