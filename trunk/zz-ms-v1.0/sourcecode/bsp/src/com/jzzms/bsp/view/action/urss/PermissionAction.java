package com.jzzms.bsp.view.action.urss;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzzms.bsp.model.urss.Permission;
import com.jzzms.bsp.service.urss.PermissionService;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.util.common.PropertyFilterUtils;
import com.jzzms.framework.util.lang.NumberUtils;
import com.jzzms.framework.view.action.CrudActionSupport;
import com.jzzms.framework.view.action.SimpleActionSupport;
 
@Namespace("/urss")
@Results( { @Result(name = SimpleActionSupport.RELOAD, location = "Permission.action", type = "redirect") })
public class PermissionAction extends CrudActionSupport<Permission> {
	private static final long serialVersionUID = 1339148106140L;
	
	@Autowired(required=false)
	private PermissionService permissionService; 
	
	// 基本属性
	private Permission entity;
	
	public String list() throws Exception {
		log.debug("list-------------");
		
		List<PropertyFilter> filters = PropertyFilterUtils.buildPropertyFilters(request);
		page = permissionService.search(getPage(), filters);
		return SUCCESS;
	}
	
	public String save() throws Exception {
		log.debug("save-------------");
		
		//UserDetailsImpl oper = (UserDetailsImpl)session.get(Constants.CUR_USER_DETAIL_IN_SESSION);
		if(StringUtils.isBlank(pk)){
			permissionService.save(entity);
		}
		else{
			permissionService.update(entity);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		log.debug("delete, pk :" + pk + "-------------");
		
		//UserDetailsImpl oper = (UserDetailsImpl)session.get(Constants.CUR_USER_DETAIL_IN_SESSION);
		if(StringUtils.isNotBlank(pk)){
			permissionService.delete(NumberUtils.StringToInteger(pk));
		}
		
		return SUCCESS;
	}
	
	protected void prepareModel() throws Exception {
		if (StringUtils.isNotBlank(pk)) {
			entity = permissionService.get(NumberUtils.StringToInteger(pk));
		} 
		else {
			entity = new Permission();
		}
	}
	
	public Permission getModel() {
		return entity;
	}

	public Permission getEntity() {
		return entity;
	}

	public void setEntity(Permission entity) {
		this.entity = entity;
	}

}
