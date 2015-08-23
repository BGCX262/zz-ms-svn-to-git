package com.jzzms.bsp.view.action.urss;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzzms.bsp.model.urss.Company;
import com.jzzms.bsp.service.urss.CompanyService;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.util.common.PropertyFilterUtils;
import com.jzzms.framework.util.lang.NumberUtils;
import com.jzzms.framework.view.action.CrudActionSupport;
import com.jzzms.framework.view.action.SimpleActionSupport;
 
@Namespace("/urss")
@Results( { @Result(name = SimpleActionSupport.RELOAD, location = "Company.action", type = "redirect") })
public class CompanyAction extends CrudActionSupport<Company> {
	private static final long serialVersionUID = 1339148105750L;
	
	@Autowired(required=false)
	private CompanyService companyService; 
	
	// 基本属性
	private Company entity;
	
	public String list() throws Exception {
		log.debug("list-------------");
		
		List<PropertyFilter> filters = PropertyFilterUtils.buildPropertyFilters(request);
		page = companyService.search(getPage(), filters);
		return SUCCESS;
	}
	
	public String save() throws Exception {
		log.debug("save-------------");
		
		if(StringUtils.isBlank(pk)){
			companyService.save(entity);
		}
		else{
			companyService.update(entity);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		log.debug("delete, pk :" + pk + "-------------");
		
		if(StringUtils.isNotBlank(pk)){
			companyService.delete(NumberUtils.StringToInteger(pk));
		}
		
		return SUCCESS;
	}
	
	protected void prepareModel() throws Exception {
		if (StringUtils.isNotBlank(pk)) {
			entity = companyService.get(NumberUtils.StringToInteger(pk));
		} 
		else {
			entity = new Company();
		}
	}
	
	public Company getModel() {
		return entity;
	}

	public Company getEntity() {
		return entity;
	}

	public void setEntity(Company entity) {
		this.entity = entity;
	}
}
