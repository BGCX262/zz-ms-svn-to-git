package com.jzzms.framework.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 */

public class InvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	protected Log log = LogFactory.getLog(getClass());
	
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public InvocationSecurityMetadataSource() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {
    	log.debug("loadResourceDefine ...");
    	
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);
        
        resourceMap.put("/bsp/index.action", atts);
        
        Collection<ConfigAttribute> attsno = new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");
        attsno.add(cano);
        resourceMap.put("/index.jsp", attsno);
    }

    // According to a URL, Find out permission configuration of this URL.
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    	log.debug("getAttr, object ->" + object);
    	
        // guess object is a URL.
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.pathMatchesUrl(resURL, url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

}
