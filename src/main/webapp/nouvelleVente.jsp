<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	
	<main>
		<h1>Creer une nouvelle vente</h1>
		
		<form class="containder-fluid d-flex flex-row">
			<div class="bg-primary col-4">
				<img src="" alt="image">
			</div>
			<div class="containder-fluid d-flex flex-column bg-warning col">
				<div class="bg-primary ">
					<label class="me-5" for="nomArticle">Article</label>
					<input class="" type="text" name="nomArticle" id="nomArticle">
				</div>
				<div>
					<label for="nomArticle">Description</label>
					<textarea rows="4" cols="30" name="nomArticle" id="nomArticle"></textarea>
				</div>
			
			
			
			</div>
		
		
		
		</form>
	
	
	</main>

</body>
</html>