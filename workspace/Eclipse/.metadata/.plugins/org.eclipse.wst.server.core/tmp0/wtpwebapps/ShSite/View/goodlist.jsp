<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- 商品目录 -->
<div class="row goods">
    <c:forEach items="${goods}" var="good">
  		<div class="col-md-2">
		  	<a href="/ShSite/Good/Details?id=${good.getGoodId()}">
		   	<img style="width:200px;height:200px;" alt="${good.getGoodName()}" src="/ShSite/goodimages/${good.getGoodId()}.jpg"/>
	        <div class="goodbottom">
	         <span class="namespan">${good.getGoodName()}</span>
	         <p>
	         <span>¥${good.getGoodPrice()}</span> 
	         <span>评论12</span>
	         <span>收藏12</span>
	         </p>
	        </div>
		 	</a>
		 </div>
  </c:forEach>
</div>
	