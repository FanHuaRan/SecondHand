<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShSite/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/ShSite/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="/ShSite/css/site.css">
<script src="/ShSite/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/ShSite/js/bootstrap.js"></script>
</style>
<title>校园二手交易系统</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	     <%@ include file="catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
			 <h2>账号注册</h2>
		<form:form action="/ShSite/Account/Register"
		 		   modelAttribute="shuser" method="post">
			 <div>
		        <fieldset>
		            <legend>请在下面按照输入信息</legend>
		            <div class="editor-label">用户名:</div>
		            <div class="editor-field">
		                <input type='text' name='j_username' value=''/>
		            </div>
		
		            <div class="editor-label">密码:</div>
		            <div class="editor-field">
		               <input type='password' name='j_password'/>
		            </div>
		            <p>
		                <input name="submit"  class="btn btn-primary" type="submit" value="登录"/>
		            </p>
		        </fieldset>
    		</div>
		</form:form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>