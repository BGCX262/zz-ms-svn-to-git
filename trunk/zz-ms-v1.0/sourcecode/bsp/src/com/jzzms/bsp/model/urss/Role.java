package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Role extends Model {
	private static final long serialVersionUID = 1339081058890L;

	private Integer id;
	private Integer appId;
	private String code;
	private String name;
	private Integer comId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		entityMap.put("appId", appId);
		this.appId = appId;
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