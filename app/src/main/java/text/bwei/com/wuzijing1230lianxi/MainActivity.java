package text.bwei.com.wuzijing1230lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import text.bwei.com.wuzijing1230lianxi.adapter.MyAdapter;
import text.bwei.com.wuzijing1230lianxi.api.APi;
import text.bwei.com.wuzijing1230lianxi.bean.Bean;
import text.bwei.com.wuzijing1230lianxi.persenter.Persenter;
import text.bwei.com.wuzijing1230lianxi.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {
    private RecyclerView recycler;
    private MyAdapter adapter;
    private Persenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        presenter = new Persenter(this);
        presenter.loadlist(APi.week1);
    }

    @Override
    public void Success(List<Bean.DataBean.SubjectsBean> list) {
        adapter=new MyAdapter(MainActivity.this,list);
        recycler.setAdapter(adapter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.Jiebang(); //通过他来解绑
    }
}
