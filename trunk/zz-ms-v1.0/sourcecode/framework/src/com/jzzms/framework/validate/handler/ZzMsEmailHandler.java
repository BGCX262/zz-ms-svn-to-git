/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:22:50
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
import com.jzzms.framework.validate.annotation.ZzMsEmail;


/**
 * 邮箱校验器
 *
 */
public class ZzMsEmailHandler implements ZzMsHandler {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+");      
            boolean result = pattern.matcher(obj.toString()).matches();      
            log.debug("obj value is :" + obj.toString());
            if(!result){
                log.info("the obj is invalidate for email");
                String message = field.getAnnotation(ZzMsEmail.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
