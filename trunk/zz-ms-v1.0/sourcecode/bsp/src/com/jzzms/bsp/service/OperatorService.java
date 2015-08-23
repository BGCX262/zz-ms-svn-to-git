package com.jzzms.bsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzzms.bsp.dao.OperatorMapper;
import com.jzzms.bsp.model.Operator;
import com.jzzms.framework.dao.Dao;
import com.jzzms.framework.service.DefaultEntityService;

/**
 * 操作员Service
 *
 */
@Service
@Transactional
public class OperatorService extends DefaultEntityService<Operator, Long>{
    
    @Autowired
    OperatorMapper operatorMapper;

    protected Dao<Operator, Long> getDao() {
        return operatorMapper;
    }
    
}
