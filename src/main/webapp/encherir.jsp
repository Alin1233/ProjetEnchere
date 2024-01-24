<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Détail vente</title>
 
    <script src="https://kit.fontawesome.com/0bec6bfa71.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
 
    h1{
        text-align: center;
        margin: 0;
        padding: 16px;
    }
 
    main {
        display: flex;
        justify-content: center;
        margin-top: 5vh;
    }
 
    .p {
        display: block;
    width: 150px;
    float: left;
    }
 
    .form-group, .enchere {
        display: flex;
    }
    .article {
        font-weight: bold;
    }
    button {
        background-color: #808080;
        color: white;
        padding: 8px 11px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        display: inline-block;
        font-size: 16px;
        transition: background-color 0.3s;
        margin-left: 5%;
    }
 
    .number {
        width: 100px;
        border-radius:5px;
    }
    
    .image {
        margin-right: 2vw;
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
 
    <h1>Détail de la vente</h1>
 
    <main>
 
 
        <!-- Section pour l'image-->
        <section class="image">
            <img src="eniLogo.png" alt="Photo">
        </section>
 
        <!-- Section pour les infos -->
        <section class="Description">
            <form>
 
                <div class="article">
                    <p> <%= request.getAttribute("nom") %> </p>
                </div>
                <div class="form-group">
                    <p class="p"> Description: </p>
                    <p class="text"><%= request.getAttribute("description") %></p>
                </div>
                <div class="form-group">
                    <p class="p"> Catégorie : </p>
                    <p class="text"><%= request.getAttribute("categorie") %></p>
                </div>
 
                <div class="form-group">
                    <p class="p"> Vendeur : </p>
                    <p class="text"> <%= request.getAttribute("vendeur") %></p>
                </div>
 
                <div class="form-group">
                    <p class="p"> Retrait : </p>
                    <p class="text"><%= request.getAttribute("adresse") %></p>
                </div>
 
                <div class="form-group">
                    <p class="p"> Fin de l'enchère: </p>
                    <p class="text"><%= request.getAttribute("dateFinEnchere") %></p>
                </div>
 
                <div class="form-group">
                    <p class="p"> Mise à prix : </p>
                    <p class="text"><%= request.getAttribute("prixDepart") %></p>
                </div>
 
                <div class="form-group">
                    <p class="p"> Meilleure offre: </p>
                    <p class="text"><%= request.getAttribute("meilleureOffre") %></p>
                </div>
 
                <div class="enchere">
                    <p class="p"> Ma proposition : </p>
                    <input class="number" type="text" >
                    <button type="submit">Enchérir</button>
                </div>
 
            </form>
 
        </section>
 
 
    </main>