<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
 <link rel="stylesheet" type="text/css" href="stylesCSS/bootstrap-theme.css">
 <link rel="stylesheet" type="text/css" href="stylesCSS/bootstrap.css">
 <link rel="stylesheet" type="text/css" href="stylesCSS/bootstrap-theme.min.css">
 <link rel="stylesheet" type="text/css" href="stylesCSS/bootstrap.min.css">
 <link href='http://fonts.googleapis.com/css?family=Alegreya+Sans:400,700,500italic' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" type="text/css" href="stylesCSS/styleCSS.css">
 <script src = "http://code.jquery.com/jquery-2.1.4.js"></script>
 <script src = "/SlowNews/scryptMy.js"></script>

<title>Insert title here</title>
</head>
<body>
<div class = "container">
	<div class = "row">
		
		<div class = "col-md-3">
		<img class = "title-logo" src = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSQEcCeE5E1GCBkXHQwR_cTlK6MJnWImhOGaTJ4cO00thCosl1X"/>
			<h4><div class = "text-center">
				<c:if test="${login!= null}">
				<b>Hello, <c:out value="${login}"/>!</b>
				</c:if>
				<c:if test="${login == null}">
				<b>Hello, <c:out value="quest"/>!</b>
				</c:if>
				<a href="#" class = "myLink"> Press me</a>
			</div></h4>
		</div>
		<div class = "col-md-9">
			<h1><p class="text-center text-capitalize title-super">Welcome to SlowNews</p></h1>
			<h4 class ="text-center"> Realy slow news :) </h4>
		
	</div class = "button_class">
	
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
			<div class="btn-group" role="group">
			<a href="mainpage" id="btn">
			<button type="button" class="btn btn-default">Main</button>
			</a>
		</div>
		<div class="btn-group" role="group">
			<a href="logining" id="btn">
			<button type="button" class="btn btn-default" >LogIN</button>
			</a>
		</div>
		<div class="btn-group" role="group">
			<a href="archive" id="btn">
			<button type="button" class="btn btn-default">Archive</button>
			</a>
		</div>
	</div>
	
	<div class = "col-md-12">
		<div class = "news_block">
			<form action="" class = form method = "post">
            			<c:forEach var = "news" items = "${sessionScope.news}">
            				<div>
            				<h1 class = "h1"><c:out value = "${news.title}"/></h1>
            				<input type = "checkbox" name = "archivedNews">
            				<c:out value = "${news.text}"/>
            				</div>
            			</c:forEach>
            			<input type = "submit" value = "Archive">
			</form>
		</div>
	</div>
	<div class = "footer">
		<div class = "row">
		
			<div class = "col-md-8">
			</div >
			<div class = "col-md-4">
			
				<address>
				<strong>Kiev, Ukraine</strong><br>
				<a href="mailto:#">volokhink@gmail.com</a>
				</address>
		    </div>
		</div>
	</div>
	
</div>
</div>
</body>
</html>