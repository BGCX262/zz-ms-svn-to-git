/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:20:14
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-19        Initailized
 */

package com.jzzms.framework.validate.handler;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.util.lang.ReflectionUtils;
import com.jzzms.framework.validate.annotation.ZzMsAlphanumeric;


/**
 * 字母
 *
 */
public class ZzMsAlphanumericHandler implements ZzMsHandler{
    
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            boolean result = StringUtils.isAlphanumeric(obj.toString());
            log.debug("obj value is :" + obj.toString());
            if(!result){
                log.info("the obj is invalidate for Alphanumeric");
                String message = field.getAnnotation(ZzMsAlphanumeric.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
