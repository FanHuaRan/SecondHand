<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- 公告滚动 需要做成滑动的 下面的失败了 Bootstrap3.1.1报错
	 可能需要用另外一个第三方 -->
	<div class="page-header">
	      <h1>最新公告</h1>
	</div>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        	<c:forEach items="${announcements}" var="announcement" varStatus="idx">
        		 <li data-target="#carousel-example-generic" data-slide-to="${idx.index}"></li>
			</c:forEach>
        </ol>
        <div class="carousel-inner" role="listbox">
          	<c:forEach items="${announcements}" var="announcement" varStatus="idx">
          		<div class="item">
        		 <img data-src="holder.js/1140x500/auto/#777:#555/text:${announcement.getAnnoContent()}"
        		  alt="${announcement.getAnnoContent()}"/>
        	    </div>
			</c:forEach>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
     </div>