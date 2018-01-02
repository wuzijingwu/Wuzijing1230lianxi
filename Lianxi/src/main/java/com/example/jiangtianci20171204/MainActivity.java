package com.example.jiangtianci20171204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jiangtianci20171204.adapter.MyAdapter;
import com.example.jiangtianci20171204.api.APi;
import com.example.jiangtianci20171204.bean.Bean;
import com.example.jiangtianci20171204.persenter.Persenter;
import com.example.jiangtianci20171204.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{
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
