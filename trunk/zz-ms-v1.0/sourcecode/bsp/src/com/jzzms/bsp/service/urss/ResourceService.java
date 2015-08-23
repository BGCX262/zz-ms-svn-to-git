package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.ResourceMapper;
import com.jzzms.bsp.model.urss.Resource;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class ResourceService extends DefaultEntityService<Resource, Integer> {

	@Autowired
	ResourceMapper resourceMapper;

	@Override
	protected Dao<Resource, Integer> getDao() {
		return resourceMapper;
	}

}
