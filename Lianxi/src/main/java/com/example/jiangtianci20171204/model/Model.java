package com.example.jiangtianci20171204.model;

import android.util.Log;

import com.example.jiangtianci20171204.api.APi;
import com.example.jiangtianci20171204.api.ApiService;
import com.example.jiangtianci20171204.bean.Bean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 姜天赐 on 2017/12/4.
 */

public class Model implements Imodel {
    @Override
    public void RequestData(String url, final OnClick onClick) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APi.week1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean> getdata = apiService.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        List<Bean.DataBean.SubjectsBean> subjects = bean.data.subjects;
                        onClick.Success(subjects);
                    }
                });
    }

}
