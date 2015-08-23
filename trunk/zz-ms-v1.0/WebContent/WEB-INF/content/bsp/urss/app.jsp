<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<% System.out.println("我是默认的成功页面-----"); %>
{"statusCode":"${statusCode eq null ? "200" : statusCode}", "message":"${message}" <c:if test="${navTabId != null}">,"navTabId":"${navTabId}"</c:if> <c:if test="${callbackType != null}">,"callbackType":"${callbackType}"</c:if> <c:if test="${forwardUrl != null}">,"forwardUrl":"${forwardUrl}"</c:if> <c:if test="${rel != null}">,"rel":"${rel}"</c:if>}