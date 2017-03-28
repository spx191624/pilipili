package nataya.pilipili.activity;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.greendao.gen.HistoryDao;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nataya.pilipili.R;
import nataya.pilipili.adapter.HistoryAdapter;
import nataya.pilipili.bean.History;
import nataya.pilipili.utils.MyApplication;

public class SearchActivity extends AppCompatActivity {


    @InjectView(R.id.clean)
    TextView clean;
    @InjectView(R.id.back_search)
    ImageView backSearch;
    @InjectView(R.id.erweima_search)
    ImageView erweimaSearch;
    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.search_search)
    ImageView searchSearch;
    @InjectView(R.id.lv_search_history)
    ListView lvSearchHistory;
    @InjectView(R.id.finish)
    TextView finish;

    private List<History> histories;
    private HistoryDao dao;
    private long num;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);

        initData();
        initView();
        initListener();
    }

    private void initListener() {
        lvSearchHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchActivity.this, histories.get(position).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        if (histories.size() == 0) {
            lvSearchHistory.setVisibility(View.INVISIBLE);
        } else {
            lvSearchHistory.setVisibility(View.VISIBLE);
        }

    }

    private void initData() {
        dao = MyApplication.getInstances().getDaoSession().getHistoryDao();
        histories = dao.loadAll();
        num = histories.size();


        adapter = new HistoryAdapter(this, histories);
        lvSearchHistory.setAdapter(adapter);


    }

    @OnClick({R.id.back_search, R.id.erweima_search, R.id.clean, R.id.search_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_search:
                finish();
                break;
            case R.id.erweima_search:

                Intent intent = new Intent(SearchActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.clean:
                for (int i = 0; i <= histories.size(); i++) {
                    dao.deleteByKey((long) i);
                }
                initData();
                initView();
                adapter.notifyDataSetChanged();
                break;
            case R.id.search_search:
                String s = etSearch.getText().toString();
                if (s == null || s.length() == 0) {
                    return;
                }
                for (int i = 0; i < dao.loadAll().size(); i++) {
                    if (s.toString().equals(dao.loadAll().get(i).getText().toString())) {
                        return;
                    }
                }
                History his = new History((num + 1), etSearch.getText().toString().trim());
                dao.insert(his);
                initData();
                initView();
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    etSearch.setText(result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
