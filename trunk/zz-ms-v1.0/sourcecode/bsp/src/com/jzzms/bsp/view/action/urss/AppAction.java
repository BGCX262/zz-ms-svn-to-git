package com.jzzms.bsp.view.action.urss;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzzms.bsp.model.urss.App;
import com.jzzms.bsp.service.urss.AppService;
import com.jzzms.framework.orm.query.PropertyFilter;
import com.jzzms.framework.util.common.PropertyFilterUtils;
import com.jzzms.framework.util.lang.NumberUtils;
import com.jzzms.framework.view.action.CrudActionSupport;
import com.jzzms.framework.view.action.SimpleActionSupport;

@Namespace("/bsp/urss")
@Results( { @Result(name = SimpleActionSupport.RELOAD, location = "app.action", type = "redirect") })
public class AppAction extends CrudActionSupport<App> {
	private static final long serialVersionUID = 1339148105687L;
	
	@Autowired
	private AppService appService; 
	
	// 基本属性
	private App entity;
		
	public String list() throws Exception {
		log.debug("list-------------");
		
		List<PropertyFilter> filters = PropertyFilterUtils.buildPropertyFilters(request);
		page = appService.search(getPage(), filters);
		return LIST;
	}
	
	public String save() throws Exception {
		log.debug("save-------------");
		
		if(StringUtils.isBlank(pk)){
			appService.save(entity);
		}
		else{
			appService.update(entity);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		log.debug("delete, pk :" + pk + "-------------");
		
		if(StringUtils.isNotBlank(pk)){
			appService.delete(NumberUtils.StringToInteger(pk));
		}
		
		return SUCCESS;
	}
	
	protected void prepareModel() throws Exception {
		if (StringUtils.isNotBlank(pk)) {
			entity = appService.get(NumberUtils.StringToInteger(pk));
		} 
		else {
			entity = new App();
		}
	}
	
	public App getModel() {
		return entity;
	}

	public App getEntity() {
		return entity;
	}

	public void setEntity(App entity) {
		this.entity = entity;
	}
}
