<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
	<%@ include file="head.jspf"%>
    <title>Mon Profil</title>
    <style>
    	
    	body {
    	margin: 0;
    	padding: 0;
    	}
    
        form {
            max-width: 800px;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
 
        .form-group {
            width: 48%;
            box-sizing: border-box;
            padding: 10px;
            margin-bottom: 15px;
            text-align: left;
        }
 
        input {
            width: 100%;
            box-sizing: border-box;
            padding: 8px;
            margin-bottom: 10px;
            display: block;
        }
 
        h1 {
            text-align: center;
            margin: 0;
            padding: 16px;
        }
        
    .button-container {
        text-align: center;
        margin-top: 20px;
        width: 100%;
    }
 
    button {
        background-color: #808080;
        color: white;
        padding: 12px 24px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        display: inline-block;
        font-size: 16px;
        transition: background-color 0.3s;
        margin-right: 10px;
    }
 
    button:hover {
        background-color: #555;
    }
 
    .bouton-lien {
        background-color: #808080;
        color: white;
        padding: 12px 24px;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        transition: background-color 0.3s;
        margin: 0;
    }
 
    .bouton-lien:hover {
        background-color: #555;
    }
   
        
        
    </style>
</head>
 
<body>
 
<%@ include file="header.jspf"%>
 
<h1>Mon Profil</h1>
 
 		<c:if test="${!empty erreurMdp || !empty erreurUser }" >
		
			<p>${erreurMdp}</p>
			<p>${erreurUser}</p>
		
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