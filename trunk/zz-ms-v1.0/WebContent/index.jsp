<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html">

<html>
	<head>
		<title>欢迎使用JZZMS &reg</title>
		<%@include file="/common/meta.jsp"%>
		<%@include file="/common/variable.jsp"%>
		<%@include file="/common/scripts.jsp"%>
		
		<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/appIndex.css" />
		<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/jzz.css" />
		<script type="text/javascript" src="${ctx }/app/spec/appIndex.js"></script>
		
		
	</head>
	
	
	
	<!--  onbeforeunload="return '确认要离开？';"-->
	<body oncontextmenu="return false">
		<div id="west" class="x-hide-display"></div>
		<div id="south" class="x-hide-display"></div>

		<div id="header" class="x-hide-display">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" height="60" background="${ctx}/resources/images/pages/titleLogo.jpg"> 
				<tr > 
					<td style="padding-left:15px">
						<img class="IEPNG" src="${ctx }/resources/images/pages/banner.png" /> 
					</td> 
					<td style="padding-right:5px"> 
			  			<table width="100%" border="0" cellpadding="0" cellspacing="3" class="banner"> 
						  	<tr align="right" height="25"> 
						      <td>上午好,超级用户! 今天是:2012-06-01 星期五</td> 
						    </tr> 
			   				<tr align="right"> 
			    				<td> 
			      					<table border="0" cellpadding="0" cellspacing="1"> 
			        					<tr> 
			        						<td><div id ="switchModuleDiv"></div></td> 
								        	<td>&nbsp;</td> 
									        <td><div id ="themeDiv"></div></td> 
									        <td>&nbsp;</td> 
									        <td><div id ="configDiv"></div></td> 
									        <td>&nbsp;</td> 
									        <td><div id ="closeDiv"></div></td> 
			        					</tr> 
			     					</table> 
			    				</td> 
			    			</tr> 
			  			</table> 
					</td> 
				</tr> 
			</table> 
		</div>
		
		<div id="footer" class="x-hide-display">
			<table class="banner" width="100%"> 
				<tr> 
					<td width="65%"><nobr>&nbsp;欢迎您,超级用户!&nbsp;帐户:super&nbsp;所属部门:&nbsp;Admin</nobr></td> 
					<td width="35%"><div align="right"><nobr>Copyright &copy 2012 youthor.com 中国.上海</nobr></div></td> 
				</tr> 
			</table> 
		</div>
	</body>
</html>