package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Employee extends Model {
	private static final long serialVersionUID = 1339081058578L;

	private Integer id;
	private String name;
	private String code;
	private String email;
	private String mobile;
	private String telephone;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		entityMap.put("code", code);
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		entityMap.put("email", email);
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		entityMap.put("mobile", mobile);
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		entityMap.put("telephone", telephone);
		this.telephone = telephone;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}