package com.mianbaopailib.servlet;

import com.mianbaopailib.AppConstant;
import com.mianbaopailib.utils.ULog;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by shidawei on 16/7/14.
 */
public class MyDispatcherServlet extends DispatcherServlet{

    static boolean info = true;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb;
        if(info){
            long cur = System.currentTimeMillis();
            sb = new StringBuilder();
            ULog.i("session info:");
            String req = request.getRequestURL().toString();
            ULog.i("URL:",req);
            HttpSession status = request.getSession();
            Enumeration headerNames = status.getAttributeNames();
            while(headerNames.hasMoreElements()) {
                String parameterMap = (String)headerNames.nextElement();
                sb.append("\t{").append(parameterMap).append(" = ").append(status.getAttribute(parameterMap)).append("}");
            }

            sb.append("\n");
            ULog.i("\t", sb.toString());
            sb.delete(0, sb.length());
            ULog.i("request info:");
            ULog.i("request ip:", request.getRemoteAddr());
            Map parameterMap1 = request.getParameterMap();
            Set hn = parameterMap1.keySet();
            Iterator headerNames1 = hn.iterator();

            String hn1;
            while(headerNames1.hasNext()) {
                hn1 = (String)headerNames1.next();
                sb.append("\t{").append(hn1).append(" = ").append(parameterMap1.get(hn1)).append("}");
            }
            sb.append("\n");
            ULog.i("\t", sb.toString());
            ULog.i("request header");
            sb.delete(0, sb.length());
            Enumeration headerNames3 = request.getHeaderNames();
            while(headerNames3.hasMoreElements()) {
                hn1 = (String)headerNames3.nextElement();
                sb.append("\t{").append(hn1).append(" = ").append(request.getHeader(hn1)).append("}");
            }
            ULog.i("\t", sb.toString());
            ULog.i("cost time:", Long.valueOf(System.currentTimeMillis() - cur));
        }
        super.service(request, response);
        if(info) {
            sb = new StringBuilder();
            int status = response.getStatus();
            ULog.i("response status:", status);
            Collection headerNames2 = response.getHeaderNames();
            Iterator parameterMap2 = headerNames2.iterator();

            while(parameterMap2.hasNext()) {
                String hn2 = (String)parameterMap2.next();
                sb.append("\t{").append(hn2).append(" = ").append(request.getHeader(hn2)).append("}");
            }

            ULog.i("\t",sb.toString());
            ULog.i("\n");
        }
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        if(!MyContextLoaderListener.AppContextConfig.contants.isInfo()){
            info = false;
            ULog.w("未开启访问信息打印");
        }
        if(info){
            ULog.w("MyDispatcherServlet初始化");
        }

    }
}
