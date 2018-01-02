package text.bwei.com.wuzijing1230lianxi.persenter;


import java.util.List;

import text.bwei.com.wuzijing1230lianxi.bean.Bean;
import text.bwei.com.wuzijing1230lianxi.model.Imodel;
import text.bwei.com.wuzijing1230lianxi.model.Model;
import text.bwei.com.wuzijing1230lianxi.model.OnClick;
import text.bwei.com.wuzijing1230lianxi.view.Iview;

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
