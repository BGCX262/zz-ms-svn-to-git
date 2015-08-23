/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-12 下午05:25:48
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-12        Initailized
 */

package com.jzzms.framework.service.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 用户口令加密
 *
 */
public class UserPasswordSaltSource implements SaltSource {

    public static final String USER_PASSWORD_SALT_PREFIX = "jzzms:";
    
    private static PasswordEncoder passwordEncoder = new ShaPasswordEncoder();
    
    public Object getSalt(UserDetails user) {
        return USER_PASSWORD_SALT_PREFIX + user.getUsername();
    }
    
    public Object getSalt(String userName) {
        return USER_PASSWORD_SALT_PREFIX + userName;
    }
    
    public static String encodePassword(String password, String salt) {
        return passwordEncoder.encodePassword(password, USER_PASSWORD_SALT_PREFIX + salt);
    }
}
