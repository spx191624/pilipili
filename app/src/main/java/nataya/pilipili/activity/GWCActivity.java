package nataya.pilipili.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.GoodsAdapter;
import nataya.pilipili.bean.GoodBean;
import nataya.pilipili.utils.MyApplication;
import nataya.pilipili.utils.NumChangeListener;

public class GWCActivity extends AppCompatActivity {

    @InjectView(R.id.ll)
    ListView ll;
    @InjectView(R.id.zongjia)
    TextView zongjia;
    @InjectView(R.id.bt_goodinfo_cancel)
    Button btGoodinfoCancel;
    @InjectView(R.id.bt_goodinfo_confim)
    Button btGoodinfoConfim;
    @InjectView(R.id.ll_btn)
    LinearLayout llBtn;
    @InjectView(R.id.activity_gwc)
    RelativeLayout activityGwc;
    @InjectView(R.id.all)
    CheckBox all;
    private GoodsAdapter adapter;
    private boolean ischechall = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwc);
        ButterKnife.inject(this);
        adapter = new GoodsAdapter(this, new NumChangeListener() {
            @Override
            public void changed() {
                setPrice();
                all.setChecked(isIscheckall());
            }
        });
        ll.setAdapter(adapter);
        initData();
        setPrice();
        all.setChecked(isIscheckall());
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<GoodBean> list = MyApplication.getInstances().getDaoSession().getGoodBeanDao().loadAll();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIschecked(all.isChecked());
                    MyApplication.getInstances().getDaoSession().getGoodBeanDao().update(list.get(i));
                }
                initData();
                setPrice();
            }
        });
    }
    private boolean isIscheckall(){
        List<GoodBean> list = MyApplication.getInstances().getDaoSession().getGoodBeanDao().loadAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getIschecked()){
                return false;
            }
        }
        return true;
    }

    private void setPrice() {
        List<GoodBean> list = MyApplication.getInstances().getDaoSession().getGoodBeanDao().loadAll();
        double price = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIschecked()) {
                price += list.get(i).getNum() * list.get(i).getPrice();
            }
        }
        zongjia.setText("￥" + (int) (price) + "");
    }

    private void initData() {
        List<GoodBean> list = MyApplication.getInstances().getDaoSession().getGoodBeanDao().loadAll();
        adapter.setData(list);
        adapter.notifyDataSetChanged();

    }

    @OnClick({R.id.bt_goodinfo_cancel, R.id.bt_goodinfo_confim})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_goodinfo_cancel:
                finish();
                break;
            case R.id.bt_goodinfo_confim:
                break;
        }
    }
}
