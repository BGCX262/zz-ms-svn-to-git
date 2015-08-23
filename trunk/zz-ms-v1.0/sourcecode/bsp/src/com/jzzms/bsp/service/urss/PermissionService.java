package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.PermissionMapper;
import com.jzzms.bsp.model.urss.Permission;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class PermissionService extends
		DefaultEntityService<Permission, Integer> {

	@Autowired
	PermissionMapper permissionMapper;

	@Override
	protected Dao<Permission, Integer> getDao() {
		return permissionMapper;
	}

}
