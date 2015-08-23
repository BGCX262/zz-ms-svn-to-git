/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-utility-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-9-13 下午5:19:43
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-9-13        Initailized
 */

package com.jzzms.framework.util.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.util.lang.ResourcesUtils;


/**
 * 系统属性配置文件工具类
 *
 */
public class SystemPropertyUtils {
    
    protected static final Log log = LogFactory.getLog(SystemPropertyUtils.class);
    protected static final String SYSTEM_PROPERTY_FILENAME = "system.properties";
    private static Properties prop;
    
    private SystemPropertyUtils(){
        
    }
    
    public static String getString(String aKey){
        return getString(aKey,"");
    }
    
    public static String getString(String aKey,String defaultValue){
      String value = (String)prop.get(aKey);
      if(StringUtils.isBlank(value)){
          log.debug("the property is null");
          value = defaultValue;
      }
      log.debug("the property is ->" + value);
      return value;
    }

    static{
        try {
            prop = ResourcesUtils.getResourceAsProperties(SYSTEM_PROPERTY_FILENAME);
        } 
        catch (IOException e) {
            log.error("ERROR", e);
            throw new RuntimeException("Could not find : " + SYSTEM_PROPERTY_FILENAME,e);
        }
    }
}
