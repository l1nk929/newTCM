 <%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>TCM</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="çç¶è§èä¸»é¡µ">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  	<c:forEach items="${zzallList}" var="zzall">
  		  <a target="center" href="${pageContext.request.contextPath}/center.action?zzallid=${zzall.id}">${zzall.zhengzhuang_name}</a>
  			</p>
  	</c:forEach>
  	<c:if test="${pageVo.previous!=-1}">
  		  <a target="left" href="${pageContext.request.contextPath}/left.action?type=${pageVo.type}&page_no=${pageVo.previous}">上一页</a>
  	</c:if>
    <c:if test="${pageVo.next!=-1}">
  		  <a target="left" href="${pageContext.request.contextPath}/left.action?type=${pageVo.type}&page_no=${pageVo.next}">下一页</a>
  	</c:if>
  </body>
</html>
