/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-merchant-trunk
 * $Id$
 * $Revision$
 * Last Changed by yujs at 2011-11-2 上午11:20:47
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * yujs       2011-11-2        Initailized
 */
package com.jzzms.framework.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    
    protected final  Log log = LogFactory.getLog(getClass());
    
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,ServletException {
        log.info("用户登录成功，开始跳转...");
        log.info("用户登录成功，跳转完成:" + getRealIp(request));
        super.onAuthenticationSuccess(request, response, authentication);
    }
    
    /**
     * 获取访问者真实ip地址
     * @param request
     * @return
     */
    private String getRealIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
