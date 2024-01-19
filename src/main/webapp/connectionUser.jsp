<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
</head>
<body>

	<main>
		<form method="POST" action="ServletConnectionUser">
			<label for="idUser">Identifiant</label>
			<input type="text" name="idUser" id="idUser">
			<label for="passwordUser">Mot de passe</label>
			<input type="password" name="passwordUser" id="passwordUser">
			<button type="submit" >Connexion</button>
		</form>
		<c:if test="${!empty erreur }">
		
			<p>${erreur}</p>
		
		</c:if>
	</main>

</body>
</html>