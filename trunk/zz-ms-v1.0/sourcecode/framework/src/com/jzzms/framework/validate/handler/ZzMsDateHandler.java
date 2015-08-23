/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:21:50
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-19        Initailized
 */

package com.jzzms.framework.validate.handler;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.util.lang.DateTimeUtils;
import com.jzzms.framework.util.lang.ReflectionUtils;
import com.jzzms.framework.validate.annotation.ZzMsDate;


/**
 * 日期的判断
 *
 */
public class ZzMsDateHandler implements ZzMsHandler {
    
protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            if(obj instanceof Date){
                return;
            }
            
            Date date = DateTimeUtils.stringFormatToDate(obj.toString(), null);
            if(date == null){
                log.info("the obj is invalidate for date");
                String message = field.getAnnotation(ZzMsDate.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
}
