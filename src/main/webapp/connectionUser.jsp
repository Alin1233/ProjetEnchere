<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>
<link rel="stylesheet" href="style/style.css">
<title>Page de connexion</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<main>
		<form method="POST" action="ServletConnectionUser">
			<label for="pseudoUser">Identifiant</label>
			<input  type="text" name="pseudoUser" id="pseudoUser" value="${pseudo}">
			<label for="passwordUser">Mot de passe</label>
			<input  type="password" name="passwordUser" id="passwordUser" value="${password}">
		<div class="form-check">
    		<input type="checkbox" class="form-check-input" id="exampleCheck1" name="souvenir">
   			<label class="form-check-label" for="exampleCheck1">Se souvenir de moi!</label>
  		</div>
			<button type="submit" class="btn btn-primary">Connexion</button>
		</form>
		<c:if test="${!empty erreur }">
		
			<p class="text-center text-danger">${erreur}</p>
		
		</c:if>
	</main>

</body>
</html>