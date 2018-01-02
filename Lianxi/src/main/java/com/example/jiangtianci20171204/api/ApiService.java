package com.example.jiangtianci20171204.api;

import com.example.jiangtianci20171204.bean.Bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 姜天赐 on 2017/12/4.
 */

public interface ApiService {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<Bean> getdata();
}
