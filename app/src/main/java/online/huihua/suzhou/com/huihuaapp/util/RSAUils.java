package online.huihua.suzhou.com.huihuaapp.util;


import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

/**
 * Created by wanglei on 2018/2/28.
 */

public class RSAUils {

    private static String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoEBw9ySDYAiIFyLaqKp9zZSEU\n" +
            "66zsLH3OQPhZ4RR+glAT70tOOxBMqun9Wyv9VmJDMUfvEFtn9KjUJF256/xnIDPw\n" +
            "URpeosnZ9BW3S/7HUAbkzgR4q7g6TlP44EFBSBkB/K2KqFuO7Ivur1xnk2HRhydq\n" +
            "+hAlFNWIBHDl6tZO1wIDAQAB";
    public static  String privateKeyStr = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKgQHD3JINgCIgXI\n" +
            "tqoqn3NlIRTrrOwsfc5A+FnhFH6CUBPvS047EEyq6f1bK/1WYkMxR+8QW2f0qNQk\n" +
            "Xbnr/GcgM/BRGl6iydn0FbdL/sdQBuTOBHiruDpOU/jgQUFIGQH8rYqoW47si+6v\n" +
            "XGeTYdGHJ2r6ECUU1YgEcOXq1k7XAgMBAAECgYEAlmJMExFtPTyzWv+eTCh1o5lj\n" +
            "f8ffZTnunOfQEwTwBL/wjdX7SZZaYHAzjszNURTCOqPXXVkCocPwalvcLmi24dCV\n" +
            "s4p8I2x6j1+hDvyERaZ051cMn+0XOdB750OsuiH7JePKEycpDd3VE6OBE6n5tAq3\n" +
            "lFCdWDQ7NyPzT40hBCECQQDdUvuDrsudSvrCivJq7bHQtVZfi+fKIDtMDKIKqTOf\n" +
            "HOtewnvN4vsXZgHix86xmFDPKQ+vEv1X9bzWxdlBzQWRAkEAwmTkIDPgaJX4RZug\n" +
            "IzFRPS4uGbrimksEYkv8LhOEMM3Zwla/jhADU0p5cyA/+MGY1NMGibMF2MEQYv1R\n" +
            "Sok55wJBAIF7+RYzf4CIy2hh7i3M3okibmP78CH69XYqterSzxa5zqJj2ha8QvaP\n" +
            "gW7yQuT4Hd71QO3GiF2bsV1d5xtuHWECQDXNrOJI2XS5BXVmpIT5Em4niPTwJ+Xi\n" +
            "m30FYO/z0OOdJgdG8U/FmNYFx+WYaHxWQRGusqGMHjMnBH0Rdd12a8MCQQCVykt8\n" +
            "6eo2zYCVdIv584D2ArwZv+FsRvGbr806P9yDYiRA+u1hKMd+uiKU4fHBiaM0p6vP\n" +
            "jeTqu/yyOyDoggtP";

    /**
     * 生成签名
     *
     * @param map
     * @param requestBody
     * @return
     */
    public static String getSign(Map<String, String> map, String requestBody) {
        List<String> list = new ArrayList<String>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getValue());
            LogUtil.print(entry.getKey() +":" + entry.getValue());
        }
        list.add(requestBody);
        LogUtil.print("body:" + requestBody);
        String[] params = new String[list.size()];
        for (int i=0;i< list.size();i++){
            params[i] = list.get(i);

        }
        Arrays.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return stringToAscii(o1).compareTo(stringToAscii(o2));
            }
        });
        String tmpStr = "";
        for (int i = 0; i < params.length; i++) {
            tmpStr += params[i];
        }
        LogUtil.print("拼接后："+tmpStr);
        try {
            byte[] md5Str = MD5.getMd5Bytes(tmpStr);
            String base64 = Base64.encode(md5Str);
            System.out.println("Base64编码后: " + base64);
            byte[] base64Bytes = base64.getBytes();

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKeyStr);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String rsa = Base64.encode(cipher.doFinal(base64Bytes));
            System.out.println("加密后：" + rsa);

            return rsa;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }
}
