<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- 商品导航 -->
<div class="col-lg-2">
	<ul style="list-style-type:none">
	    <c:forEach items="${goodTypes}" var="goodType">
		<li><a href="/Good/Browse?type=${goodType.getGoodTypeId()}">
		<strong>${goodType.getGoodTypeName()}</strong>
		</a></li>
		</c:forEach>
	</ul>
</div>