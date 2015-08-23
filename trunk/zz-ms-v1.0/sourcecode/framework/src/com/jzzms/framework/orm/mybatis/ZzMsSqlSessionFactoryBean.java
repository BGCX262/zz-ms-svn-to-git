/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-26 下午02:43:08
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-26        Initailized
 */

package com.jzzms.framework.orm.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;

import com.jzzms.framework.orm.dialect.Dialect;
import com.jzzms.framework.orm.dialect.OracleDialect;

/**
 * OECS的SqlSessionFactoryBean
 * 
 * 添加了分页查询和行数总计
 */
public class ZzMsSqlSessionFactoryBean extends SqlSessionFactoryBean {
    
    // 需要被注入的值
    private String dialectClass = "com.jzzms.framework.orm.dialect.MySQLDialect";
    
    private Dialect dialect = new OracleDialect();
    
    /**
     * @param dialectValue
     *            the dialectValue to set
     */
    public void setDialectClass(String dialectClass) {
        this.dialectClass = dialectClass;
        
        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } 
        catch (Exception e) {
            throw new IllegalArgumentException(dialectClass +" : can not init!");
        }
    }
    
    public String getDialectClass(){
        return dialectClass;
    }
    
    public Dialect getDialect(){
        return dialect;
    }
}
