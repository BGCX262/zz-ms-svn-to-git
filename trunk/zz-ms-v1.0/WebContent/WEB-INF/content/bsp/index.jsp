<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<%
	System.out.println("I am here index------------");
	String appCode = request.getParameter("request");
	String moduleId = request.getParameter("moduleId");
	System.out.println("appCode : " + appCode + ", moduleId: "
			+ moduleId);
%>

{
	success:true,data:[
		{id:1,text:'我的办公桌',leaf:false,
			children:[
				{id:3,text:'二级(1)',leaf:true,url:'/online.jsp','iconCls':'nav'},
				{id:4,text:'二级(2)',leaf:true,url:'/online.jsp','iconCls':'nav'},
				{id:5,text:'二级(3)',leaf:true,url:'/online.jsp','iconCls':'nav'},
				{id:6,text:'二级(4)',leaf:false,
					children:[
						{id:7,text:'三级(1)',leaf:true,url:'/online.jsp','iconCls':'nav'},
						{id:8,text:'三级(2)',leaf:true,url:'/online.jsp','iconCls':'nav'}
					]
				}
			]
		},
		{id:2,text:'系统管理',leaf:false,
			children:[
				{id:9,text:'用户管理',leaf:true,url:'/online.jsp','iconCls':'nav'}
			]
		}
	]
}
