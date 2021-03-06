<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
		<div class="table-responsive">
			<a href="/ShSite/Announcement/Create"><button type="button"  style="font-size:20px;" class="btn btn-xs btn-link">发布公告</button></a>
            <table class="table table-bordered" style="width:1100px;">
             <thead>
			    <tr>
			    	<th>公告编号</th>
			        <th>公告标题</th>
			        <th>公告内容</th>
			        <th>发布时间</th>
			        <th>用户操作</th>
			    </tr>
		     </thead>
		    <c:forEach items="${announcements}" var="announcement">
		    <tr>
		        <td>${announcement.getAnnouncementId()}</td>
		        <td>${announcement.getAnnounceTitle()}</td>
		        <td>${fn:length(announcement.getAnnoContent())>20?fn:substring(announcement.getAnnoContent(),0,19):announcement.getAnnoContent()}
			    ${fn:length(announcement.getAnnoContent())>20?'...':'' }</td>
		        <td>${announcement.getAnnoTime()}</td>
		        <td>
		        	<a href="/ShSite/Announcement/Details?id=${announcement.getAnnouncementId()}">详情</a>
		        	<a href="/ShSite/Announcement/Edit?id=${announcement.getAnnouncementId()}">编辑</a>
		        	<a href="/ShSite/Announcement/Delete?id=${announcement.getAnnouncementId()}">删除</a>
		        </td>
		   	 </tr>
			</c:forEach>
   		 </table>
   		 </div>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>