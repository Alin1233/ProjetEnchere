<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>

<title>Vendre un article</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	
	<main>
		
		<section class="containder-fluid d-flex flex-row" >
			<form class="containder-fluid d-flex flex-column align-items-center col-4 " method="post" action="ServletUploadImage" class="bg-primary col-4" enctype="multipart/form-data">
	       
	            <img class="mt-5" width="80%" src="images/${imageName}"> 
<br>
	            <input class=" w-75 align-self-start ms-5" type="file" name="image" accept="image/jpeg, image/png" /> 
<br>
	            <input class="btn btn-warning w-25 align-self-start ms-5" type="submit" value="Importer" /> <br/> 
			</form>
					
			<form class="containder-fluid d-flex flex-row col"  action="ServletNouvelArticle" method="POST">
				
				<div class="containder-fluid d-flex flex-column  col">
					<br>
					<h1 class="align-self-start ms-5">Creer une nouvelle vente</h1>
					<br>
					<!-- Afficher le message de confirmation s'il existe -->
					<c:if test="${not empty requestScope.confirmationMessage}">
					    <div class="alert alert-success w-50">
					        ${requestScope.confirmationMessage}
					    </div>
					</c:if>
					<c:if test="${not empty requestScope.error}">
					    <div class="alert alert-danger w-50">
					        ${requestScope.error}
					    </div>
					</c:if>
					<br>
					<div class="mt-3 d-flex flex-row">
					    <label class="col-2 col-form-label" for="nomArticle">Article</label>
					    <input class="form-control w-50 border border-secondary" type="text" name="nomArticle" id="nomArticle">
					</div>
					<div class="mt-3 d-flex flex-row">
					    <label class="col-sm-2 col-form-label" for="description">Description</label>
					    <textarea class="form-control w-50 border border-secondary" rows="4" cols="30" name="description" id="description"></textarea>
					</div>
					<div class="mt-3 d-flex flex-row">
					    <label class="col-sm-2 col-form-label" for="selectCategorie">Categorie</label>
					    <select class="form-control w-50 border border-secondary" name="selectCategorie" id="selectCategorie">
	   						<c:forEach var="categorie" items="${categorieListe}">
								<option value="${categorie}">${categorie}</option>
							</c:forEach>
					    </select>
					</div>
					<div class="mt-3 d-flex flex-row">
						<label class="col-sm-2 col-form-label" for="miseAPrix">Mise à prix : </label>
						<input class="form-control w-25 border border-secondary" type="number" id="miseAPrix" name="miseAPrix" min="0" max="100000" />
					</div>
					<div class="mt-3 d-flex flex-row">
						<label class="col-sm-2 col-form-label" for="dateDebutEnchere">Début de l'enchère : </label>
						<input class="form-control w-50 border border-secondary" type="date" id="dateDebutEnchere" name="dateDebutEnchere" />
					</div>
					<div class="mt-3 d-flex flex-row">
						<label class="col-sm-2 col-form-label" for="dateFinEnchere">Fin de l'enchère : </label>
						<input class="form-control w-50 border border-secondary" type="date" id="dateFinEnchere" name="dateFinEnchere" />
					</div>
					<br>
					<br>
					<div class="d-flex justify-content-center">
						<fieldset class="col-6 align-center border border-warning p-3 rounded-2 shadow-lg">
		                    <legend>Adresse de retrait</legend>
		                    <br>
				                <div class="mt-3 d-flex flex-row">
								    <label class="col-sm-3 col-form-label" for="RetraitRue">Rue</label>
								    <input class="col form-control w-50 border border-secondary" type="text" name="RetraitRue" id="RetraitRue" 
								    value="${user.adresse.rue }">
								</div>
				                <div class="mt-3 d-flex flex-row">
								    <label class="col-sm-3 col-form-label" for="RetraitCodePostal">Code Postal</label>
								    <input class="col form-control w-50 border border-secondary" type="text" name="RetraitCodePostal" id="RetraitCodePostal"
								    value="${user.adresse.codePostal }">
								</div>
				                <div class="mt-3 d-flex flex-row">
								    <label class="col-sm-3 col-form-label" for="RetraitVille">Ville</label>
								    <input class="col form-control w-50 border border-secondary" type="text" name="RetraitVille" id="RetraitVille"
								    value="${user.adresse.ville }">
								</div>
		                    
		                </fieldset>
	               	</div>
	               	<br>
	               	<br>
					<div class="d-flex justify-content-center col-8">
						<button type="submit" class="btn btn-warning btn-lg pe-5 ps-5">Valider</button>
						<button type="button" onclick="location.href='index.jsp'" class="btn btn-danger btn-lg pe-5 ps-5 ms-5">Retour</button>		
					</div>
				</div>
				
					
					
		
			</form>
		</section>

	
	</main>
	
	<%@ include file="footer.jspf"%>

</body>
</html>