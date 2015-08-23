/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-15 上午11:45:50
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-15        Initailized
 * ZhouXushun     2011-9-26        处理resource和url为空时的空指针异常
 * 
 */

package com.jzzms.framework.service.security;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;

import com.jzzms.framework.core.Constants;
import com.jzzms.framework.service.cache.Cacheable;
import com.jzzms.framework.util.common.SystemPropertyUtils;
import com.jzzms.framework.util.lang.AssertUtils;

/**
 * 权限判断
 * 
 * 系统目前的权限相关的都移到此类上来了
 * 只处理url和button类型的资源，其他的资源无须判断，都由页面在生成的时候判断好了再显示的
 */
public class AccessDecisionService implements AccessDecisionManager, InitializingBean, Cacheable {
    protected Log log = LogFactory.getLog(getClass());
    
    //匹配方式
    //private UrlMatcher urlMatcher;
    //是否转成小写比较
    private boolean lowercaseComparisons = true;
    //是否匹配ANT PATH
    private boolean useAntPath = true;
    // 是否保护所有的没有记录的
    private boolean protectAllResource = false;
    //应用系统代码
    private String appCode;
    //appCode所有需要受保护的资源
    //List<ResourceDTO> protectedResourceList;
    //资源加载管理器
    //private UserLoginedLoadService sysInitLoadService;
    
    public AccessDecisionService(){
        //protectedResourceList = new ArrayList<ResourceDTO>(10);
    }
    
    //此类初始化后的操作
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet ...");
        
        appCode = SystemPropertyUtils.getString(Constants.SYSTEM_PROPERTY_APPCODE_KEY, "");
        log.debug("appCode : " + appCode);
        AssertUtils.notNull(appCode);
    }
    
    public void decide(Authentication authentication, Object securityObject, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        
        log.debug("decide ...");
        
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal() == null) {
            log.debug("Not Authenticated");
            throw new InsufficientAuthenticationException("Not Authenticated");
        }
        
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            log.debug("Not support for [" + principal + "]");
            throw new InsufficientAuthenticationException("Not support for [" + principal + "]");
        }
        
        //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //String url = null;
        if (securityObject instanceof FilterInvocation) {
            //FilterInvocation filter = (FilterInvocation) securityObject;
            //url = filter.getRequestUrl();
        }
        
        
    }
    
    
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }
    
    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    public synchronized void init(ApplicationContext ctx){
        log.debug("init...");
        reInit();
    }
    
    public synchronized void reInit(){
        log.debug("reInit...");
        
    }
    
    //得到用户的权限
    protected Collection<GrantedAuthority> getUserGrantedAuthrities(String appCode, String operatorId) {
    	return null;
    }
    
    public boolean isLowercaseComparisons() {
        return lowercaseComparisons;
    }
    
    public void setLowercaseComparisons(boolean lowercaseComparisons) {
        this.lowercaseComparisons = lowercaseComparisons;
    }
    
    public boolean isUseAntPath() {
        return useAntPath;
    }
    
    public void setUseAntPath(boolean useAntPath) {
        this.useAntPath = useAntPath;
    }
    
    public boolean isProtectAllResource() {
        return protectAllResource;
    }
    
    public void setProtectAllResource(boolean protectAllResource) {
        this.protectAllResource = protectAllResource;
    }
}
