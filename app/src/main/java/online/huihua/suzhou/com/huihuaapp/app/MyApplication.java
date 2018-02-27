package online.huihua.suzhou.com.huihuaapp.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.antfortune.freeline.FreelineCore;
import com.squareup.leakcanary.LeakCanary;

import online.huihua.suzhou.com.huihuaapp.BuildConfig;

/**
 * Created by wanglei on 2018/2/25.
 */

public class MyApplication extends Application {

    public static RequestQueue requestQueue;
    private static boolean is_need_update;
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG)
            FreelineCore.init(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }

    public static void setNeedUpdateApk(boolean bool) {
        is_need_update = bool;
    }

    public static RequestQueue getHttpQueue() {
        return requestQueue;
    }
}
