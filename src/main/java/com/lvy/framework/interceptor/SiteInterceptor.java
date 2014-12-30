package com.lvy.framework.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by livvy on 14-4-29.
 */
public class SiteInterceptor implements WebRequestInterceptor {
    public void preHandle(WebRequest request) throws Exception {
       // System.out.println(request.getSessionId());
    }

    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
