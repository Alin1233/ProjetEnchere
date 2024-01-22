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
 
        h2 {
            text-align: center;
            margin: 0;
            padding: 16px;
        }

        .text {
            margin-top: 5vw;
        }

        p {
        	text-align: center;
        }
        
        .boutton {
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
 

 
<div class="text">
    <h2>Confirmation de la suppression</h2>
    <br>
    <p>Etes-vous sûr de vouloir supprimer votre compte?</p>
    <div class="boutton">
        <a href="modificationProfil.jsp" target="_blank" class="bouton-lien">Annuler</a>
        <a href="ServletSuppressionProfil" target="_blank" class="bouton-lien">Oui</a>
    </div>
 
</span>
 
</body>
</html>
</html>