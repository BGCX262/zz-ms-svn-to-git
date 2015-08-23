package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.OrgDetailMapper;
import com.jzzms.bsp.model.urss.OrgDetail;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class OrgDetailService extends DefaultEntityService<OrgDetail, Integer> {

	@Autowired
	OrgDetailMapper orgDetailMapper;

	@Override
	protected Dao<OrgDetail, Integer> getDao() {
		return orgDetailMapper;
	}

}
