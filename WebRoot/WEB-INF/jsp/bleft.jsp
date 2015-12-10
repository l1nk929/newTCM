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
  	<h4>搜索症状</h4>
  	<form action="${pageContext.request.contextPath}/findZzguifan.action" method="post">
  		症状名:<input type="text" name="zhengzhuang_name">
  		<input type="submit" value="搜索">
  	</form>
  	<h4>列表</h4>
  	<c:forEach items="${zzguifanList}" var="zzguifan">
  		  ${zzguifan.id}. ${zzguifan.zhengzhuang_name};
  	</c:forEach>
  	
  	
  </body>
</html>
