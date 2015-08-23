/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-9-18 下午7:05:51
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-9-18        Initailized
 */

package com.jzzms.framework.util.common;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.jzzms.framework.core.Constants;
import com.jzzms.framework.core.UserDetailsImpl;
import com.jzzms.framework.util.lang.DateTimeUtils;
import com.jzzms.framework.util.lang.ReflectionUtils;


/**
 * model更新的辅助类
 *
 */
public class ModelUpdateInfoUtils {
    //创建和修改信息
    public static final String CREATE_TIME =        "createTime";
    public static final String CREATE_OPER_ID =     "createOperId";
    public static final String CREATE_OPER_NAME =   "createOperName";
    public static final String LAST_MOD_TIME =      "updateTime";
    public static final String LAST_MOD_OPER_ID =   "updateOperId";
    public static final String LAST_MOD_OPER_NAME = "updateOperName";
    public static final String STATUS =             "status";
    
    //主键
    public static final String ID =                 "id";
    public static final String CODE =               "code";
    public static final String APP_CODE =           "appCode";
    
    private ModelUpdateInfoUtils(){
        
    }
    
    //更新时间
    public static void updateModelUpdateTime(Object object){
        if(object == null){
            return;
        }
        
        //做更新
        if(ReflectionUtils.getDeclaredField(object,LAST_MOD_TIME) != null){
            ReflectionUtils.invokeSetterMethod(object, LAST_MOD_TIME, new Date());
        }
    }
  
    public static Date getModelUpdateTime(Object object){
        if(object == null){
            return null;
        }
        
        try{
            if(ReflectionUtils.getDeclaredField(object,LAST_MOD_TIME) != null){
                Object dateObj = ReflectionUtils.invokeGetterMethod(object, LAST_MOD_TIME);
                if(dateObj instanceof Date){
                    return (Date)dateObj;
                }
            }
        }
        catch(Exception e){
            
        }
        
        return null;
    }
    
    public static void updateModelInfo(Serializable object, UserDetailsImpl user){
        if(object == null || user == null){
            return;
        }
        
        if(ReflectionUtils.getDeclaredField(object,LAST_MOD_OPER_ID) != null){
            if(StringUtils.isNotBlank(user.getUserId())){
                Long operId = NumberUtils.toLong(user.getUserId());
                ReflectionUtils.invokeSetterMethod(object, LAST_MOD_OPER_ID, operId);
            }
        }
        if(ReflectionUtils.getDeclaredField(object,LAST_MOD_OPER_NAME) != null){
            ReflectionUtils.invokeSetterMethod(object, LAST_MOD_OPER_NAME, user.getRealname());
        }
        
        //如果主键为空，则设置创建
        if(ReflectionUtils.getDeclaredField(object,ID) != null){
            Object idValue = ReflectionUtils.getFieldValue(object, ID);
            if(idValue == null || "".equals(idValue)){
                //一定要设置为空，要不然无法插入数据库
                ReflectionUtils.setFieldValue(object, ID, null);
                updateModelCreateInfo(object,user);
                updateModelUpdateTime(object);
            }
        }
        else if(ReflectionUtils.getDeclaredField(object,CODE) != null || 
                ReflectionUtils.getDeclaredField(object,APP_CODE) != null){
            Object createTime = ReflectionUtils.getFieldValue(object, CREATE_TIME);
            if(createTime == null){
                updateModelCreateInfo(object,user);
                updateModelUpdateTime(object);
            }
        }
    }
    
     protected static void updateModelCreateInfo(Serializable object, UserDetailsImpl user){
         if(ReflectionUtils.getDeclaredField(object,CREATE_TIME) != null){
             ReflectionUtils.invokeSetterMethod(object, CREATE_TIME, DateTimeUtils.getCurrentDate());
         }
         if(ReflectionUtils.getDeclaredField(object,CREATE_OPER_ID) != null){
             if(StringUtils.isNotBlank(user.getUserId())){
                 Long operId = NumberUtils.toLong(user.getUserId());
                 ReflectionUtils.invokeSetterMethod(object, CREATE_OPER_ID, operId);
             }
         }
         if(ReflectionUtils.getDeclaredField(object,CREATE_OPER_NAME) != null){
             ReflectionUtils.invokeSetterMethod(object, CREATE_OPER_NAME, user.getRealname());
         }
     }
     
     public static void createModelInfoBySys(Serializable object, String transCode){
         if(ReflectionUtils.getDeclaredField(object,CREATE_TIME) != null){
             ReflectionUtils.invokeSetterMethod(object, CREATE_TIME, DateTimeUtils.getCurrentDate());
         }
         if(ReflectionUtils.getDeclaredField(object,CREATE_OPER_ID) != null){
             ReflectionUtils.invokeSetterMethod(object, CREATE_OPER_ID, Constants.GLOBAL_SYSTEM_OPER_ID);
         }
         if(ReflectionUtils.getDeclaredField(object,CREATE_OPER_NAME) != null){
             ReflectionUtils.invokeSetterMethod(object, CREATE_OPER_NAME, transCode);
         }
         if(ReflectionUtils.getDeclaredField(object,LAST_MOD_TIME) != null){
             ReflectionUtils.invokeSetterMethod(object, LAST_MOD_TIME, DateTimeUtils.getCurrentDate());
         }
         updateModelInfoBySys(object, transCode);
     }
         
     public static void updateModelInfoBySys(Serializable object, String transCode){
         if(ReflectionUtils.getDeclaredField(object,LAST_MOD_OPER_ID) != null){
             ReflectionUtils.invokeSetterMethod(object, LAST_MOD_OPER_ID, Constants.GLOBAL_SYSTEM_OPER_ID);
         }
         if(ReflectionUtils.getDeclaredField(object,LAST_MOD_OPER_NAME) != null){
             ReflectionUtils.invokeSetterMethod(object, LAST_MOD_OPER_NAME, transCode);
         }
     }
     
     public static void setModelInvalidStatus(Serializable object){
         if(ReflectionUtils.getDeclaredField(object,STATUS) != null){
             ReflectionUtils.invokeSetterMethod(object, STATUS, Constants.DICT_GLOBAL_STATUS_INVALIDATE);
         }
     }
}
