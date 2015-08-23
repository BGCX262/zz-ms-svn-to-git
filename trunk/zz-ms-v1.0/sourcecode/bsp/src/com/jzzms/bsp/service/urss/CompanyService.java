package com.jzzms.bsp.service.urss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.urss.CompanyMapper;
import com.jzzms.bsp.model.urss.Company;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

@Service
@Transactional
public class CompanyService extends DefaultEntityService<Company, Integer> {

	@Autowired
	CompanyMapper companyMapper;

	@Override
	protected Dao<Company, Integer> getDao() {
		return companyMapper;
	}

}
