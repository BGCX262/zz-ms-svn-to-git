package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.OrgTreeMapper;
import com.jzzms.bsp.model.urss.OrgTree;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class OrgTreeService extends DefaultEntityService<OrgTree, Integer> {

	@Autowired
	OrgTreeMapper orgTreeMapper;

	@Override
	protected Dao<OrgTree, Integer> getDao() {
		return orgTreeMapper;
	}

}
