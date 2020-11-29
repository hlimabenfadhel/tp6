<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Livres</title>
</head>
<body>
<div class="container">
<div class="card">
 <div class="card-header">
 Liste des Livres
 </div>
 <div class="card-body">

 <table class="table table-striped">
 <tr>
<th>ID</th><th>Nom Livre</th><th>Prix</th><th>Date
Cr�ation</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${livres}" var="l">
 <tr>
 <td>${l.idLivre }</td>
 <td>${l.nomLivre }</td>
 <td>${l.prixLivre }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${l.dateCreation}" /></td>
 <td><a onclick="return confirm('Etes-vous s�r ?')"
href="supprimerLivre?id=${l.idLivre }">Supprimer</a></td>
 <td><a href="modifierLivre?id=${l.idLivre }">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>