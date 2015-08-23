/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-15 下午01:59:33
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-15        Initailized
 */

package com.jzzms.framework.service.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 用户用于权限访问的资源
 * 
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    
    private static final long serialVersionUID = 2778921792207272406L;
    
    private String resource;
    private String resourceType;
    
    public GrantedAuthorityImpl(String resource) {
        this.resource = resource;
    }
    
    public GrantedAuthorityImpl(String resourceType, String resource) {
        this.resourceType = resourceType;
        this.resource = resource;
    }
    
    /**
     * Property accessor of resource
     * 
     * @return the resource
     */
    public String getResource() {
        return resource;
    }
    
    /**
     * @param resource
     *            the resource to set
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
    
    /**
     * Property accessor of resourceType
     * 
     * @return the resourceType
     */
    public String getResourceType() {
        return resourceType;
    }
    
    /**
     * @param resourceType
     *            the resourceType to set
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

	public String getAuthority() {
		return null;
	}
}
