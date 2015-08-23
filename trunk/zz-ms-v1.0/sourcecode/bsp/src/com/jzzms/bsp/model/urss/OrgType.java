package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class OrgType extends Model {
	private static final long serialVersionUID = 1339081058765L;

	private Integer id;
	private String code;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		entityMap.put("code", code);
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		entityMap.put("name", name);
		this.name = name;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}