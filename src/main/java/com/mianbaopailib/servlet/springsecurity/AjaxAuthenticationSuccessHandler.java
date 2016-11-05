package com.mianbaopailib.servlet.springsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 2016/1/12.
 */
public abstract class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public AjaxAuthenticationSuccessHandler() {
    }

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.print(onAuthenticationJsonToString(authentication,httpServletRequest));
        out.flush();
        out.close();
    }

    public abstract String onAuthenticationJsonToString(Authentication authentication,HttpServletRequest httpServletRequest);

}
