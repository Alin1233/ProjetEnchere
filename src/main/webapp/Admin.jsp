<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<main>
	
	<h1 >Bonjour l'administrateur ${sessionScope.user.pseudo}</h1>
		
		<p class="h2">Tous les utilisateurs:</p>
		<table  class="table">
			<tr>
				<th>Identifiant</th>
				<th>Pseudo</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Action</th>
			</tr>
			<c:forEach var="users" items="${allUsers}">
			<tr>
				<td>${users.noUtilisateur}</td>
				<td>${users.pseudo}</td>
				<td>${users.nom}</td>
				<td>${users.prenom}</td>
				<td>${users.email}</td>
				<td>${users.telephone}</td>
				<td>
					<form action="ServletAccesAdmin" method="POST">
						<input type="hidden" name="userId" value="${users.noUtilisateur}"/>
						<button type="submit" class="btn btn-danger">Supprimer</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
		<p class="h2">Tous les articles:</p>
		<table  class="table">
			<tr>
				<th>Identifiant</th>
				<th>Nom Article</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Categorie</th>
				<th>Vendeur</th>
				<th>Action</th>
			</tr>
			<c:forEach var="articles" items="${articles}">
			<tr>
				<td>${articles.noArticle}</td>
				<td>${articles.nomArticle}</td>
				<td>${articles.description}</td>
				<td>${articles.miseAPrix}</td>
				<td>${articles.getCategorie().libelle}</td>
				<td>${articles.getVendeur().pseudo}</td>
				<td>
					<form action="ServletAccesAdmin" method="POST">
						<input type="hidden" name="userId" value="${users.noUtilisateur}"/>
						<button type="submit" class="btn btn-warning">Modifier</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	
	
	
	
	
	
	
	</main>
	<%@ include file="footer.jspf"%>

</body>
</html>