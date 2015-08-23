/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:24:21
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
import com.jzzms.framework.validate.annotation.ZzMsMinLength;


/**
 * 最小长度
 *
 */
public class ZzMsMinLengthHandler implements ZzMsHandler {
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            log.debug("obj value is :" + obj.toString());
            double minValue = field.getAnnotation(ZzMsMinLength.class).min();
            int value = obj.toString().length();
            if(value > minValue){
                log.info("the obj length is less than max value :" + minValue);
                String message = field.getAnnotation(ZzMsMinLength.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
