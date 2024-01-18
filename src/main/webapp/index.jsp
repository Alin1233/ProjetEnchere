<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>
<title>Accueil</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<main>

		<h1 class="text-center p-3">Liste des enchères</h1>
		
		<!-- Section filtre -->
		<section>
			<p>Filtres</p>
			<form method="POST">
				<div>
					<!-- Champs de recherche par defaut (non connecté) -->
					<label for="search">Rechercher par mot clef</label> <input
						class="border border-black form-control w-25" type="search"
						placeholder="Search" aria-label="Search" name="search"> <br>

					<!-- Affichage de l'ensemble des catégorie présente dans la base donnée -->
					<label for="categorie">Catégorie :</label> 
					<select id="categorie" name="categorie">
						<c:forEach var="categorie" items="${categorieListe}">
							<option value="${categorie.idUser}">${categorie.passwordUser}</option>
						</c:forEach>
					</select>
					
					<!-- Champs de recherche connecté -->
					<c:if test="${empty user }">
						<div>
							<input type="radio" name="filtre" id="filtreAchat"> <input
								type="checkbox" name="enchereOuverte" value="enchereOuverte">
							<label for="enchereOuverte">enchereOuverte</label> <input
								type="checkbox" name="enchereEnCours" value="enchereEnCours">
							<label for="enchereEnCours">enchereEnCours</label> <input
								type="checkbox" name="enchereRemporte" value="enchereRemporte">
							<label for="enchereRemporte">enchereRemporte</label> <input
								type="radio" name="filtre" id="filtreVente"> <input
								type="checkbox" name="veteEnCours" value="veteEnCours">
							<label for="veteEnCours">venteEnCours</label> <input
								type="checkbox" name="venteNonDebute" value="venteNonDebute">
							<label for="venteNonDebute">venteNonDebute</label> <input
								type="checkbox" name="venteTermine" value="venteTermine">
							<label for="venteTermine">venteTermine</label>
						</div>
					</c:if>
				</div>
				<button type="submit">Rechercher</button>
			</form>
		</section>

			<!-- Section Articles -->
		<section>
			<!-- Ajouter une boucle forEach pour afficher tout les articles -->
			<div class="card mb-3" style="max-width: 50%;">
				<div class="container-fluid  row g-0 ">
					<div class="col-md-5 d-flex flex-wrap align-items-center">
						<img src="${article.image }"
							class="img-fluid" alt="cailloux">
					</div>
					<div class="col-md-5">
						<div class="card-body">
							<h5 class="card-title">${article.nom_article}</h5>
							<p class="card-text">Description : ${article.description}</p>
							<p class="card-text">Prix : ${article.prix_vente}</p>
							<p class="card-text">Date de fin d'enchère :
								${article.date_fin_encheres}</p>
							<!-- A tester -->
							<p class="card-text">Vendeur : ${article.vendeur }</p>
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>
	<%@ include file="footer.jspf"%>

</body>
</html>