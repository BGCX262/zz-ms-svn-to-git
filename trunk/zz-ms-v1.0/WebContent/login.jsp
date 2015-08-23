<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>欢迎登录JZZMS &reg</title>
		<%@include file="/common/meta.jsp"%>
		<%@include file="/common/variable.jsp"%>
		<%@include file="/common/scripts.jsp"%>
		<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/appLogin.css" />
		<script type="text/javascript" src="${ctx }/app/spec/appLogin.js"></script>
	</head>
	<body>
		<div id="login-about" class="x-hidden" style='color: black; padding-left: 10px; padding-top: 10px; font-size: 12px'>
			JZZMS管理系统 (jzzms&reg)<br><br><br>
			官方网站:<a href="http://www.youthor.com" target="_blank">www.youthor.com</a>
		</div>
		<div id="login-info" class="x-hidden" style='color: black; padding-left: 10px; padding-top: 10px; font-size: 12px'>
			演示登录帐户 [企业代号/登录名/密码]...<br/><br/>
			--系统管理员 [youthor/admin/admin]<br/>
			--普通操作员 [youthor/user1/user1]<br/>
		</div>
	</body>
</html>