package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class OrgDetail extends Model {
	private static final long serialVersionUID = 1339081058703L;

	private Integer id;
	private Integer orgId;
	private String path;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		entityMap.put("orgId", orgId);
		this.orgId = orgId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		entityMap.put("path", path);
		this.path = path;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		entityMap.put("value", value);
		this.value = value;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}