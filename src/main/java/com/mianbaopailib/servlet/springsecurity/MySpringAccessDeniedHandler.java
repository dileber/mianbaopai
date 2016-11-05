package com.mianbaopailib.servlet.springsecurity;

import com.mianbaopailib.model.BaseWrapper;
import com.mianbaopailib.utils.UJson;
import com.mianbaopailib.utils.ULog;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 2016/1/11.
 * 对spring security 拦截的重写
 *
 */
public class MySpringAccessDeniedHandler implements AccessDeniedHandler {

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        boolean isAjax = "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With"));
        //如果是ajax请求
        // Put exception into request scope (perhaps of use to a view)
        httpServletRequest.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
        // Set the 403 status code.
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        if (isAjax) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            BaseWrapper dataWrapper = new BaseWrapper("未授权不能访问",-1);
            out.println(UJson.toJson(dataWrapper));
            out.flush();
            out.close();
            return;
        }
        else if (!httpServletResponse.isCommitted()) {
            if (clientErrorPage != null) {

                // forward to error page.
                RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(clientErrorPage);
                dispatcher.forward(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
            }
        }
    }


    private String clientErrorPage;

    public void setClientErrorPage(String clientErrorPage) {

        if((clientErrorPage != null)&&!clientErrorPage.startsWith("/")){
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }
        this.clientErrorPage = clientErrorPage;
    }


}
