/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:23:46
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-19        Initailized
 */

package com.jzzms.framework.validate.handler;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.util.lang.ReflectionUtils;
import com.jzzms.framework.validate.annotation.ZzMsMaxLength;


/**
 * 最大长度
 *
 */
public class ZzMsMaxLengthHandler implements ZzMsHandler {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            log.debug("obj value is :" + obj.toString());
            double maxValue = field.getAnnotation(ZzMsMaxLength.class).max();
            int value = obj.toString().length();
            if(value > maxValue){
                log.info("the obj length is great than max value :" + maxValue);
                String message = field.getAnnotation(ZzMsMaxLength.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
