package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class UserRole extends Model {
	private static final long serialVersionUID = 1339081058968L;

	private Integer id;
	private Integer userId;
	private Integer roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		entityMap.put("userId", userId);
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		entityMap.put("roleId", roleId);
		this.roleId = roleId;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}