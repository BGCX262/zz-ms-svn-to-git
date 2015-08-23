/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-19 下午4:51:17
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-19        Initailized
 */

package com.jzzms.framework.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 最大长度
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ZzMsMaxLength {
    public int max() default Integer.MIN_VALUE;

    public String message() default "Value of the length is not in expected scope.";

}
