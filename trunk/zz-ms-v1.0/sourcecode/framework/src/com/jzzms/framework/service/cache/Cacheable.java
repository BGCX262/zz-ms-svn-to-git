/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-15 上午10:25:44
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
 * 系统缓存
 *
 */
public interface Cacheable {
    public void init(ApplicationContext ctx);
    
    public void reInit();
}
