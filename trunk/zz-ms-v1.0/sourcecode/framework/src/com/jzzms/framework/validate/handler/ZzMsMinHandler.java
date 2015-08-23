/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:24:03
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
import com.jzzms.framework.validate.annotation.ZzMsMin;


/**
 * 最小值
 *
 */
public class ZzMsMinHandler implements ZzMsHandler {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            boolean result = StringUtils.isNumeric(obj.toString());
            log.debug("obj value is :" + obj.toString());
            if(!result){
                log.info("the obj is not a number");
                String message = field.getAnnotation(ZzMsMin.class).message();
                throw new IllegalArgumentException(message);
            }
            else{
                double value = Double.parseDouble(obj.toString());
                double minValue = field.getAnnotation(ZzMsMin.class).min();
                if(value < minValue){
                    log.info("the obj is less than max value :" + minValue);
                    String message = field.getAnnotation(ZzMsMin.class).message();
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }
}
