package nataya.pilipili.activity;

import android.content.Intent;
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

public class HuodongActivity extends AppCompatActivity {

    private HuatiBean huatiBean;
    private HuatiAdapter adapter;


    @InjectView(R.id.iv_back_huodong)
    ImageView ivBackHuodong;
    @InjectView(R.id.lv_huodong)
    ListView lvHuodong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        ButterKnife.inject(this);
        adapter = new HuatiAdapter(this);
        lvHuodong.setAdapter(adapter);
        initData();
        initListener();
    }

    private void initListener() {

        lvHuodong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HuodongActivity.this,WebActivity.class);
                intent.putExtra("url",huatiBean.getList().get(position).getLink());
                intent.putExtra("title",huatiBean.getList().get(position).getTitle());
                startActivity(intent);
//                Toast.makeText(HuodongActivity.this,huatiBean.getList().get(position).getTitle() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        LoadFromNet.getFromNet(AppNetConfig.HUODONG, new LoadNet() {
            @Override
            public void success(String context) {
                if (context != null) {
                    huatiBean = JSON.parseObject(context, HuatiBean.class);
                    if (huatiBean==null){
                        return;
                    }
                    processData(huatiBean);
                }
            }

            @Override
            public void failed(String error) {

            }
        });
    }

    private void processData(HuatiBean huatiBean) {
        adapter.setData(huatiBean);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back_huodong)
    public void onClick() {
        finish();
    }
}
