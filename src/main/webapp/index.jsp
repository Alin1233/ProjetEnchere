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
					

					<!-- Section avec champs de recherche pour utilisateur connécté-->
					 <!--Script pour desactiver les checkbox selon le radio filtreAchat/filtreVente sélctionné-->
					<%@ include file="scriptIndex.jspf"%>
					<c:if test="${empty user }">
					
						<section class="container-fluid d-flex flex-row justify-content-start">
						    <div class="filtreAchat">
                                <div class="d-flex flex-row">
                                    <input type="radio" name="filtre" id="filtreAchat" onclick="desactiverCasesACocher()" checked> 
                                    <label class="ms-2" for="filtreAchat">Achats</label> 
                                </div>
                                <div class="d-flex flex-row ">
							        <input class="ms-4" type="checkbox" name="enchereOuverte" value="enchereOuverte">
							        <label class="ms-2" for="enchereOuverte">Enchères ouvertes</label> 
                                </div>
                                    <div class="d-flex flex-row">
							        <input class="ms-4"  type="checkbox" name="enchereEnCours" value="enchereEnCours">
							        <label class="ms-2"  for="enchereEnCours">Enchères en cours</label> 
                                </div>
                                    <div class="d-flex flex-row">
							        <input class="ms-4"  type="checkbox" name="enchereRemporte" value="enchereRemporte">
							        <label class="ms-2"  for="enchereRemporte">Enchères remportées</label> 
                                </div>
							        
						    </div>					
						    <div class="filtreVente flex-column "> 
                                <div class="d-flex flex-row">
                                    <input type="radio" name="filtre" id="filtreVente" onclick="desactiverCasesACocher()"> 
                                    <label class="ms-2" for="filtreVente">Ventes</label> 
                                </div>
                                <div class="d-flex flex-row ">
							        <input class="ms-4" type="checkbox" name="veteEnCours" value="veteEnCours" disabled>
							        <label class="ms-2" for="veteEnCours">Ventes en cours</label> 
                                </div>
                                    <div class="d-flex flex-row">
							        <input class="ms-4"  type="checkbox" name="venteNonDebute" value="venteNonDebute" disabled>
							        <label class="ms-2"  for="venteNonDebute">Ventes non debutées</label> 
                                </div>
                                    <div class="d-flex flex-row">
							        <input class="ms-4"  type="checkbox" name="venteTermine" value="venteTermine" disabled>
							        <label class="ms-2"  for="venteTermine">Ventes terminées</label> 
                                </div>
						    </div>
						</section>
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


</body>
</html>