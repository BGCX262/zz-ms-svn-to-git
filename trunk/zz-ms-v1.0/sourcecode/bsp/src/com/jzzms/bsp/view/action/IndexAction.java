package com.jzzms.bsp.view.action;

import org.apache.struts2.convention.annotation.Namespace;

import com.jzzms.framework.view.action.SimpleActionSupport;

@Namespace("/bsp")
public class IndexAction extends SimpleActionSupport {
	private static final long serialVersionUID = 4292294870924885076L;

	@Override
	public String execute() throws Exception {
		log.debug("execute ...");
		
		return null;
	}

	public String menu() throws Exception {
		log.debug("getMenu ...");
		
		String appCode = String.valueOf(request.get("request"));
		String moduleId = String.valueOf(request.get("moduleId"));
		log.debug("appCode : " + appCode + ", moduleId: " + moduleId);
		return SUCCESS;
	}
}
