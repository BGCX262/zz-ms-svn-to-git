package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Permission extends Model {
	private static final long serialVersionUID = 1339081058812L;

	private Integer id;
	private String resId;
	private String funId;
	private String appId;
	private Integer memberId;
	private String memberType;
	private String orgIds;
	private String orgType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		entityMap.put("resId", resId);
		this.resId = resId;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		entityMap.put("funId", funId);
		this.funId = funId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		entityMap.put("appId", appId);
		this.appId = appId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		entityMap.put("memberId", memberId);
		this.memberId = memberId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		entityMap.put("memberType", memberType);
		this.memberType = memberType;
	}

	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		entityMap.put("orgIds", orgIds);
		this.orgIds = orgIds;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		entityMap.put("orgType", orgType);
		this.orgType = orgType;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}