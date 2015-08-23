/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-17 下午12:44:45
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-17        Initailized
 */

package com.jzzms.framework.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jzzms.framework.core.Constants;
import com.jzzms.framework.util.lang.ReflectionUtils;
import com.jzzms.framework.validate.handler.ZzMsHandler;


/**
 * 数据校验器
 *
 */
public class Validator {
    protected static final Log log = LogFactory.getLog(Validator.class);
    //
    protected Map<String, ZzMsHandler> annotationHandlerMap;
    
    public final static String HANDLER_CLASS_PREFIX =       "com.orientpay.oecs.framework.validate.handler";
    public final static String HANDLER_CLAS_SUFFIX =        "Handler";
    public final static String HANDLER_NAME_PREFIX =        "Oecs";
    public final static String ANNOTATION_CLASS_PREFIX =    "com.orientpay.oecs.framework.validate.annotation";

    private static Validator validator = new Validator();

    private Validator() {
        annotationHandlerMap = new HashMap<String, ZzMsHandler>();
    }

    /**
     * get the Validator object
     * 
     * @return Validator object
     */
    public static Validator getInstance() {
        return validator;
    }

    public void validate(Object validatedObj) throws Exception {
        if (null == validatedObj) {
            log.info("The input validatedObj is null.");
            return;
        }
        
        Class<?> currentClass = validatedObj.getClass();
        while (currentClass != null) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field elem : fields) {
                validateField(validatedObj, elem);
            }

            Class<?> superClass = currentClass.getSuperclass();
            if(superClass != null){
                currentClass = validatedObj.getClass().isAssignableFrom(superClass) ? superClass : null;
            }
        }
    }

    private void validateField(Object validatedObj, Field field) throws Exception{
        // check whether the field is also AnnotationValidable
        if(validatedObj.getClass().isAssignableFrom(field.getType())){
            Object destValue = ReflectionUtils.invokeGetterMethod(validatedObj, field.getName());
            if(destValue == null) {
                  return;
            }
            else
            {
                validate(destValue);
            }
        }
        
        
        List<Annotation> annotations = getValidateAnnotations(field);
        if (annotations != null && annotations.size() > 0) {
            // loop each field annotations
            for (Annotation annotation : annotations) {
                String annotationSimpleName = annotation.annotationType().getSimpleName();
                ZzMsHandler handler = annotationHandlerMap.get(annotationSimpleName);
                if(handler == null){
                    String className = HANDLER_CLASS_PREFIX + Constants.DOT_SIGN_SPLIT_NAME + 
                            annotationSimpleName + HANDLER_CLAS_SUFFIX;
                    try {
                        handler = (ZzMsHandler) Class.forName(className).newInstance();
                        annotationHandlerMap.put(annotationSimpleName, handler);
                        
                    } 
                    catch (Exception ex) {
                        log.warn("WARN", ex);
                        throw new IllegalStateException(ex);
                    }
                }
                if(handler != null){
                    handler.validate(validatedObj, field);
                }
            }
        }
    }

    public static List<Annotation> getValidateAnnotations(Field field) {
        List<Annotation> annotations = new ArrayList<Annotation>();
        Annotation[] annos = field.getAnnotations();
        for (Annotation elem : annos) {
            if (elem.annotationType().getName().startsWith(ANNOTATION_CLASS_PREFIX)) {
                annotations.add(elem);
            }
        }
        return annotations;
    }
}
