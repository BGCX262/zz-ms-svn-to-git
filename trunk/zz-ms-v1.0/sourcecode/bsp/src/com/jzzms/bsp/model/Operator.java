package com.jzzms.bsp.model;

import java.io.Serializable;
import java.util.Date;

import com.jzzms.framework.core.Model;

public class Operator extends Model{
    private static final long serialVersionUID = 2329473050715789906L;

    private Long id;

    private Long orgId;

    private String realName;

    private String loginName;

    private String loginPwd;

    private Long successTimes;

    private Long failTimes;

    private Date lastLoginTime;

    private Date lastLoginFailTime;

    private Date curLoginTime;

    private String lastLoginAddr;

    private String curLoginAddr;

    private String miscDesc;

    private String status;

    private Date createTime;

    private Long createOperId;

    private String createOperName;

    private Date updateTime;

    private Long updateOperId;

    private String updateOperName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
	    entityMap.put("orgId", orgId);
		this.orgId = orgId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
	    entityMap.put("realName", realName);
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
	    entityMap.put("loginName", loginName);
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
	    entityMap.put("loginPwd", loginPwd);
		this.loginPwd = loginPwd;
	}

	public Long getSuccessTimes() {
		return successTimes;
	}

	public void setSuccessTimes(Long successTimes) {
	    entityMap.put("successTimes", successTimes);
		this.successTimes = successTimes;
	}

	public Long getFailTimes() {
		return failTimes;
	}

	public void setFailTimes(Long failTimes) {
	    entityMap.put("failTimes", failTimes);
		this.failTimes = failTimes;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
	    entityMap.put("lastLoginTime", lastLoginTime);
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginFailTime() {
		return lastLoginFailTime;
	}

	public void setLastLoginFailTime(Date lastLoginFailTime) {
	    entityMap.put("lastLoginFailTime", lastLoginFailTime);
		this.lastLoginFailTime = lastLoginFailTime;
	}

	public Date getCurLoginTime() {
		return curLoginTime;
	}

	public void setCurLoginTime(Date curLoginTime) {
	    entityMap.put("curLoginTime", curLoginTime);
		this.curLoginTime = curLoginTime;
	}

	public String getLastLoginAddr() {
		return lastLoginAddr;
	}

	public void setLastLoginAddr(String lastLoginAddr) {
	       entityMap.put("lastLoginAddr", lastLoginAddr);
		this.lastLoginAddr = lastLoginAddr;
	}

	public String getCurLoginAddr() {
		return curLoginAddr;
	}

	public void setCurLoginAddr(String curLoginAddr) {
	    entityMap.put("curLoginAddr", curLoginAddr);
		this.curLoginAddr = curLoginAddr;
	}

	public String getMiscDesc() {
		return miscDesc;
	}

	public void setMiscDesc(String miscDesc) {
	    entityMap.put("miscDesc", miscDesc);
		this.miscDesc = miscDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
	    entityMap.put("status", status);
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
	    entityMap.put("createTime", createTime);
		this.createTime = createTime;
	}

	public Long getCreateOperId() {
		return createOperId;
	}

	public void setCreateOperId(Long createOperId) {
	    entityMap.put("createOperId", createOperId);
		this.createOperId = createOperId;
	}

	public String getCreateOperName() {
		return createOperName;
	}

	public void setCreateOperName(String createOperName) {
	    entityMap.put("createOperName", createOperName);
		this.createOperName = createOperName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
	    entityMap.put("updateTime", updateTime);
		this.updateTime = updateTime;
	}

	public Long getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(Long updateOperId) {
	    entityMap.put("updateOperId", updateOperId);
		this.updateOperId = updateOperId;
	}

	public String getUpdateOperName() {
		return updateOperName;
	}

	public void setUpdateOperName(String updateOperName) {
	    entityMap.put("updateOperName", updateOperName);
		this.updateOperName = updateOperName;
	}

    @Override
    public String toString() {
        return "Operator [id="
                + id
                + ", orgId="
                + orgId
                + ", realName="
                + realName
                + ", loginName="
                + loginName
                + ", loginPwd="
                + loginPwd
                + ", successTimes="
                + successTimes
                + ", failTimes="
                + failTimes
                + ", lastLoginTime="
                + lastLoginTime
                + ", lastLoginFailTime="
                + lastLoginFailTime
                + ", curLoginTime="
                + curLoginTime
                + ", lastLoginAddr="
                + lastLoginAddr
                + ", curLoginAddr="
                + curLoginAddr
                + ", miscDesc="
                + miscDesc
                + ", status="
                + status
                + ", createTime="
                + createTime
                + ", createOperId="
                + createOperId
                + ", createOperName="
                + createOperName
                + ", updateTime="
                + updateTime
                + ", updateOperId="
                + updateOperId
                + ", updateOperName="
                + updateOperName
                + "]";
    }

    public Serializable getPK() {
        return id;
    }
}