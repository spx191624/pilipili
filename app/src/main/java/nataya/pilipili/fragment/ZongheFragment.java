package nataya.pilipili.fragment;

import android.view.View;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nataya.pilipili.R;
import nataya.pilipili.adapter.ZongheAdapter;
import nataya.pilipili.view.BaseFragment;

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
