<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon Profil</title>
 
    <script src="https://kit.fontawesome.com/0bec6bfa71.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 
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
        
        p {
        	text-align: center;
        
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
 
<header>
    <div class="container-fluid d-flex bg-warning p-2">
        <a class="navbar-brand p-2 flex-grow-1" href="#">
            <i class="fa-solid fa-gavel fa-2xl"></i>
        </a>
    </div>
</header>
 
<h1>Mon Profil</h1>
 
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
        <label for="motDePasseActuel">Mot De Passe actuel:</label>
        <input type="text" id="motDePasse" name="motDePasse" required>
    </div>
        <div class="form-group">
        <label for="NewMP">Nouveau Mot De Passe:</label>
        <input type="text" id="NewMP" name="NewMP" required>
    </div>
    <div class="form-group">
        <label for="confirmationMP">Confirmation du nouveau Mot De Passe:</label>
        <input type="text" id="confirmationMP" name="confirmationMP" required>
    </div>
 
 
</form>


<p> Le credit est de :  <%= request.getAttribute("credit") %>  </p>


<div class="button-container">
    <button type="submit">Enregistrer</button>
    <a href="affichageProfil.jsp" target="_blank" class="bouton-lien">Annuler</a>
</div>
 



 
</body>
</html>