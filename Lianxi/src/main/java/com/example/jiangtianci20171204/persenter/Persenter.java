package com.example.jiangtianci20171204.persenter;
import com.example.jiangtianci20171204.bean.Bean;
import com.example.jiangtianci20171204.model.Imodel;
import com.example.jiangtianci20171204.model.Model;
import com.example.jiangtianci20171204.model.OnClick;
import com.example.jiangtianci20171204.view.Iview;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/4.
 */

public class Persenter implements Ipersenter {
    Imodel imodel;
    Iview iview;

    public Persenter(Iview iview) {
        this.iview = iview;
        this.imodel=new Model();
    }
    public void Jiebang(){
        imodel=null;
    }
    @Override
    public void loadlist(String url) {
        imodel.RequestData(url, new OnClick() {
            @Override
            public void Success(List<Bean.DataBean.SubjectsBean> list) {
                iview.Success(list);
            }
        });

    }
}
