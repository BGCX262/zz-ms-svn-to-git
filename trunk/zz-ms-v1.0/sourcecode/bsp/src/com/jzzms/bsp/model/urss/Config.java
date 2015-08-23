package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Config extends Model {
	private static final long serialVersionUID = 1339081058531L;

	private String code;
	private String value;
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		entityMap.put("code", code);
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		entityMap.put("value", value);
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		entityMap.put("status", status);
		this.status = status;
	}

	@Override
	public Serializable getPK() {
		return code;
	}
}