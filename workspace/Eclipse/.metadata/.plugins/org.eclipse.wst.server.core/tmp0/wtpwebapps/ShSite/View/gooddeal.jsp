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
	<%@ include file="header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	    <%@ include file="catalogue.jsp" %>
	    <!-- 主框架 -->
		<div class="container col-lg-10">
			<h3></h3>
			<form action="/ShSite/Account/GoodDelete" method="post">
				<input type="hidden" name="id" value="${good.getGoodId()}"/>
				<input type="submit" value="删除该商品"/>
			</form>
			<form method="post" action="/ShSite/Account/GoodEdit" enctype="multipart/form-data"
		  		id="defaultForm" class="form-horizontal"
                data-bv-message="This value is not valid"
                data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                <input type="hidden" name="DesTime" value="${good.getDesTime()}"/>
                <div class="row">
	                <div class="col-md-4" id="left">
	                <img id="image" src="/ShSite/goodimages/${good.getGoodId()}.jpg" style="width:300px;height:300px;"/>
	                <input type="file" name="imgFile" id="file" onchange="selectImage(this);"/>
	                </div>
	                <div class="col-md-4" id="right">
	                		<input type="hidden" name="ShUserId" value="${good.getShUserId()}"/>
	                		<input type="hidden" name="GoodId" value="${good.getGoodId()}" />
                    	
		               		<div class="form-group">
		                        <label class="col-lg-4 control-label">商品名称：</label>
		                        <div class="col-lg-6">
		                            <input type="text" class="form-control" name="GoodName"
		                            	   value="${good.getGoodName()}"
		                                   data-bv-message="商品名称无效"
		                                   required data-bv-notempty-message="商品名称不能为空"
		                                   data-bv-stringlength="true" data-bv-stringlength-min="5" data-bv-stringlength-max="10" data-bv-stringlength-message="商品名称必须保证在5到10个字符"
		                           		/>
		                        </div>
	                        </div>
	                        
	                       <div class="form-group">
		                        <label class="col-lg-4 control-label">商品类别：</label>
		                        <div class="col-lg-6">
		                           	<select class="form-control" name="GoodTypeId" 
		                           	     	data-bv-notempty data-bv-notempty-message="商品类别不能为空">
		                           	     	<c:forEach items="${goodTypes}" var="goodType">
										  	<c:if test="${goodType.getGoodTypeId()==good.getGoodTypeId()}">
										  		<option value="${goodType.getGoodTypeId()}" selected = "selected">${goodType.getGoodTypeName()}</option>
										  	</c:if>
										  	<c:if test="${goodType.getGoodTypeId()!=good.getGoodTypeId()}">
										  		<option value="${goodType.getGoodTypeId()}">${goodType.getGoodTypeName()}</option>
										  	</c:if>
											</c:forEach>
                            		</select>
		                        </div>
		                    </div>  
		                    	                    	
	                        <div class="form-group">
		                        <label class="col-lg-4 control-label">商品描述：</label>
		                        <div class="col-lg-6">
		                            <textarea name="Description" style="height:100px;width:400px;" type="text" class="form-control"
		                            		 required data-bv-notempty-message="内容不能够为空"
		                            		 data-bv-stringlength="true" data-bv-stringlength-min="5" data-bv-stringlength-max="50" data-bv-stringlength-message="商品描述必须保证在5到50个字符">${good.getDescription()}</textarea>
		                        </div>
		                    </div>
	                    	
	                    	<div class="form-group">
		                        <label class="col-lg-4 control-label">商品价格：</label>
		                        <div class="col-lg-6">
		                            <input type="text" class="form-control" name="GoodPrice"
		                            	   value="${good.getGoodPrice()}"
		                                   data-bv-message="商品价格无效"
		                                   required data-bv-notempty-message="商品价格不能为空"
		                                    pattern="^[0-9.$]" data-bv-regexp-message="输入格式不正确"
		                           		/>
		                        </div>
	                        </div>
	                        
	                        <div class="form-group">
		                        <label class="col-lg-4 control-label">是否售出：</label>
		                        <div class="col-lg-6">
		                           <select class="form-control" name="IsSell"
		                           	     	data-bv-notempty data-bv-notempty-message="不能为空">
		                           	     	<c:if test="${good.getIsSell()==0}">
										  		<option value="0" selected="selected">未售</option>
                            					<option value="1">已售</option>
										  	</c:if>
										  	<c:if test="${good.getIsSell()==1}">
										  		<option value="0">未售</option>
                            					<option value="1" selected="selected">已售</option>
										  	</c:if>
                            				
                            		</select>
		                        </div>
	                        </div>
	                        
		                    <div class="form-group">
		                        <div class="col-lg-9 col-lg-offset-3">
		                            <button type="submit" class="btn btn-primary">确认修改</button>
		                        </div>
		                    </div>
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
var image = '';
function selectImage(file) {
    if (!file.files || !file.files[0]) {
        return;
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        document.getElementById('image').src = evt.target.result;
        image = evt.target.result;
    }
    reader.readAsDataURL(file.files[0]);
}
</script>
</html>