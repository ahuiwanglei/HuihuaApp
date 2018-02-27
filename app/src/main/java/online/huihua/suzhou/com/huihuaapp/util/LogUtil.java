package online.huihua.suzhou.com.huihuaapp.util;

import android.util.Log;

public class LogUtil {
	public static  void print(String message) {
		Log.i("OrderManager", message);
	}
	
	public static void http(String message){
		Log.i("http", message);
	}
	
	public static void print(String tag, String message){
		Log.i(tag, message);
	}
}
