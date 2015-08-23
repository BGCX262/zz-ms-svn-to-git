/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-15 下午02:32:44
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-15        Initailized
 */

package com.jzzms.framework.service.cache;

import org.springframework.context.ApplicationContext;


/**
 * OECS缓存管理器
 *
 */
public class CacheManagerService {
    
    private Cacheable[] cacheableList;
    
    public void init(ApplicationContext ctx) {
        if(cacheableList != null && cacheableList.length > 0){
            for(Cacheable cacheable : cacheableList){
                cacheable.init(ctx);
            }
        }
    }

    public void reInit() {
        if(cacheableList != null && cacheableList.length > 0){
            for(Cacheable cacheable : cacheableList){
                cacheable.reInit();
            }
        }
    }

    public void setCacheableList(Cacheable[] cacheableList) {
        this.cacheableList = cacheableList;
    }
}
