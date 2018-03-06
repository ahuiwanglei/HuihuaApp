package online.huihua.suzhou.com.huihuaapp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.app.MyApplication;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.RespBase;
import online.huihua.suzhou.com.huihuaapp.view.ToastUtils;

/**
 * Created by 涂有泽 .
 * Date by 2016/3/8
 * Use by 公共方法
 */
public class Wethod {
    public static final int NETWORK_NONE = 0;
    public static final int NETWORK_WIFI = 1;
    public static final int NETWORK_MOBILE = 2;


    /**
     * 配置ImageLoder
     */
    public static void configImageLoader(Context context) {
        // 初始化ImageLoader
        @SuppressWarnings("deprecation")
        DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.mipmap.xiangcebg) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.xiangcebg) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.xiangcebg) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
//                         .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build(); // 创建配置过得DisplayImageOption对象

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }

    /***Volley框架Post请求***/
    public static void httpPost(final Context context, final int resultCode, String url, final Map<String, String> hMap, final VolleyCallBack<String> callBack) {
        httpPost(context, resultCode, url, hMap, callBack, View.VISIBLE);
    }

    /**
     * int DEPRECATED_GET_OR_POST = -1;
     * int GET = 0;
     * int POST = 1;
     * int PUT = 2;
     * int DELETE = 3;
     * int HEAD = 4;
     * int OPTIONS = 5;
     * int TRACE = 6;
     * int PATCH = 7;
     *
     * @param method
     * @param context
     * @param resultCode
     * @param url
     * @param body
     * @param callBack
     */
    public static void jsonPost(int method, final Context context, final int resultCode, String url, final String body, final VolleyCallBack<String> callBack) {
        final String password = SharedPreferenceUtils.getString(context, HuihuaConfig.CONFIGNAME, HuihuaConfig.EncryptKey);
        final String requestBody = Des.encrypt(body, password);
        LogUtil.print("请求地址：" + url );
        LogUtil.print("加密前：" + body);
        LogUtil.print("加密后：" + requestBody);

        JsonRequest jsonRequest = new JsonRequest(method, url, requestBody,
                new Response.Listener() {

                    @Override
                    public void onResponse(Object result) {
                        callBack.onSuccess(resultCode, result.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callBack.onError(volleyError);
            }
        }) {
            //
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String jsonString = new String(response.data);
                LogUtil.print("未解密前：" + jsonString.toString());

                String decrypt = Des.decrypt(StringBytes.hexStr2Bytes(jsonString.toString()), password);
                LogUtil.print("解密后：" + decrypt);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(decrypt);
                    if (jsonObject.getInt("ActionResults") == HuihuaConfig.Http.HttpErrorCode) {
                        return Response.error(new VolleyError("返回内容不是预期结果", new Throwable(jsonObject.getString("ErrorDesc"))));
                    } else {
                        return Response.success(decrypt, HttpHeaderParser.parseCacheHeaders(response));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return Response.error(new VolleyError("json解析错误", new Throwable("json解析错误，请返回正确的json格式")));
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                String tokenKey = SharedPreferenceUtils.getString(context, HuihuaConfig.CONFIGNAME, HuihuaConfig.TOKENKEY);
                if (StringUtil.isNotEmpty(tokenKey)) {
                    map.put("AccessToken", tokenKey);
                } else {
                    map.put("AppID", "MOBILE_SCFAPP");
                    map.put("AppSecret", SharedPreferenceUtils.getString(context, HuihuaConfig.CONFIGNAME, HuihuaConfig.EncryptKey));
                    map.put("TimeStamp", System.currentTimeMillis() + "");
                    map.put("NonceInt", StringUtil.randomInt() + "");
                    map.put("NonceChar", StringUtil.uuid().substring(8));
                    map.put("Signature", RSAUils.getSign(map, body));
                }

                return map;
            }
        };
        jsonRequest.setTag(resultCode);
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        MyApplication.getHttpQueue().add(jsonRequest);

    }
    /**
     */
    /***Volley框架Post请求***/
    public static void httpPost(final Context context, final int resultCode, String url, final Map<String, String> hMap, final VolleyCallBack<String> callBack, final int visableProgress) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
                objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
                try {
                    RespBase respBase = objectMapper.readValue(s, RespBase.class);

                    // {"resultStatus": "-9000", "msg": "非法请求，请重新登录！"}

                    if (respBase.isSuccess()) {
                        callBack.onSuccess(resultCode, s);
                    } else {
                        callBack.onFailed(resultCode, s);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse == null) {
                    callBack.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                map = hMap;
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("AppID", "MOBILE_SCFAPP");
                map.put("TimeStamp", System.currentTimeMillis() + "");
                map.put("NonceInt", StringUtil.randomInt() + "");
                map.put("NonceChar", StringUtil.uuid().substring(8));
                map.put("Signature", StringUtil.createSign("", "", "", ""));
                map.put("Content-Type", "application/json");
                return map;
            }
        };
        stringRequest.setTag(resultCode);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        MyApplication.getHttpQueue().add(stringRequest);
    }


    /***Volley框架Get请求***/
    public static void httpGet(final Context context, final int resultCode, String url, final VolleyCallBack<String> callBack) {
//        SsX509TrustManager.allowAllSSL();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
                objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
                try {
                    RespBase respBase = objectMapper.readValue(s.toString(), RespBase.class);
                    if (respBase.isSuccess()) {
                        callBack.onSuccess(resultCode, s);
                    } else {
                        callBack.onFailed(resultCode, s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse == null) {
                    ToastUtils.show(context, "您的网络好像不给力，请稍后再试");
                }

            }
        });
        stringRequest.setTag(resultCode);
        MyApplication.getHttpQueue().add(stringRequest);
    }

    /***Volley框架Get请求***/
    public static void httpxmlGet(final Context context, final int resultCode, String url, final VolleyCallBack<String> callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String s) {
                Log.e("liyunte", "sssssss" + s);
                callBack.onSuccess(resultCode, s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse == null) {
                    ToastUtils.show(context, "您的网络好像不给力，请稍后再试");
                }

            }
        }) {
        };

        MyApplication.getHttpQueue().add(stringRequest);
    }

    /**
     * jsonObject 解析的get请求
     *
     * @param resultCode
     * @param url
     * @param callBack
     */
    public static void httpget(final Context context, final int resultCode, String url, final VolleyCallBack<String> callBack) {
     /*   if (loadingPageDialog==null){
            loadingPageDialog = new LoadingPageDialog(context);
        }
        if (!loadingPageDialog.isShowing()){
            loadingPageDialog.show();
        }*/
//        SsX509TrustManager.allowAllSSL();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               /* if (loadingPageDialog!=null){
                    if (loadingPageDialog.isShowing()){
                        loadingPageDialog.dismiss();
                    }
                }*/

                JSONObject object;
                try {
                    object = new JSONObject(s.toString());
                    if ("ok".equalsIgnoreCase(object.getString("status"))) {
                        callBack.onSuccess(resultCode, s);
                    } else {
                        callBack.onFailed(resultCode, s);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse == null) {
                 /*   if (loadingPageDialog!=null){
                        if (loadingPageDialog.isShowing()){
                            loadingPageDialog.dismiss();
                        }
                    }*/
                    ToastUtils.show(context, "您的网络好像不给力，请稍后再试");
                }
            }
        });

        MyApplication.getHttpQueue().add(stringRequest);
    }

    /*发送jsonObjectRequest的Get请求*//*
    public static void HttpObjectGet(String url){
        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse==null){

                }
            }
        });
        MyApplication.getHttpQueue().add(jr);
    }*/

    /*********************当请求结果为ResultStatus为-1时******************************/
    public static void ToFailMsg(Context context, Object result) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            RespBase respBase = objectMapper.readValue(result.toString(), RespBase.class);
            Toast.makeText(context, respBase.getResultData().toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 打开网络设置界面
     */
    public static void openNetworkSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }

    /**
     * 弹出网络设置提示
     */
    public static void netWorkSettingAlert(final Context context) {
        new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("网络不可用，请检查网络连接")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (android.os.Build.VERSION.SDK_INT > 10) {
                            //3.0以上打开设置界面，也可以直接用ACTION_WIRELESS_SETTINGS打开到wifi界面
                            context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                        } else {
                            context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    }
                })
                .create().show();
    }

    /**
     * 获取手机Ip地址
     *
     * @return
     */

    public static String getPsdnIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        //if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet6Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }


}
