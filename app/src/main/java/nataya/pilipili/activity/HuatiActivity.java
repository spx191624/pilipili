package nataya.pilipili.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.HuatiAdapter;
import nataya.pilipili.bean.HuatiBean;
import nataya.pilipili.utils.AppNetConfig;
import nataya.pilipili.utils.LoadFromNet;
import nataya.pilipili.utils.LoadNet;

public class HuatiActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back_huati)
    ImageView ivBackHuati;
    @InjectView(R.id.lv_huati)
    ListView lvHuati;
    private HuatiAdapter adapter;
    private HuatiBean huatiBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huati);
        ButterKnife.inject(this);
        initData();
        initListener();

    }

    private void initListener() {

        lvHuati.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HuatiActivity.this,huatiBean.getList().get(position).getTitle() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        LoadFromNet.getFromNet(AppNetConfig.HUATI, new LoadNet() {
            @Override
            public void success(String context) {
                if (context != null) {
                    huatiBean = JSON.parseObject(context, HuatiBean.class);
                    processData(huatiBean);
                }
            }

            @Override
            public void failed(String error) {

            }
        });
    }

    private void processData(HuatiBean huatiBean) {
        adapter = new HuatiAdapter(this, huatiBean);
        lvHuati.setAdapter(adapter);

    }

    @OnClick(R.id.iv_back_huati)
    public void onClick() {
        finish();
    }
}
