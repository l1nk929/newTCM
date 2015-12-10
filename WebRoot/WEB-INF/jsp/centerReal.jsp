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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h3>症状:${zzallZzguifanVo.zhengzhuang_name}</h3>
  	<h3>来源:${source.source_name}</h3>
  	<h3>关联规范症状</h3>
  	<c:forEach items="${zzallZzguifanVo.list}" var="zzguifan">
  		  <a target="right" href="${pageContext.request.contextPath}/right.action?zzguifanid=${zzguifan.id}">${zzguifan.zhengzhuang_name}</a>
  		<a href="${pageContext.request.contextPath}/deleteZzguifan.action?zzallid=${zzallZzguifanVo.id}&zzguifanid=${zzguifan.id}" onclick="return confirm('确定将此记录删除?')">删除</a> 
  			</p>
  	</c:forEach>
  	
  	<h3>添加关联症状</h3>
  	 <form action="${pageContext.request.contextPath}/bindzzguifan.action" method="post">
  	 <input type="hidden" name="zzallid" value="${zzallZzguifanVo.id}">
  		 规范症状ID：<input type="text" name="zzid"></input>  </p>
    	规范症状：<input type="text" name="zzname"></input>  
    	
    	<input type="submit" value="绑定"></input>  
    </form>
    
    </p>
     <a  href="${pageContext.request.contextPath}/changeType.action?zzallid=${zzallZzguifanVo.id}&type=2" onclick="return confirm('确定已经完全处理?')">已处理</a>
  	<a  href="${pageContext.request.contextPath}/changeType.action?zzallid=${zzallZzguifanVo.id}&type=11" onclick="return confirm('确定已经完成部分关联?')">已完成部分关联</a>
  	<a  href="${pageContext.request.contextPath}/changeType.action?zzallid=${zzallZzguifanVo.id}&type=1" onclick="return confirm('确定已经完成全部关联?')">已完成全部关联</a>
  		<a  href="${pageContext.request.contextPath}/changeType.action?zzallid=${zzallZzguifanVo.id}&type=2002" onclick="return confirm('确定已经完成全部关联?')">紧急完成</a>
 	<a  href="${pageContext.request.contextPath}/changeType.action?zzallid=${zzallZzguifanVo.id}&type=2011" onclick="return confirm('确定已经完成全部关联?')">紧急待完成</a>
  </body>
</html>
