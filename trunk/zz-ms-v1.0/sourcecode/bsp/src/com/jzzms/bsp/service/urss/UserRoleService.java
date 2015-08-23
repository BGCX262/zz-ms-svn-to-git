package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.UserRoleMapper;
import com.jzzms.bsp.model.urss.UserRole;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class UserRoleService extends DefaultEntityService<UserRole, Integer> {

	@Autowired
	UserRoleMapper userRoleMapper;

	@Override
	protected Dao<UserRole, Integer> getDao() {
		return userRoleMapper;
	}

}
