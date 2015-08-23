/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-9-22 下午10:19:23
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-9-22        Initailized
 */

package com.jzzms.framework.util.common;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jzzms.framework.orm.query.ZzMsCriterion;
import com.jzzms.framework.orm.query.Page;
import com.jzzms.framework.orm.query.PropertyFilter;


/**
 * OecsCriterion 工具类
 *
 */
public class ZzMsCriterionUtils {
    
    private ZzMsCriterionUtils(){
        
    }
    
    public static ZzMsCriterion createOecsCriterion(Page<?> page, List<PropertyFilter> filters){
        ZzMsCriterion criterion = new ZzMsCriterion();
        
        //设置排序参数
        if(page.isOrderBySetted()){
            criterion.setOrderBy(page.getOrderField());
            criterion.setOrder(page.getOrderDirection());
        }
        //设置查询参数
        if(filters != null && filters.size() > 0){
            criterion.setCriteria(filters);
        }
        
        return criterion;
    }
    
    public static RowBounds createRowBounds(Page<?> page){
        RowBounds rowBounds = null;
        
        //设置分页参数
        if(page.isAutoPage()){
            int limit = (page.getPageNum() - 1) * page.getNumPerPage();
            rowBounds = new RowBounds(limit, page.getNumPerPage());
        }
        
        return rowBounds;
    }
}
