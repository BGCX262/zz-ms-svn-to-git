package com.jzzms.bsp.model.urss;

import java.io.Serializable;
import java.util.Date;

import com.jzzms.framework.core.Model;

public class Company extends Model {
	private static final long serialVersionUID = 1339081058468L;

	private Integer id;
	private String comName;
	private String address;
	private String contactName;
	private String fax;
	private String zip;
	private String allowUser;
	private Date startTime;
	private Date endTime;
	private Date regTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		entityMap.put("comName", comName);
		this.comName = comName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		entityMap.put("address", address);
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		entityMap.put("contactName", contactName);
		this.contactName = contactName;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		entityMap.put("fax", fax);
		this.fax = fax;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		entityMap.put("zip", zip);
		this.zip = zip;
	}

	public String getAllowUser() {
		return allowUser;
	}

	public void setAllowUser(String allowUser) {
		entityMap.put("allowUser", allowUser);
		this.allowUser = allowUser;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		entityMap.put("startTime", startTime);
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		entityMap.put("endTime", endTime);
		this.endTime = endTime;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		entityMap.put("regTime", regTime);
		this.regTime = regTime;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}