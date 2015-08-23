package com.jzzms.bsp.model.urss;

import java.io.Serializable;

import com.jzzms.framework.core.Model;

public class Function extends Model {
	private static final long serialVersionUID = 1339081058656L;

	private Integer id;
	private String name;
	private String url;
	private String smallImg;
	private String bigImg;
	private String funCode;
	private Integer orderIndex;
	private Integer appId;
	private Integer parentId;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		entityMap.put("url", url);
		this.url = url;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		entityMap.put("smallImg", smallImg);
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		entityMap.put("bigImg", bigImg);
		this.bigImg = bigImg;
	}

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		entityMap.put("funCode", funCode);
		this.funCode = funCode;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		entityMap.put("parentId", parentId);
		this.parentId = parentId;
	}

	@Override
	public Serializable getPK() {
		return id;
	}
}