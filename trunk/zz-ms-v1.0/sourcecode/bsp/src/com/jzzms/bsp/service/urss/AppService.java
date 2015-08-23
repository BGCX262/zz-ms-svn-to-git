package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.AppMapper;
import com.jzzms.bsp.model.urss.App;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class AppService extends DefaultEntityService<App, Integer> {

	@Autowired
	AppMapper appMapper;

	@Override
	protected Dao<App, Integer> getDao() {
		return appMapper;
	}

}
