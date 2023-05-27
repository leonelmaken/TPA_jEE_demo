<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/paiement" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
        <div class="card">
          <div class="card-header">
              Achat des Produits
          </div>
          <div class="card-body">
          <table class="table table-striped">
          <tr>
                <th>ID</th><th>Nom du Produit</th><th>Prix</th>
          </tr>
          <c:forEach items="${model.produits}" var="p">
                <tr>
                    <td>${p.idProduit }</td>
                    <td>${p.nomProduit }</td>
                    <td>${p.prix }</td>
                </tr>          
          </c:forEach>
          </table>
          </div>
        </div>
</div>		   	 
</body>
</html>