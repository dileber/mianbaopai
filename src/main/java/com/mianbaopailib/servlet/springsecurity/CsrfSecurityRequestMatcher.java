package com.mianbaopailib.servlet.springsecurity;

import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by shidawei on 16/8/1.
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher{

    private final HashSet<String> allowedMethods;

    private CsrfSecurityRequestMatcher() {
        this.allowedMethods = new HashSet(Arrays.asList(new String[]{"GET", "HEAD", "TRACE", "OPTIONS"}));
    }

    public boolean matches(HttpServletRequest request) {
        if (execludeUrls != null && execludeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            for (String url : execludeUrls) {
                if (servletPath.equals(url)) {
                    return false;
                }
            }
        }
        return !this.allowedMethods.contains(request.getMethod());
    }
    /**
    * 需要排除的url列表
    */
    private List<String> execludeUrls;

    public List<String> getExecludeUrls() {
        return execludeUrls;
    }

    public void setExecludeUrls(List<String> execludeUrls) {
        this.execludeUrls = execludeUrls;
    }
}
