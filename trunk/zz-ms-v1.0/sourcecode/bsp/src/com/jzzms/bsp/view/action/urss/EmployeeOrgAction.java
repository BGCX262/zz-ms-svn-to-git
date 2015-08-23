package com.jzzms.bsp.view.action.urss;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzzms.bsp.model.urss.EmployeeOrg;
import com.jzzms.bsp.service.urss.EmployeeOrgService;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.util.common.PropertyFilterUtils;
import com.jzzms.framework.util.lang.NumberUtils;
import com.jzzms.framework.view.action.CrudActionSupport;
import com.jzzms.framework.view.action.SimpleActionSupport;
 
@Namespace("/urss")
@Results( { @Result(name = SimpleActionSupport.RELOAD, location = "employeeOrg.action", type = "redirect") })
public class EmployeeOrgAction extends CrudActionSupport<EmployeeOrg> {
	private static final long serialVersionUID = 1339148105921L;
	
	@Autowired(required=false)
	private EmployeeOrgService employeeOrgService; 
	
	// 基本属性
	private EmployeeOrg entity;
	
	public String list() throws Exception {
		log.debug("list-------------");
		
		List<PropertyFilter> filters = PropertyFilterUtils.buildPropertyFilters(request);
		page = employeeOrgService.search(getPage(), filters);
		return SUCCESS;
	}
	
	public String save() throws Exception {
		log.debug("save-------------");
		
		//UserDetailsImpl oper = (UserDetailsImpl)session.get(Constants.CUR_USER_DETAIL_IN_SESSION);
		if(StringUtils.isBlank(pk)){
			employeeOrgService.save(entity);
		}
		else{
			employeeOrgService.update(entity);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		log.debug("delete, pk :" + pk + "-------------");
		
		//UserDetailsImpl oper = (UserDetailsImpl)session.get(Constants.CUR_USER_DETAIL_IN_SESSION);
		if(StringUtils.isNotBlank(pk)){
			employeeOrgService.delete(NumberUtils.StringToInteger(pk));
		}
		
		return SUCCESS;
	}
	
	protected void prepareModel() throws Exception {
		if (StringUtils.isNotBlank(pk)) {
			entity = employeeOrgService.get(NumberUtils.StringToInteger(pk));
		} 
		else {
			entity = new EmployeeOrg();
		}
	}
	
	public EmployeeOrg getModel() {
		return entity;
	}

	public EmployeeOrg getEntity() {
		return entity;
	}

	public void setEntity(EmployeeOrg entity) {
		this.entity = entity;
	}
}
