<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理后台系统主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h3>商品管理后台系统主页</h3><br>
    当前用户为:${sessionScope.userName}
    <hr/>
    <a href="${pageContext.request.contextPath}/product/add.jsp">商品增加</a><br>
    <a href="${pageContext.request.contextPath}/product/update.jsp">商品修改</a><br>
    <a href="${pageContext.request.contextPath}/product/list.jsp">商品列表</a><br>
  </body>
</html>
