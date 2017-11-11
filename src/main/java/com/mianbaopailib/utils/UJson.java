package com.mianbaopailib.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shidawei on 16/7/17.
 */
public class UJson {

    public static class DateDeserializer implements JsonDeserializer<Date> {
        public Date deserialize(JsonElement json, Type type,JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }
    }

    public static class DateSerializer implements JsonSerializer<Date> {
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
    }

    private static Gson gson = null;
    static {
        if (gson == null) {
            //gson = new Gson();
            GsonBuilder gsonb = new GsonBuilder();
            //Json中的日期表达方式没有办法直接转换成我们的Date类型, 因此需要单独注册一个Date的反序列化类.
            //DateDeserializer ds = new DateDeserializer();
            //给GsonBuilder方法单独指定Date类型的反序列化方法
            gson = gsonb.registerTypeAdapter(Date.class, new DateDeserializer())
                    .registerTypeAdapter(Date.class,new DateSerializer())
                    .setDateFormat(DateFormat.LONG)
                    .create();

        }
    }

//    public static final Gson gson= new Gson();
//
//

    public static String toJson(Object src){
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json,Class<T> c){
        try {
            return gson.fromJson(json, c);
        } catch (JsonSyntaxException ex) {
            // TODO Auto-generated catch block
            ULog.e(ex.toString());
            ex.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(JsonElement src, Class<T> c) {
        try {
            return gson.fromJson(src, c);
        } catch (JsonSyntaxException ex) {
            ULog.e(ex.toString());
            ex.printStackTrace();
            return null;
        }
    }

    public static List fromJson(String src, Type c) {
        try {
            return gson.fromJson(src, c);
        } catch (JsonSyntaxException ex) {
            ULog.e(ex.toString());
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> toList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> toMaps(String gsonString,Class<T> cls) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

}
