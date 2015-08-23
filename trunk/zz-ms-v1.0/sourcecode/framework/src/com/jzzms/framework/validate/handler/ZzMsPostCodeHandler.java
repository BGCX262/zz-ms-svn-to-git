/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:25:19
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-19        Initailized
 */

package com.jzzms.framework.validate.handler;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.util.lang.ReflectionUtils;
import com.jzzms.framework.validate.annotation.ZzMsPostCode;


/**
 * 邮政编码校验器
 *
 */
public class ZzMsPostCodeHandler implements ZzMsHandler {
    
protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            Pattern pattern = Pattern.compile("[0-9]*");      
            boolean result = pattern.matcher(obj.toString()).matches();      
            log.debug("obj value is :" + obj.toString());
            if((!result) || obj.toString().length() != 6){
                log.info("the obj is invalidate for digits");
                String message = field.getAnnotation(ZzMsPostCode.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
