package online.huihua.suzhou.com.huihuaapp.util;

import com.google.gson.Gson;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.lang.reflect.Type;

import online.huihua.suzhou.com.huihuaapp.model.LoginResultData;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ObjectMapperFactory {

    public static ObjectMapper createObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public static <T> T convertJsonToObject(String jsonStr , Class<T> classOfT){
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, (Type)classOfT);
    }


}
