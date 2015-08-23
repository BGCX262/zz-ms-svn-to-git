package com.jzzms.framework.view.action;

import com.jzzms.framework.core.Constants;
import com.jzzms.framework.orm.query.Page;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * Struts2中典型CRUD Action的抽象基类.
 * 
 * 主要定义了对Preparable,ModelDriven接口的使用,以及CRUD函数和返回值的命名.
 *
 *ActionSupport 基类提供了string input()、返回值为input 的函数，因此在此不需要进行声明input方法
 * @param <T> CRUDAction所管理的对象类型.
 * 
 * @author 
 */
public abstract class CrudActionSupport<T> extends SimpleActionSupport implements ModelDriven<T>, Preparable {
	private static final long serialVersionUID = -6780542633093121350L;
	
	protected Page<T> page;
	protected String pk;
	
	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	public String execute() throws Exception {
		String ret = list();
		setRequestAttribute(Constants.PAGEINFO_IN_REQUEST, getPage());
		return ret;
	}

	//-- CRUD Action函数 --//
	/**
	 * Action函数,显示Entity列表界面.
	 * return SUCCESS.
	 */
	public abstract String list() throws Exception;

	/**
	 * Action函数,新增或修改Entity. 
	 * return RELOAD.
	 */
	public abstract String save() throws Exception;

	/**
	 * Action函数,新增或修改Entity. 
	 * return RELOAD.
	 */
	public String view() throws Exception {
		input();
		return SUCCESS;
	}
	/**
	 * Action函数,删除Entity.
	 * return RELOAD.
	 */
	public abstract String delete() throws Exception;
	
	
	// Preparable函数 //
	/**
	 * 实现空的prepare()函数,屏蔽所有Action函数公共的二次绑定.
	 */
	public void prepare() throws Exception {
		
	}

	/**
	 * 在save()前执行二次绑定.
	 */
	public void prepareSave() throws Exception {
		prepareModel();
	}

	/**
	 * 在input()前执行二次绑定.
	 */
	public void prepareInput() throws Exception {
		prepareModel();
	}

	/**
	 * 等同于prepare()的内部函数,供prepardMethodName()函数调用. 
	 */
	protected abstract void prepareModel() throws Exception;
		
	/**
	 * 获取分页以及结果集
	 * @return
	 */
	public Page<T> getPage(){
		if(page == null){
			page = new Page<T>(Constants.DEFAULT_PAGE_SIZE);
			//设置分页的参数
			//page.setPageNum()
			page.setAutoPage(true);
			page.setAutoCount(false);
		}
		return page;
	}
}