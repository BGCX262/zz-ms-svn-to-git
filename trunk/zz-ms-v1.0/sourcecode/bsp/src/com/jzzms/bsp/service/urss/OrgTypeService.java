package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.OrgTypeMapper;
import com.jzzms.bsp.model.urss.OrgType;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class OrgTypeService extends DefaultEntityService<OrgType, Integer> {

	@Autowired
	OrgTypeMapper orgTypeMapper;

	@Override
	protected Dao<OrgType, Integer> getDao() {
		return orgTypeMapper;
	}

}
