<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ShSite/css/bootstrap.css">
<link rel="stylesheet" href="/ShSite/css/bootstrapValidator.css"/>
<link rel="stylesheet" type="text/css" href="/ShSite/css/bootstrap-theme.css">
<script src="/ShSite/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/ShSite/js/bootstrap.js"	type="text/javascript"></script>
<script type="text/javascript" src="/ShSite/js/bootstrapValidator.js"></script>
<link rel="stylesheet" type="text/css" href="/ShSite/css/site.css">
<title>校园二手交易系统</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	    <%@ include file="../catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
		<h3></h3>
		<div>
		    <dl class="dl-horizontal">
		        <dt>用户编号:</dt>
		        <dd>${shuser.getShUserId()}</dd>
		        
		        <dt>用户名：</dt>
		        <dd>${shuser.getShUserName()}</dd>
		        
		        <dt>性别</dt>
		        <c:if test="${shuser.getGender()==0}">
			     <dd>男</dd>
				</c:if>
				<c:if test="${shuser.getGender()==1}">
			     <dd>女</dd>
				</c:if>
				
		        <dt>联系电话:</dt>
		        <dd>${shuser.getPhone()}</dd>
		        
		        <dt>地址：</dt>
		        <dd>${shuser.getAddress()}</dd>
		    </dl>
		    </div>
		    <p>
		    <a href="/ShSite/UserManager/Edit?id=${shuser.getShUserId()}">编辑</a>
		    <a href="/ShSite/UserManager">返回管理主页</a>
			</p>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>