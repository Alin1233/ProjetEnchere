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
   
        
        

</head>
 
<body>
 
<header>
    <nav >
		  <div class="container-fluid  d-flex bg-warning p-2">
			  <a class="navbar-brand p-2 flex-grow-1" href="ServletAccesIndexJsp"><i class="fa-solid fa-gavel fa-2xl"></i></a>
			  <a class="nav-link p-2" href="#">Ench�re</a>
			  <a class="nav-link p-2" href="ServletAccesNouvelleVente">Vendre un article</a>
			  <a class="nav-link p-2" href="ServletAffichageProfil?pseudo=${user.pseudo}">Mon profil</a>
			  <a class="nav-link p-2" href="ServletDeconnection">D�connexion</a>
		  </div>
	</nav>
</header>
 
<h1>Mon Profil</h1>
 <section style="background-color: #eee;">
    <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
              class="rounded-circle img-fluid" style="width: 150px;">
            <h5 class="my-3">${nom} ${prenom}</h5>
            <div class="d-flex justify-content-center mb-2">
                <a href="modificationProfil.jsp" target="_blank" class="btn btn-warning">Modifier</a>
   				<a href="suppressionProfil.jsp" target="_blank" class="btn btn-danger">Supprimer</a>
    			<a href="index.jsp" target="_blank" class="btn btn-dark">Annuler</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Nom et pr�nom</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${nom} ${prenom}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Pseudo</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${pseudo}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${email}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">T�l�phone</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${telephone }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Adresse </p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${adresse.rue } ${adresse.ville } ${adresse.codePostal }</p>
              </div>
            </div>
          </div>
        </div>
    </div>
  </div>
</section>
 
 
</body>
</html>