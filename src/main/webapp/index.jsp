<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<%@ include file="head.jspf" %>
</head>
<body>
	<%@ include file="header.jspf" %>
	<main>
	
		<h1 class="text-center p-3">Liste des enchères</h1>
		<!-- Section filtre -->
		<section>
			<p>Filtres</p>
			<form method="POST">
				<div>
				<!-- Champs de recherche par defaut (non connecté) -->
					<label for="search" >Rechercher par mot clef</label>
					<input class="border border-black form-control w-25" type="search" placeholder="Search" aria-label="Search" name="search">
					<br>
					
					<label for="categorie">Catégorie :</label>
					<select id="categorie" name="categorie" >
						<c:forEach  var="categorie" items="${categorieListe}">
						  <option value="${categorie.no_categorie}">{categorie.libelle}</option>
						</c:forEach>
					</select>
				<!-- Champs de recherche connecté -->
					<c:if test="${!empty user }">
						<div>
						
						
						
						</div>
					
					
					
					
					</c:if>	
				</div>
				<button type="submit">Rechercher</button>		
			</form>
			
		<!-- Section Articles -->
		</section>
		
		<section>
		
		
		
		</section>

	</main>


</body>
</html>