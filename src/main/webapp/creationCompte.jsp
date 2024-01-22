<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ include file="head.jspf"%>
	<link rel="stylesheet" href="style/style.css">
    <title>Mon Profil</title>
</head>
 
<body>
 
<%@ include file="header.jspf"%>
 
<h1>Mon Profil</h1>
 
 		<c:if test="${!empty erreurMdp || !empty erreurUser }" >
		
			<p class="text-center text-danger">${erreurMdp}</p>
			<p class="text-center text-danger">${erreurUser}</p>
		
		</c:if>
<form action="ServletCreationCompte" method="post">
    <div class="form-group">
        <label for="pseudo">Pseudo:</label>
        <input type="text" id="pseudo" name="pseudo" required>
    </div>
    
        <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required>
    </div>
    
    <div class="form-group">
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required>
    </div>
    
            <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    
        <div class="form-group">
        <label for="telephone">Telephone:</label>
        <input type="tel" id="noTel" name="noTel" required>
    </div>

        <div class="form-group">
        <label for="rue">Rue:</label>
        <input type="text" id="rue" name="rue" required>
    </div>
        <div class="form-group">
        <label for="codePostal">Code postal:</label>
        <input type="text" id="codePostal" name="codePostal" required>
    </div>
    
        <div class="form-group">
        <label for="ville">Ville:</label>
        <input type="text" id="ville" name="ville" required>
    </div>

        <div class="form-group">
        <label for="motDePasse">Mot De Passe:</label>
        <input type="text" id="motDePasse" name="motDePasse" required>
    </div>
    <div class="form-group">
        <label for="confirmationMP">Confirmation Mot De Passe:</label>
        <input type="text" id="confirmationMP" name="confirmationMP" required>
    </div>
 
	<div class="button-container">
	    <button type="submit">Créer</button>
	    <a href="ServletConnectionUser" target="_blank" class="bouton-lien">Annuler</a>
	</div>
 
 
</form>
 
</body>
</html>