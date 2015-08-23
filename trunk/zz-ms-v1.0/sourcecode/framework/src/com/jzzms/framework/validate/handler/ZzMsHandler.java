/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-17 下午12:55:07
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-17        Initailized
 */

package com.jzzms.framework.validate.handler;

import java.lang.reflect.Field;


/**
 * 验证接口
 *
 */
public interface ZzMsHandler {
    
    public void validate(Object validatedObj, Field field) throws Exception;
}
