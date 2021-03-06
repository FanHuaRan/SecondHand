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
<link rel="stylesheet" type="text/css" href="/ShSite/css/signin.css">
<link rel="stylesheet" type="text/css" href="/ShSite/css/site.css">
<title>校园二手交易系统</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	     <%@ include file="catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
		<form class="form-signin" role="form" name='f' action='/ShSite/j_spring_security_check' method='POST'>
        <p>如果您现在还没有账号请<a href="/ShSite/Account/Register">注册</a></p>
        <input type="text" class="form-control" placeholder="用户名"
        	   id="j_username" name="j_username" required autofocus>
        <input type="password" class="form-control" placeholder="密码" 
        	   id="j_password" name="j_password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me">记住密码
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>