package com.jzzms.bsp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jzzms.bsp.model.Operator;
import com.jzzms.framework.core.UserDetailsImpl;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.service.security.GrantedAuthorityImpl;

public class ZzUserDetailsSvr implements UserDetailsService {
    protected Log log = LogFactory.getLog(getClass());
    
    @Autowired
    OperatorService operatorService;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        log.debug("loadUserByUsername username: " + username);

        List<PropertyFilter> filters = new ArrayList<PropertyFilter>(2);
        filters.add(new PropertyFilter("EQS_LOGIN_NAME", username));
        filters.add(new PropertyFilter("EQS_STATUS", "V"));
        
        List<Operator> list = operatorService.search(filters);
        if(list == null || list.size() == 0){
        	log.warn("can not find [" + username + "]");
        	throw new UsernameNotFoundException("can not find [" + username + "]");
        }
        
        log.debug("get a user for username :" + username);
        Operator oper = list.get(0);
        UserDetailsImpl userDetail = new UserDetailsImpl();
        userDetail.setUsername(username);
        userDetail.setPassword(oper.getLoginPwd());
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_"));
        userDetail.setAuthorities(grantedAuthorities);
        
        return userDetail;
    }
}
