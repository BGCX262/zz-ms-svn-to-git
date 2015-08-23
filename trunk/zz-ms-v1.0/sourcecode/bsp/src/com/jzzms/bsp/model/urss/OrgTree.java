package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class OrgTree extends Model {
	private static final long serialVersionUID = 1339081058734L;

	private Integer id;
	private String name;
	private Integer parentId;
	private Integer orgTypeId;
	private Integer comId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		entityMap.put("name", name);
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		entityMap.put("parentId", parentId);
		this.parentId = parentId;
	}

	public Integer getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		entityMap.put("orgTypeId", orgTypeId);
		this.orgTypeId = orgTypeId;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		entityMap.put("comId", comId);
		this.comId = comId;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}