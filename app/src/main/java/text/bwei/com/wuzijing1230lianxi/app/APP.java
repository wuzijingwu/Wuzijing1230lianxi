package text.bwei.com.wuzijing1230lianxi.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 姜天赐 on 2017/12/4.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
