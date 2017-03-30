package nataya.pilipili.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.activity.PlayActivity;
import nataya.pilipili.activity.SearchShowActivity;
import nataya.pilipili.adapter.ZongheAdapter;
import nataya.pilipili.bean.SearchBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;
import nataya.pilipili.utils.NumUtils;
import nataya.pilipili.utils.ThreadPool;

/**
 * Created by 191624 on 2017/3/30.
 */
public class ZongheFragment extends BaseFragment {
    @InjectView(R.id.listview)
    ListView listview;
    public ZongheAdapter adapter;



    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_zonghe, null);
        ButterKnife.inject(this, view);
        adapter = new ZongheAdapter(getContext());
        listview.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
