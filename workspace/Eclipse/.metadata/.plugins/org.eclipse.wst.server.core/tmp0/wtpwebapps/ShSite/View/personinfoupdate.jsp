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
		   <h3></h3>
		  <p><a href="/ShSite/Account/PasswordUpdate/${sessionScope.user.getShUserId()}"><button type="button" class="btn btn-sm btn-info">修改密码</button></p></a>
		
		  <form 	  method="post" action="/ShSite/Account/PersonInfoUpdate" enctype="multipart/form-data"
		  			  id="defaultForm" class="form-horizontal"
                      data-bv-message="This value is not valid"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                    <input type="hidden" name="Password" value="${shuser.getPassword()}"/>
                     <input type="hidden" name="ShUserId" value="${shuser.getShUserId()}"/>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">用户名</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="ShUserName" value="${shuser.getShUserName()}"
                                   data-bv-message="用户名无效"
                                   required data-bv-notempty-message="用户名不能为空"
                                   data-bv-stringlength="true" data-bv-stringlength-min="5" data-bv-stringlength-max="20" data-bv-stringlength-message="用户名必须保证在5到20个字符"/>
                        </div>
                    </div>
                 
                    <div class="form-group">
                        <label class="col-lg-3 control-label">性别</label>
                        <div class="col-lg-5">
                        	 <c:if test="${shuser.getGender()==0}">
                                <div class="radio">
                                <label><input type="radio" name="Gender" value="0" checked="checked" required data-bv-notempty-message="The gender is required" /> 男 </label>
	                            </div>
	                            <div class="radio">
	                                <label><input type="radio" name="Gender" value="1"/> 女</label>
	                            </div>
                             </c:if>
                             
                              <c:if test="${shuser.getGender()!=0}">
                                <div class="radio">
                                <label><input type="radio" name="Gender" value="0"  required data-bv-notempty-message="The gender is required" /> 男</label>
	                            </div>
	                            <div class="radio"><label><input type="radio" name="gender" value="1" checked="checked" />女</label> </div>
                             </c:if>
                        </div>
                     </div>
                    
					 <div class="form-group">
                        <label class="col-lg-3 control-label">联系电话</label>
                        <div class="col-lg-5">
                            <input path="Phone" type="text" class="form-control" name="Phone" value="${shuser.getPhone()}"
                              data-bv-stringlength="true" data-bv-stringlength-min="5" data-bv-stringlength-max="20" data-bv-stringlength-message="联系电话必须保证在5到15个字符"
                              required data-bv-notempty-message="联系电话不能够为空" /> 
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <label class="col-lg-3 control-label">地址</label>
                        <div class="col-lg-5">
                            <input path="Address" type="text" class="form-control" name="Address" value="${shuser.getAddress()}"
                             required data-bv-notempty-message="地址不能够为空"/> 
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-lg-3 control-label">更换头像</label>
                        <div class="col-lg-5">
                            <input  type="file" class="form-control" name="ImgFile"/> 
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-lg-3 control-label">个人介绍</label>
                        <div class="col-lg-5">
                            <textarea name="Introduce" style="height:100px;width:400px;" type="text" class="form-control"
                            		 required data-bv-notempty-message="个人介绍不能够为空">${shuser.getIntroduce()}</textarea>
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