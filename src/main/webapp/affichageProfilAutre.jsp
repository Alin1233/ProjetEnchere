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
 
<h1>Profil Autre</h1>
 
<form>
    
    <div class="form-group">
        <p> Pseudo : </p>
        <p><%= request.getAttribute("pseudo") %></p>
    </div>
    <div class="form-group">
        <p> Nom : </p>
        <p><%= request.getAttribute("nom") %></p>
    </div>  <div class="form-group">
        <p> Prénom: </p>
        <p><%= request.getAttribute("prenom") %></p>
    </div>  <div class="form-group">
        <p> Email : </p>
        <p><%= request.getAttribute("email") %></p>
    </div>  <div class="form-group">
        <p> Téléphone : </p>
        <p><%= request.getAttribute("telephone") %></p>
    </div>  <div class="form-group">
        <p> Adresse : </p>
        <p><%= request.getAttribute("adresse") %></p>
    </div>
    
</form>
 
<div class="boutton">
    <a href="index.jsp" target="_blank" class="bouton-lien">Annuler</a>
    
</div>
 
 
 
</body>
</html>