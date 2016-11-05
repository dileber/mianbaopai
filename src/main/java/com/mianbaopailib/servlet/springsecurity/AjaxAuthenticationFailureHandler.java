package com.mianbaopailib.servlet.springsecurity;

import com.mianbaopailib.model.BaseWrapper;
import com.mianbaopailib.utils.UJson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 接口登录返回错误提示
 * Created by yy on 2016/1/12.
 */
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public AjaxAuthenticationFailureHandler() {
    }

    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        BaseWrapper dataWrapper = new BaseWrapper(e.getMessage(),-1);
        out.println(UJson.toJson(dataWrapper));
        out.flush();
        out.close();
    }
}