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
			<form 	  method="post" action="/ShSite/Announcement/Create"
		  			  id="defaultForm" class="form-horizontal"
                      data-bv-message="This value is not valid"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">公告标题</label>
                        <div class="col-lg-5">
                            <input path="announceTitle" type="text" class="form-control" name="AnnounceTitle"
                                   data-bv-message="标题无效"
                                   required data-bv-notempty-message="标题不能为空"
                                   data-bv-stringlength="true" data-bv-stringlength-min="5" data-bv-stringlength-max="20" data-bv-stringlength-message="标题必须保证在5到20个字符"
                           		/>
                        </div>
                    </div>  
                    <div class="form-group">
                        <label class="col-lg-3 control-label">公告内容</label>
                        <div class="col-lg-5">
                            <textarea name="AnnoContent" style="height:100px;width:400px;" type="text" class="form-control"
                            		 required data-bv-notempty-message="内容不能够为空"
                            		 data-bv-stringlength="true" data-bv-stringlength-min="10" data-bv-stringlength-max="200" data-bv-stringlength-message="内容必须保证在10到200个字符"></textarea>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <button type="submit" class="btn btn-primary">确认发布</button>
                        </div>
                    </div>
                </form>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator();
});
</script>
</html>