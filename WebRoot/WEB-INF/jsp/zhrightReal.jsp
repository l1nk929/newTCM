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
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.cxselect.js"></script>
  </head>
  
  <body>
  <h3>已有特征</h3>
    	<c:forEach items="${zhattrallVoList}" var="zhattrallListVo">
  			<c:forEach items="${zhattrallListVo.parents}" var="zhattrall">
  				${zhattrall.zhattr_name}>>
  			</c:forEach>
  			${zhattrallListVo.now.zhattr_name}
  			
  			<a href="${pageContext.request.contextPath}/deleteZhattrall.action?zhguifanid=${zhguifanZhattrVo.id}&zhattrid=${zhattrallListVo.now.id}" onclick="return confirm('确定将此记录删除?')">删除</a> 
  			</p>
  	</c:forEach>
    	
    	
    	
    	
    	
    	
    	
    	</p>
    	
    	
    	
    	
    	
    	
    	
    	
    	 <h3>绑定特征</h3>
    	
    	
 <form action="${pageContext.request.contextPath}/bindZhattrall.action" method="post">
    	
 <div id="element_id"> 
  <select class="level-1" name="bl1">
  </select> 
  <select class="level-2" name="bl2">
  </select> 
  <select class="level-3" name="bl3">
  </select>
  <select class="level-4" name="bl4">
  </select> 
   <select class="level-5" name="bl5">
  </select> 
   <select class="level-6" name="bl6">
  </select> 
   <select class="level-7" name="bl7">
  </select> 
  
</div> 
  </p>
 <input type="hidden" name="zhguifanid" value="${zhguifanZhattrVo.id}">
  添加特征:<input name="zhattr_name" type="text">
  <select name="level">
 	<option value="1">第一特征</option>
 	<option value="2">第二特征</option>
 	<option value="3">第三特征</option>
 	<option value="4">第四特征</option>
 	<option value="5">第五特征</option>
 	<option value="6">第六特征</option>
 	<option value="7">第七特征</option>
  </select> 
  </p>
 <select name="action">
 	<option value="1">绑定特征</option>
 	<option value="2">添加特征</option>
  </select> 
    	</p>
    	
    	<input type="submit" value="提交操作">
    	</form>
    	
    	
   
  </body>
<script type="text/javascript">
$('#element_id').cxSelect({ 
  selects: ['level-1', 'level-2', 'level-3', 'level-4', 'level-5','level-6','level-7'], 
  jsonName: 'zhattr_name', 
  jsonValue: 'code',
  jsonSub: 'sub',
  firstValue:0,
  url: '${pageContext.request.contextPath}/requestZhattrJson.action'
}); 
  </script>
</html>
