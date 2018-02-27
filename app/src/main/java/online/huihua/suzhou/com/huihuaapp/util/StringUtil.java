package online.huihua.suzhou.com.huihuaapp.util;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty() || str.length() == 0 || str.equalsIgnoreCase("null")) {
			return true;
		}
		return false;
	}

	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}
	
	/**
	 * 
	 * @param str
	 *            is null or ""
	 * @return true is not null
	 */
	public static final boolean isNotEmpty(String str) {
		return !(str == null || str.equals(""));
	}


	public static boolean isEmpty(TextView tv) {
		return isEmpty(tv.getText().toString());
	}

	public static String convertDate(String date) {
		if (isEmpty(date)) {
			return "";
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d;
			try {
				d = df.parse(date);
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
				return df2.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "";
		}

	}

	public static String convertNull(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str;
	}

	public static float convertFloat(String per) {
		if (isEmpty(per)) {
			return 0f;
		} else {
			return Float.parseFloat(per);
		}
	}

    public static int randomInt() {
		return (int)((Math.random()*9+1)*10000000);
    }

    public static String uuid(){
		return UUID.randomUUID().toString();
	}

	public static String createSign(String timeStamp, String nonceInt, String nonceChar, String param) {
		String[] params = new String[6];
		params[0] = "WEB_WMSINTERFACE";
		params[1] = "!9.9^2@*L;qP";
		params[2] = timeStamp;
		params[3] = nonceInt;
		params[4] = nonceChar;
		params[5] = param;
		return "";
	}
}
