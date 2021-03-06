<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
			<p>你确定删除该公告？</p>
			<dl class="dl-horizontal">
		        <dt>公告编号:</dt>
		        <dd>${announcement.getAnnouncementId()}</dd>
		        
		        <dt>公告标题：</dt>
		        <dd>${announcement.getAnnounceTitle()}</dd>
		        
		        <dt>公告内容：</dt>
		        <dd>${fn:length(announcement.getAnnoContent())>20?fn:substring(announcement.getAnnoContent(),0,19):announcement.getAnnoContent()}
					${fn:length(announcement.getAnnoContent())>20?'...':'' }
		        <dt>发布时间:</dt>
		        <dd>${announcement.getAnnoTime()}</dd>
		    </dl>
		    <form action="/ShSite/Announcement/DeleteConfirm" method="post">
		    	<input type="hidden" name="id" value="${announcement.getAnnouncementId()}" /> 
				<input type="submit" value="确定删除"/>
			</form>
		    <a href="/ShiSite/Announcement/Edit?id=${announcement.getAnnouncementId()}">修改</a>
		     <a href="/ShiSite/Announcement">返回公告主页</a>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>