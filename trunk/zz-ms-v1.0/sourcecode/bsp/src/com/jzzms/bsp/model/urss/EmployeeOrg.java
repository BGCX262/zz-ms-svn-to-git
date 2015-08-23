package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class EmployeeOrg extends Model {
	private static final long serialVersionUID = 1339081058625L;
	private Integer id;
	private Integer orgId;
	private Integer employeeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		entityMap.put("orgId", orgId);
		this.orgId = orgId;
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