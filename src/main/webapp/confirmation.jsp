<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="entete.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Confirmation de l'ajout d'un produit
  </div>
  <div class="card-body">
      
      <div class="form-group">
       <label class="control-label">ID :</label>
       <input type="text" name="Nom" class="form-control" value="${produit.idProduit }"/>
         
       <label class="control-label">Nom Produit :</label>
       <input type="text" name="Nom" class="form-control" value="${produit.nomProduit }"/>
      </div>
      
      <div class="control-label">
       <label class="control-label">Prix :</label>
       <input type="text" name="Prix" class="form-control" value="${produit.prix }"/>
      </div>
       </div>
         
  </div>
</div>
</body>
</html>