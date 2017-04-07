<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
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
<style type="text/css">
dt{
 width:20px;
}
</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	    <%@ include file="../catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
			<h3></h3>
			<p>你确定删除该商品吗？</p>
			<dl class="dl-horizontal">
			    	<dt>商品编号</dt>
			        <dd>${good.getGoodId()}</dd>
			    	<dt>商品名称</dt>
			    	<dd>${good.getGoodName()}</dd>
			        <dt>发布用户</dt>
			        <dd>${good.getShuser().getShUserName()}</dd>
			        <dt>商品类型</dt>
			         <dd>${good.getGoodtype().getGoodTypeName()}</dd>
			        <dt>商品价格</dt>
			         <dd>${good.getGoodPrice()}</dd>
			        <dt>是否已交易</dt>
			         <c:if test="${good.getIsSell()==0}">
			       		 <dd>未售</dd>
					</c:if>
					 <c:if test="${good.getIsSell()==1}">
			       		 <dd>已售</dd>
					</c:if>
		    </dl>
		    <form action="/ShSite/GoodManager/Delete" method="POST">
		    	<input type="hidden" name="id" value="${good.getGoodId()}"/>
				<input type="submit" value="确定删除"/>
			</form>
		    <a href="/ShiSite/GoodManager/Edit?id=${announcement.getAnnouncementId()}">修改</a>
		     <a href="/ShiSite/GoodManager">返回商品管理主页</a>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>