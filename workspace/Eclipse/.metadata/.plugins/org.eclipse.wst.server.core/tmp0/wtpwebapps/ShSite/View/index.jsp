<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/site.css"/>
<title>主页</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container" id="main">
		<div id="homeannouce">
		  <p class="btn btn-primary"><a>公告栏</a></p>
	      <div class="row" >
	        <div class="col-lg-4">
	          <h2>公告一</h2>
	          <p class="text-danger">As of v8.0, Safari exhibits a bug in which resizing your browser horizontally causes rendering errors in the justified nav that are cleared upon refreshing.</p>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn btn-primary" href="#" role="button">详细&raquo;</a></p>
	        </div>
	        <div class="col-lg-4">
	          <h2>公告二</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn btn-primary" href="#" role="button">详细&raquo;</a></p>
	       </div>
	        <div class="col-lg-4">
	          <h2>公告三</h2>
	          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
	          <p><a class="btn btn-primary" href="#" role="button">详细 &raquo;</a></p>
	        </div>
	      </div>
      </div>
      <div class="goods">
      	<ul>
      	</ul>
      </div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>