package com.mianbaopailib.servlet.springsecurity;

import com.mianbaopailib.model.BaseWrapper;
import com.mianbaopailib.utils.UJson;
import com.mianbaopailib.utils.ULog;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 2016/1/12.
 */
public abstract class MyAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public MyAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    /**
     * 跳转判断条件
     * @param url
     * @return
     */
    public abstract boolean condition(String url);

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        String redirectUrl = null;
        String url = request.getRequestURI();
        ULog.w(url," 未登录拦截 ");
        if(condition(url)){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            BaseWrapper dataWrapper = new BaseWrapper("您还未登录",-1);
            out.println(UJson.toJson(dataWrapper));
            out.flush();
            out.close();
        }else{
            if (this.isUseForward()) {

                if (this.isForceHttps() && "http".equals(request.getScheme())) {
                    // First redirect the current request to HTTPS.
                    // When that request is received, the forward to the login page will be used.
                    redirectUrl = buildHttpsRedirectUrlForRequest(request);
                }

                if (redirectUrl == null) {
                    String loginForm = determineUrlToUseForThisRequest(request, response, authException);

                    RequestDispatcher dispatcher = request.getRequestDispatcher(loginForm);

                    dispatcher.forward(request, response);

                    return;
                }
            } else {
                // redirect to login page. Use https if forceHttps true

                redirectUrl = buildRedirectUrlToLoginPage(request, response, authException);

            }

            redirectStrategy.sendRedirect(request, response, redirectUrl);
        }

    }


}
