<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="head.jspf"%>
<title>Insert title here</title>
<style>
.gradient-custom {
/* fallback for old browsers */
background: #f6d365;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1))
}
</style>
</head>
<body>
<%@include file="header.jspf"%>
<main>
<c:if test="${not empty requestScope.error}">
	<div class="alert alert-danger w-50">
		${requestScope.error}
	</div>
</c:if>
<section class="vh-150" style="background-color: #f4f5f7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-8 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem; height: 500px;">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white"
              style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <h5>${article.nomArticle}</h5>
              <img src="${pageContext.request.contextPath}/images/${article.nomArticle}-${article.vendeur.pseudo}.png"
                alt="Avatar" class="img-fluid my-5" style="width: 800px;" />
            <span><strong>Vendeur:</strong></span>
			<span><a href="ServletAffichageProfilAutre?pseudo=${article.vendeur.pseudo}">${article.vendeur.pseudo}</a></span>
              <p>${article.description}</p>
              <c:if test="${user.pseudo eq article.vendeur.pseudo }">
              <div class="button">
                    <a href="ServletModificationVente" target="_blank" class="btn btn-primary">Modifier la vente</a>
               </div>
              </c:if>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Information</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Date Debut Encheres</h6>
                    <p class="text-muted">${article.dateDebutEncheres}</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Date Fin Encheres</h6>
                    <p class="text-muted">${article.dateFinEncheres}</p>
                  </div>
                </div>
                <h6>Prix</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Mise A Prix</h6>
                    <p class="text-muted">${article.miseAPrix}</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Prix Vente</h6>
                    <p class="text-muted">${article.prixVente}</p>
                  </div>
                </div>
                <c:if test="${user.pseudo ne article.vendeur.pseudo && !empty user}">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                  <form  method="post" action="ServletDetailArticle">
                    <h6>Ma proposition : </h6>
                    <input class="number" type="text">
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Enchérir</h6>
                    <button type="submit"  class="btn btn-info">Accepter</button>
                  </div>
                  </form>
                </div>
                </c:if>
                <div class="col-6 mb-3">
                    <h6>Retrait:</h6>
                     <p class="text-muted">${article.retrait.rue} ${article.retrait.ville} ${article.retrait.codePostal} <i class="fa-solid fa-truck"></i>  </p>
                 </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
		
	
	
</main>
<%@include file="footer.jspf"%>
</body>
</html>