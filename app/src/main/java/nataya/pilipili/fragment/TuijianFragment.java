package nataya.pilipili.fragment;


import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.alibaba.fastjson.JSON;
import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.adapter.TuijianAdapter;
import nataya.pilipili.bean.TuijianBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;

/**
 * Created by 191624 on 2017/3/21.
 */

public class TuijianFragment extends BaseFragment {


    @InjectView(R.id.gv_tuijian)
    GridView gvTuijian;
    @InjectView(R.id.tablayout_tuijian)
    TabLayout tablayoutTuijian;
    private TuijianAdapter adapter;
    private TuijianBean tuijianBean;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_tuijian, null);
        ButterKnife.inject(this, view);
        initListener();

        return view;
    }



    private void initListener() {
        gvTuijian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cover = tuijianBean.getData().get(position).getCover();
                String url = "www.bilibili.com/video/av"+tuijianBean.getData().get(position).getParam()+"/";
                String title = tuijianBean.getData().get(position).getTitle();
                String[] data = new String[]{cover,url,title};
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra("data",data);

                startActivity(intent);

            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        tablayoutTuijian.addTab(tablayoutTuijian.newTab().setText("综合"));
        tablayoutTuijian.addTab(tablayoutTuijian.newTab().setText("动态"));
        LoadFromNet.getFromNet(AppNetConfig.BASE_TUIJIAN, new LoadNet() {
            @Override
            public void success(String context) {
                tuijianBean= JSON.parseObject(context, TuijianBean.class);
                processData(tuijianBean);


            }

            @Override
            public void failed(String error) {
                Log.e("TAG", error);
            }
        });



    }

    private void processData(TuijianBean tuijianBean) {
        if (getActivity()==null ){
            return;
        }
        adapter = new TuijianAdapter(getContext(), tuijianBean);
        gvTuijian.setAdapter(adapter);
        setListViewHeightBasedOnChildren(gvTuijian);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    public static void setListViewHeightBasedOnChildren(GridView listView) {
        // 获取listview的adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = 4;// listView.getNumColumns();
        int totalHeight = 0;
        // i每次加4，相当于listAdapter.getCount()小于等于4时 循环一次，计算一次item的高度，
        // listAdapter.getCount()小于等于8时计算两次高度相加
        for (int i = 0; i < listAdapter.getCount(); i += col) {
            // 获取listview的每一个item
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            // 获取item的高度和
            totalHeight += listItem.getMeasuredHeight();
        }

        // 获取listview的布局参数
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 设置高度
        params.height = totalHeight;
        // 设置margin
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        // 设置参数
        listView.setLayoutParams(params);
    }



}
