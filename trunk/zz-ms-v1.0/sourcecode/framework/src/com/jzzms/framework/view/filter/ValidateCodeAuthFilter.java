/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-11-1 下午7:04:06
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-11-1        Initailized
 */

package com.jzzms.framework.view.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import com.jzzms.framework.core.Constants;
import com.jzzms.framework.util.common.SystemPropertyUtils;


/**
 * 带验证码的认证过滤器
 *
 */
public class ValidateCodeAuthFilter extends UsernamePasswordAuthenticationFilter {
    private boolean postOnly = true;
    private boolean allowEmptyValidateCode = true;
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //check validate code add by zhouxushun 
        String validatcodeFlag = SystemPropertyUtils.getString(Constants.SPRING_SECURITY_FORM_VCODE_KEY);
        if(!isAllowEmptyValidateCode() && "true".equalsIgnoreCase(validatcodeFlag)){
            checkValidateCode((HttpServletRequest)request);
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        HttpSession session = request.getSession(false);
        if (session != null || getAllowSessionCreation()) {
            request.getSession().setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
        }
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
    
    protected void checkValidateCode(HttpServletRequest request) {  
        String sessionValidateCode = obtainSessionValidateCode(request);  
        String validateCodeParameter = obtainValidateCodeParameter(request);  
        if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {  
            throw new AuthenticationServiceException("validateCode.notEquals");  
        }  
    }  
    
    protected String obtainSessionValidateCode(HttpServletRequest request) {
        String randCode = (String)request.getSession().getAttribute(Constants.SPRING_SECURITY_RANDS_IN_SESSION);
        //不需要移除，因为不是防止重复提交
        //request.getSession().removeAttribute(AbdfConstants.SPRING_SECURITY_RANDS_IN_SESSION);
        return randCode;
    }
    
    protected String obtainValidateCodeParameter(HttpServletRequest request) {
        return request.getParameter(Constants.SPRING_SECURITY_FORM_VCODE_KEY);
    }
    
    public boolean isPostOnly() {
        return postOnly;
    }
    
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
    
    public boolean isAllowEmptyValidateCode() {
        return allowEmptyValidateCode;
    }

    public void setAllowEmptyValidateCode(boolean allowEmptyValidateCode) {
        this.allowEmptyValidateCode = allowEmptyValidateCode;
    }
}
