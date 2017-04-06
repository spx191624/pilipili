package nataya.pilipili.view;


import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.alibaba.fastjson.JSON;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.adapter.TuijianAdapter;
import nataya.pilipili.bean.TuijianBean;
import nataya.pilipili.presenter.GetDataPresenter;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.MyApplication;
import nataya.pilipili.utils.NumUtils;

/**
 * Created by 191624 on 2017/3/21.
 */

public class TuijianFragment extends BaseFragment implements IgetDataView{


    @InjectView(R.id.gv_tuijian)
    GridView gvTuijian;
    @InjectView(R.id.tablayout_tuijian)
    TabLayout tablayoutTuijian;
    @InjectView(R.id.refresh)
    MaterialRefreshLayout refresh;
    private TuijianAdapter adapter;
    private TuijianBean tuijianBean;
    private List datas;
    private boolean isDown;
    private GetDataPresenter getDataPresenter;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_tuijian, null);
        ButterKnife.inject(this, view);
        getDataPresenter = new GetDataPresenter(TuijianFragment.this);
        adapter = new TuijianAdapter(getContext());
        gvTuijian.setAdapter(adapter);
        initListener();
        tablayoutTuijian.addTab(tablayoutTuijian.newTab().setText("综合"));
        tablayoutTuijian.addTab(tablayoutTuijian.newTab().setText("动态"));
        datas = new ArrayList();
        refresh.setLoadMore(true);
        refresh.setWaveColor(Color.parseColor("#88FB7299"));
        refresh.setIsOverLay(true);
        refresh.setWaveShow(true);

        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                isDown = true;
                initData();
                refresh.finishRefresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                isDown = false;
                initData();
                refresh.finishRefreshLoadMore();
            }
        });
        if (MyApplication.getInstances().spUtils.getString(MyApplication.tuijian)!=null){
            processData(JSON.parseObject(MyApplication.getInstances().spUtils.getString(MyApplication.tuijian),TuijianBean.class));
        }
        return view;
    }


    private void initListener() {
        gvTuijian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cover = tuijianBean.getData().get(position).getCover();
                String url = "www.bilibili.com/video/av" + tuijianBean.getData().get(position).getParam() + "/";
                String title = tuijianBean.getData().get(position).getTitle();
                String des = tuijianBean.getData().get(position).getDesc();
                String play = NumUtils.getNum(tuijianBean.getData().get(position).getPlay());
                String danmu = NumUtils.getNum(tuijianBean.getData().get(position).getDanmaku());

                String[] data = new String[]{cover, url, title, des, play, danmu};
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra("data", data);


                startActivity(intent);

            }
        });
    }

    @Override
    public void initData() {
        super.initData();

        getDataPresenter.getdata(AppNetConfig.BASE_TUIJIAN);
    }

    private void processData(TuijianBean tuijianBean) {

        if (getActivity() == null) {
            return;
        }
        if (tuijianBean==null){
            return;
        }
        List temp = new ArrayList();
        temp = datas;
        datas = new ArrayList();
        if (isDown) {
            if (datas.size()>=60){
                for (int i = datas.size()-20; i < datas.size(); i++) {
                    datas.remove(i);
                }
            }
            datas.addAll(tuijianBean.getData());
            datas.addAll(temp);
        } else {
            if (datas.size()>=60){
                for (int i = 0; i < 20; i++) {
                    datas.remove(i);
                }
            }
            datas.addAll(temp);
            datas.addAll(tuijianBean.getData());
        }
        temp = null;


        adapter.setData(datas);
        adapter.notifyDataSetChanged();
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


    @Override
    public void show(String data) {
        MyApplication.getInstances().spUtils.putString(MyApplication.tuijian, data);
        tuijianBean = JSON.parseObject(data, TuijianBean.class);
        processData(tuijianBean);
    }
}
