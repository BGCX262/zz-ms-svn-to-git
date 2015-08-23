package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.ConfigMapper;
import com.jzzms.bsp.model.urss.Config;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class ConfigService extends DefaultEntityService<Config, String> {

	@Autowired
	ConfigMapper configMapper;

	@Override
	protected Dao<Config, String> getDao() {
		return configMapper;
	}

}
