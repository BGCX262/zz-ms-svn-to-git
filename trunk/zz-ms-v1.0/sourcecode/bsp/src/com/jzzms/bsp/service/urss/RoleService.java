package com.jzzms.bsp.service.urss;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.RoleMapper;
import com.jzzms.bsp.model.urss.Role;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;


@Service
@Transactional
public class RoleService extends DefaultEntityService<Role, Integer>{
    
    @Autowired
    RoleMapper roleMapper;

    @Override
    protected Dao<Role, Integer> getDao() {
        return roleMapper;
    }
    
}
