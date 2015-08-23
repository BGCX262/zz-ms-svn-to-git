package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.EmployeeOrgMapper;
import com.jzzms.bsp.model.urss.EmployeeOrg;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class EmployeeOrgService extends
		DefaultEntityService<EmployeeOrg, Integer> {

	@Autowired
	EmployeeOrgMapper employeeOrgMapper;

	@Override
	protected Dao<EmployeeOrg, Integer> getDao() {
		return employeeOrgMapper;
	}

}
