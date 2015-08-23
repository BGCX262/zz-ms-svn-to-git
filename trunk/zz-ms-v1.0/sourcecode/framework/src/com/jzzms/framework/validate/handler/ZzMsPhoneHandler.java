/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午5:25:06
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
import com.jzzms.framework.validate.annotation.ZzMsPhone;


/**
 * 是否为电话号码
 *
 */
public class ZzMsPhoneHandler implements ZzMsHandler {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    public void validate(Object validatedObj, Field field) throws Exception {
        Object obj = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
        if(obj != null){
            boolean result = checkPhoneNo(obj.toString());
            if(!result){
                log.info("the obj is invalidate for digits");
                String message = field.getAnnotation(ZzMsPhone.class).message();
                throw new IllegalArgumentException(message);
            }
        }
    }
    
    protected static boolean checkPhoneNo(String phoneNo){
        //mobile phone
        Pattern mpPattern = Pattern.compile("^(0)?1\\d{10}$");      
        boolean mpResult = mpPattern.matcher(phoneNo).matches();   
        //home phone
        Pattern hpPattern = Pattern.compile("^(0\\d{2,3})?(-)?\\d{7,8}(-(\\d)+)?$");      
        boolean hpResult = hpPattern.matcher(phoneNo).matches();   
        
        return (mpResult || hpResult);
    }
    
    //pass
    public static void main(String [] args){
        System.out.println("13564539543:" + checkPhoneNo("13564539543"));
        System.out.println("013564539543:" + checkPhoneNo("013564539543"));
        System.out.println("23564539543:" + checkPhoneNo("23564539543"));
        
        System.out.println("021-51560909:" + checkPhoneNo("021-51560909"));
        System.out.println("02151560909:" + checkPhoneNo("02151560909"));
        System.out.println("51560909:" + checkPhoneNo("51560909"));
        
        System.out.println("021a51560909:" + checkPhoneNo("021a51560909"));
        System.out.println("0215156090977:" + checkPhoneNo("0215156090977"));
        System.out.println("515609098:" + checkPhoneNo("5a5609098"));
        System.out.println("5156090989999:" + checkPhoneNo("515609098999"));
        
        System.out.println("02151560909-99:" + checkPhoneNo("02151560909-99"));
        System.out.println("021-51560909-99:" + checkPhoneNo("021-51560909-99"));
        System.out.println("02151560909-:" + checkPhoneNo("02151560909-"));
        System.out.println("51560909-44a" + checkPhoneNo("51560909-44a"));
    }
}
