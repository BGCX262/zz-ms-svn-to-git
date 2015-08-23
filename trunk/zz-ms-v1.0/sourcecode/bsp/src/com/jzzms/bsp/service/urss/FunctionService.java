package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.FunctionMapper;
import com.jzzms.bsp.model.urss.Function;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class FunctionService extends DefaultEntityService<Function, Integer> {

	@Autowired
	FunctionMapper functionMapper;

	@Override
	protected Dao<Function, Integer> getDao() {
		return functionMapper;
	}

}
