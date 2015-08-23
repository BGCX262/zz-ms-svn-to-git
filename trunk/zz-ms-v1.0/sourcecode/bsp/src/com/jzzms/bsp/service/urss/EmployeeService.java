package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.EmployeeMapper;
import com.jzzms.bsp.model.urss.Employee;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class EmployeeService extends DefaultEntityService<Employee, Integer> {

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	protected Dao<Employee, Integer> getDao() {
		return employeeMapper;
	}

}
