/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-9-5 下午01:55:46
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-9-5        Initailized
 */

package com.jzzms.framework.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * 从数据库里读取配置 
 * 实现参考http://forum.springsource.org/showthread.php?t=57246 
 *
 */
public class DatabaseProperties extends Properties implements InitializingBean, FactoryBean<Properties> {  
    private static final long serialVersionUID = -4936201138182312441L;
    private static final Log log = LogFactory.getLog(DatabaseProperties.class);  
    private DataSource datasource;  //数据源  
    private String query;           //读取的sql  
  
    public DatabaseProperties(DataSource datasource, String query) {  
        this.datasource = datasource;  
        this.query = query;  
    }  
  
    public void afterPropertiesSet() throws Exception {  
        initProperties();  
    }  
  
    public Properties getObject() throws Exception {  
        return this;  
    }  
  
    public Class<?> getObjectType() {  
        return Properties.class;  
    }  
  
    public boolean isSingleton() {  
        return true;  
    }  
  
    //初始化
    private void initProperties() {  
        Connection connection = null;  
        try {  
            connection = datasource.getConnection();  
            PreparedStatement ps = connection.prepareStatement(query);  
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {  
                String key = rs.getString(1);  
                String value = rs.getString(2);  
                if (key != null && value != null) {  
                    log.info("load property. Key=" + key + ",Value=" + value);  
                    this.setProperty(key, value);  
                }  
            }  
            rs.close();  
            ps.close();  
        } 
        catch (Exception e) {  
            log.error(e);  
        } finally {  
            if (connection != null) {  
                try {  
                    connection.close();  
                } catch (Exception e) {  
                    log.error(e);  
                }  
            }  
        }  
    }  
}
