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
<style type="text/css">
.detaildiv{
	 width:1200px;
	 height:800px;
	 background:url("/ShSite/resources/images/009.jpg");
	 }
.detaildiv2{
	 width:1200px;
	 height:50px;
	 }
.detaildiv3{
  text-align:center;
  width:1200px;
  height:700px;
  padding:2px;
  }	 
 .detaildiv4{
	 width:1200px;
	 height:650px;
	 margin:40px;
	 }
.distant1{color:#00FF7F;font-weight:bold;
	 text-shadow:0 0 1px currentColor,
	 -1px -1px 1px #030,0 -1px 1px #030,
	 1px -1px 1px #030,1px 0 1px #030,1px 1px 1px #030,
	 0 1px 1px #030,-1px 1px 1px #030,-1px 0 1px #030}
.bottom{font-weight:bold;color:#00BFFF/*FF*/;text-shadow:0 0 1px currentColor,
2px  0   1px #083058,  0   2px  1px #98c0e8,  2px  1px  1px #083058,  1px  2px  1px #98c0e8,  2px  2px  1px #487098,
3px  1px 1px #083058,  1px 3px  1px #98c0e8,  3px  2px  1px #083058,  2px  3px  1px #98c0e8,  3px  3px  1px #487098,
4px  2px 1px #083058,  2px 4px  1px #98c0e8,  4px  3px  1px #083058,  3px  4px  1px #98c0e8,  4px  4px  1px #487098,
5px  3px 1px #083058,  3px 5px  1px #98c0e8,  5px  4px  1px #083058,  4px  5px  1px #98c0e8,  5px  5px  1px #487098,
6px  4px 1px #083058,  4px 6px  1px #98c0e8,  6px  5px  1px #083058,  5px  6px  1px #98c0e8,  6px  6px  1px #487098,
7px  5px 1px #083058,  5px 7px  1px #98c0e8,  7px  6px  1px #083058,  6px  7px  1px #98c0e8,  7px  7px  1px #487098,
8px  6px 1px #083058,  6px 8px  1px #98c0e8,  8px  7px  1px #083058,  7px  8px  1px #98c0e8,  8px  8px  1px #487098,
9px  7px 1px #083058,  7px 9px  1px #98c0e8,  9px  8px  1px #083058,  8px  9px  1px #98c0e8,  9px  9px  1px #487098,
10px 8px 1px #083058,  8px 10px 1px #98c0e8,  10px 9px  1px #083058,  9px  10px 1px #98c0e8,  10px 10px 1px #487098,
11px 9px 1px #083058,  9px 11px 1px #98c0e8,  11px 10px 1px #083058,  10px 11px 1px #98c0e8,  11px 11px 1px #487098,
11px 11px 1px #666,
11px 12px 1px #666,
10px 12px 1px #666,
9px 12px 1px #666,
8px 11px 1px #666,
7px 10px 1px #666,
6px 9px 1px #666,
5px 8px 1px #666,
4px 7px 1px #666,
3px 6px 1px #666,
2px 5px 1px #666,
1px 4px 1px #666,
0 3px 1px #666,
-1px 2px 1px #666,
20px 8px 8px rgba(0,0,0,.7)}
</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="row" id="main">
		<!-- 商品导航 -->
	    <%@ include file="../catalogue.jsp" %>
	    <!-- 主框架 -->
		<div style="" class="container col-lg-10">
		<div class="detaildiv">
		 <h1 class="bottom">公告详情导读</h1>
		<div class="detaildiv3 table-responsive"style=" margin-left:50px;margin-right:50px;">
		<div style="width:1450px;text-align:center;">
        <div class="row marketing">
        <div class="col-lg-6">
          <div><h4><strong class="pull-left">公告编号:</strong></h4><strong class="pull-left">${announcement.getAnnouncementId()}</strong><br/><br/></div>
          <div><h4><strong class="pull-left">公告标题:</strong></h4><strong class="pull-left">${announcement.getAnnounceTitle()}</strong><br/><br/></div>
          <div><h4><strong class="pull-left">发布时间:</strong></h4><strong class="pull-left">${announcement.getAnnoTime()}</strong><br/><br/></div>
        </div>
        </div>
		    </div>
		    <div class="detaildiv2">
		         <h2 class=" test pull-left">详情信息</h2>
		    </div>
		         <div class="detaildiv4">
		         <p class="pull-left">${announcement.getAnnoContent()}</p>
		         </div>
		    </div>
   		 </div>
		</div>
		</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>