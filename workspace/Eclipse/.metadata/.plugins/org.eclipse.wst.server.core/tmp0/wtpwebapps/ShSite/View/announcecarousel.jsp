<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	 <h3>
	 <span class="label label-success">最新公告</span>
	  <button type="button" class="btn btn-lg btn-link"><a href="/ShSite/Announcement">more</a></button>
	 </h3>
     <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
       		<c:forEach items="${announcements}" var="announcement" varStatus="idx">
        		 <li data-target="#carousel-example-generic" data-slide-to="${idx.index}" <c:if test="${idx.index==0}"> class="active"</c:if>> </li>
			</c:forEach>
      </ol>
      <div class="carousel-inner">
      		<c:forEach items="${announcements}" var="announcement" varStatus="idx">
          		<div  <c:if test="${idx.index==0}">class="item active"</c:if><c:if test="${idx.index!=0}">class="item"</c:if>> 
        		   <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:">
		          	<div class="container">
		           		 <div class="carousel-caption">
		             	 <h1>${announcement.getAnnounceTitle()}</h1>
		              		<p>${announcement.getAnnoContent()}</p>
		            	 </div>
		         	</div>
		        </div>
			</c:forEach>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>