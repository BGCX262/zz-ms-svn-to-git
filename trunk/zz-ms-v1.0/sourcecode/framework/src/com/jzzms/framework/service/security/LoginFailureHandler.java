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
 * yujs     2011-11-2        Initailized
 */
package com.jzzms.framework.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


public class LoginFailureHandler  extends SimpleUrlAuthenticationFailureHandler  {
    
    
    protected final  Log log = LogFactory.getLog(getClass());
    
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,  AuthenticationException exception) throws ServletException,IOException
    {
        log.info("用户登录失败，记录信息...");
        

        log.debug("记录信息完毕 :" + getRealIp(request));
        
        request.getSession().setAttribute("errorMessage", "密码错误，请重新输入！");
        super.onAuthenticationFailure(request, response, exception);
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
