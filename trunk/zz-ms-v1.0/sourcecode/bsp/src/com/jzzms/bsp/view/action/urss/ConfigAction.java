package com.jzzms.bsp.view.action.urss;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzzms.bsp.model.urss.Config;
import com.jzzms.bsp.service.urss.ConfigService;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.util.common.PropertyFilterUtils;
import com.jzzms.framework.view.action.CrudActionSupport;
import com.jzzms.framework.view.action.SimpleActionSupport;
 
@Namespace("/urss")
@Results( { @Result(name = SimpleActionSupport.RELOAD, location = "Config.action", type = "redirect") })
public class ConfigAction extends CrudActionSupport<Config> {
	private static final long serialVersionUID = 1339148105812L;
	
	@Autowired(required=false)
	private ConfigService configService; 
	
	// 基本属性
	private Config entity;
		
	public String list() throws Exception {
		log.debug("list-------------");
		
		List<PropertyFilter> filters = PropertyFilterUtils.buildPropertyFilters(request);
		page = configService.search(getPage(), filters);
		return SUCCESS;
	}
	
	public String save() throws Exception {
		log.debug("save-------------");
		
		//UserDetailsImpl oper = (UserDetailsImpl)session.get(Constants.CUR_USER_DETAIL_IN_SESSION);
		if(StringUtils.isBlank(pk)){
			configService.save(entity);
		}
		else{
			configService.update(entity);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		log.debug("delete, pk :" + pk + "-------------");
		
		if(StringUtils.isNotBlank(pk)){
			configService.delete(pk);
		}
		
		return SUCCESS;
	}
	
	protected void prepareModel() throws Exception {
		if (StringUtils.isNotBlank(pk)) {
			entity = configService.get(pk);
		} 
		else {
			entity = new Config();
		}
	}
	
	public Config getModel() {
		return entity;
	}

	public Config getEntity() {
		return entity;
	}

	public void setEntity(Config entity) {
		this.entity = entity;
	}
}
