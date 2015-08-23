package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Resource extends Model {
	private static final long serialVersionUID = 1339081058843L;

	private Integer id;
	private Integer funId;
	private String name;
	private String code;
	private String isButton;
	private String buttonId;
	private String implJs;
	private String implUrl;
	private String groupName;
	private String isOrg;
	private String isLinkAssign;
	private String linkAssignValue;
	private String buttonStyle;
	private Integer orderIndex;
	private Integer appId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		entityMap.put("id", id);
		this.id = id;
	}

	public Integer getFunId() {
		return funId;
	}

	public void setFunId(Integer funId) {
		entityMap.put("funId", funId);
		this.funId = funId;
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

	public String getIsButton() {
		return isButton;
	}

	public void setIsButton(String isButton) {
		entityMap.put("isButton", isButton);
		this.isButton = isButton;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		entityMap.put("buttonId", buttonId);
		this.buttonId = buttonId;
	}

	public String getImplJs() {
		return implJs;
	}

	public void setImplJs(String implJs) {
		entityMap.put("implJs", implJs);
		this.implJs = implJs;
	}

	public String getImplUrl() {
		return implUrl;
	}

	public void setImplUrl(String implUrl) {
		entityMap.put("implUrl", implUrl);
		this.implUrl = implUrl;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		entityMap.put("groupName", groupName);
		this.groupName = groupName;
	}

	public String getIsOrg() {
		return isOrg;
	}

	public void setIsOrg(String isOrg) {
		entityMap.put("isOrg", isOrg);
		this.isOrg = isOrg;
	}

	public String getIsLinkAssign() {
		return isLinkAssign;
	}

	public void setIsLinkAssign(String isLinkAssign) {
		entityMap.put("isLinkAssign", isLinkAssign);
		this.isLinkAssign = isLinkAssign;
	}

	public String getLinkAssignValue() {
		return linkAssignValue;
	}

	public void setLinkAssignValue(String linkAssignValue) {
		entityMap.put("linkAssignValue", linkAssignValue);
		this.linkAssignValue = linkAssignValue;
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		entityMap.put("buttonStyle", buttonStyle);
		this.buttonStyle = buttonStyle;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		entityMap.put("orderIndex", orderIndex);
		this.orderIndex = orderIndex;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		entityMap.put("appId", appId);
		this.appId = appId;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}