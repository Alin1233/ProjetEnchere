<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.labo.servlets.ServletAccesIndexJsp"%>
<%@page import="fr.labo.bo.Utilisateur"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jspf"%>
    <title>Accueil</title>
</head>
<body>

    <%@include file="header.jspf"%>
    <main>
        <h1 class="text-center p-3">Liste des enchères</h1>

        <!-- Section filtre -->
        <section>
            <p>Filtres</p>
            <form class="container-fluid d-flex flex-row " method="POST" action="ServletRechercherVentes">
                <div class="col-8">
                    <!-- Champs de recherche par defaut (non connecté) -->
                    <label for="search">Rechercher par mot clef</label>
                    <input class="border border-black form-control w-50" type="search"
                           placeholder="Search" aria-label="Search" name="search"> <br>

                    <!-- Affichage de l'ensemble des catégorie présente dans la base donnée -->
                    <label for="categorie">Catégorie :</label>
                    <select class="w-25" id="categorie" name="categorie">
                    	<option value="all">Tous</option>
                        <c:forEach var="categorie" items="${categorieListe}">
                            <option value="${categorie}">${categorie}</option>
                        </c:forEach>
                    </select>

                    <!-- Section avec champs de recherche pour utilisateur connécté-->
                    <!--Script pour desactiver les checkbox selon le radio filtreAchat/filtreVente sélctionné-->
                    <c:if test="${!empty user }">

                        <section class="container-fluid d-flex flex-row justify-content-start">
                            <div class="filtreAchat">
                                <div class="d-flex flex-row ">
                                    <input class="ms-4" type="radio" name="filtreRadio" value="enchereOuverte">
                                    <label class="ms-2" for="enchereOuverte">Enchères ouvertes</label>
                                </div>
                                <div class="d-flex flex-row">
                                    <input class="ms-4"  type="radio" name="filtreRadio" value="enchereEnCours">
                                    <label class="ms-2"  for="enchereEnCours">Enchères en cours</label>
                                </div>
                                <div class="d-flex flex-row">
                                    <input class="ms-4"  type="radio" name="filtreRadio" value="enchereRemporte">
                                    <label class="ms-2"  for="enchereRemporte">Enchères remportées</label>
                                </div>
                            </div>
                            <div class="filtreVente flex-column ">
                                <div class="d-flex flex-row ">
                                    <input class="ms-4" type="radio" name="filtreRadio" value="veteEnCours" >
                                    <label class="ms-2" for="veteEnCours">Ventes en cours</label>
                                </div>
                                <div class="d-flex flex-row">
                                    <input class="ms-4"  type="radio" name="filtreRadio" value="venteNonDebute" >
                                    <label class="ms-2"  for="venteNonDebute">Ventes non debutées</label>
                                </div>
                                <div class="d-flex flex-row">
                                    <input class="ms-4"  type="radio" name="filtreRadio" value="venteTermine" >
                                    <label class="ms-2"  for="venteTermine">Ventes terminées</label>
                                </div>
                            </div>
                        </section>
                    </c:if>
                </div>
                <div class="col align-self-center ">
                    <button class="d-block btn btn-lg btn-warning w-50" type="submit">Rechercher</button>
                </div>

            </form>
        </section>

        <!-- Section Articles -->
        <section class="d-flex flex-row flex-wrap">
            <!-- Ajouter une boucle forEach pour afficher tout les articles -->
            <c:forEach var="article" items="${listeArticles}">
                <div class="card mb-5 col-5 m-5" style="max-width: 50%;">
                    <div class="container-fluid row">
                        <div class="col-5 d-flex flex-wrap align-items-center">
                            <img src="" class="img-fluid" alt="cailloux">
                        </div>
                        <div class="col">
                            <div class="card-body">
                                <a href="detailVente.jsp">
                                    <h5 class="card-text"><a href="ServletDetailVente?nomArticle=${article.nomArticle}">${article.nomArticle}</a></h5>

                                <p class="card-text">Description : ${article.description}</p>
                                <p class="card-text">Mise à prix : ${article.miseAPrix}</p>
                                <p class="card-text">Enchère actuelle : ${article.prixVente}</p>
                                <p class="card-text">Date de fin d'enchère : ${article.dateFinEncheres}</p>
                                <!-- A tester -->
                                <p class="card-text">Vendeur : <a href="ServletAffichageProfilAutre?pseudo=${article.vendeur.pseudo}">${article.vendeur.pseudo}</a></p>


                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
    </main>

    <%@include file="footer.jspf"%>

</body>
</html>
