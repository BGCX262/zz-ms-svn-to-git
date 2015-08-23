package com.jzzms.framework.view.action;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class SimpleActionSupport extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = -6780542633093121352L;
	protected Log log = LogFactory.getLog(getClass());

	protected Map<String, Object> request = new HashMap<String, Object>();
	protected Map<String, Object> session = new HashMap<String, Object>();

	/** 进行增删改操作后,以redirect方式重新打开action默认页的result名.*/
	public static final String RELOAD = "reload";
	public static final String LIST = "list";
	
	protected boolean flag;

	//--  简化分页 --//
	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	
	public abstract String execute() throws Exception;
	
	public  Object getSessionAttribute(String key) {
		 if(session.containsKey(key)) {
		     return session.get(key);
		 }
		 
		 return null;
	}

	public void setRequestAttribute(String key, Object object) {
	    if(request.containsKey(key)) {
	        request.remove(key);
	        request.put(key, object);
        } else {
            request.put(key, object);
        }
	}

	/**
	 * 设置HttpSession中Attribute的简化函数.
	 */
	public  void setSessionAttribute(String key, Object object) {
	    if(session.containsKey(key)) {
	        session.remove(key);
	        session.put(key, object);
        } else {
            session.put(key, object);
        }
	}

	public void setSession(Map<String, Object> arg0) {
		if(arg0 != null && arg0.size() > 0){
			session.putAll(arg0);
		}
		
	}

	public void setRequest(Map<String, Object> arg0) {
		if(arg0 != null && arg0.size() > 0){
			request.putAll(arg0);
		}
	}
}