package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.UserMapper;
import com.jzzms.bsp.model.urss.User;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class UserService extends DefaultEntityService<User, Integer> {

	@Autowired
	UserMapper userMapper;

	@Override
	protected Dao<User, Integer> getDao() {
		return userMapper;
	}

}
