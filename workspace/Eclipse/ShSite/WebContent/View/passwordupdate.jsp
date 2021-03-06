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
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	     <%@ include file="catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
		  <div style="margin-top:20px">
		  	<h3>密码修改</h3>
		  </div>
		  <form 	  method="post" action="/ShSite/Account/PasswordUpdate" 
		  			  id="defaultForm" class="form-horizontal"
                      data-bv-message="This value is not valid"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                   
                    <div class="form-group">
                        <label class="col-lg-3 control-label">原始密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="oldPassword"
                                   required data-bv-notempty-message="原始密码不能够为空"
                                   data-bv-remote="true" data-bv-remote-url="/ShSite/Account/CheckOldPassword" data-bv-remote-message="原始密码不正确">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-lg-3 control-label">密码</label>
                        <div class="col-lg-5">
                            <input path="Password" type="password" class="form-control" name="Password"
                                   required data-bv-notempty-message="密码不能够为空"
                                   data-bv-stringlength="true" data-bv-stringlength-min="8" data-bv-stringlength-max="20" data-bv-stringlength-message="密码必须保证在8到20个字符"
                                   data-bv-identical="true" data-bv-identical-field="confirmPassword" data-bv-identical-message="密码必须一致">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">确认密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="confirmPassword"
                                   required data-bv-notempty-message="确认密码不能够为空"
                                   data-bv-identical="true" data-bv-identical-field="Password" data-bv-identical-message="密码必须一致">
                        </div>
                    </div>

                  
                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <button type="submit" class="btn btn-primary">确认修改</button>
                        </div>
                    </div>
                </form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator();
});
</script>
</html>