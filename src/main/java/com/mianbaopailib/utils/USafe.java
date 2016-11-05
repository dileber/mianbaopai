package com.mianbaopailib.utils;

import org.owasp.esapi.ESAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by shidawei on 16/7/21.
 */
public class USafe {

    public static String safeString(String url,Map<String,String[]> body){
        url = url(url);
        String hashurl = UHash.getHashValue(url, UHash.HashMethod.sha1);
        String hashbody = UHash.getHashValue(body(body), UHash.HashMethod.sha1);
        String md5url = UHash.getHashValue(url, UHash.HashMethod.md5);
        String hashurl_body = UHash.getHashValue(hashurl+hashbody, UHash.HashMethod.sha1);
        return hashurl_body+md5url;
    }

    private static String url(String url){
        if (url!=null&&url.trim().length()>1){
            url = url.trim().substring(1,url.length());
        }
        return url;
    }

    private static String body(Map<String,String[]> body){
        if(body==null||body.size()<=0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String key :body.keySet()) {
            String[] value = body.get(key);
            if(value.length>1){
                List<String> list = new ArrayList<String>();
                for(String v:value){
                    list.add(v.toString());
                }
                Collections.sort(list);
                int i=0;
                for(String l:list){
                    String temp = key.replace("[]","["+i+"]");
                    stringBuffer.append(temp).append(l);
                    i++;
                }
            }else if(value.length==1){
                String v = value[0];
                String temp = key.replace("[]","[0]");
                stringBuffer.append(temp).append(v);
            }

        }
        return stringBuffer.toString();
    }

    /**
     * 过滤xss
     * @param noSafeString
     * @return
     */
    public static String safeXss(String noSafeString){
        return ESAPI.encoder().encodeForHTML(noSafeString);
    }

}
