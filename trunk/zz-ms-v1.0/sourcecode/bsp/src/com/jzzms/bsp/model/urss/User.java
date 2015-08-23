package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class User extends Model {
	private static final long serialVersionUID = 1339081058921L;

	private Integer id;
	private String userName;
	private String password;
	private Integer comId;
	private Integer employeeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		entityMap.put("userName", userName);
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		entityMap.put("password", password);
		this.password = password;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		entityMap.put("comId", comId);
		this.comId = comId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		entityMap.put("employeeId", employeeId);
		this.employeeId = employeeId;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}