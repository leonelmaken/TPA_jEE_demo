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
              Recherche des Produits
          </div>
          <div class="card-body">
          <form action="chercher41.do" method="get">
                <label>Mot Clé</label>
                <input type="text" name="motCle" value ="${model.motCle }">
                <button type="submit" class="btn btn-primary">chercher</button>
          </form>
          <table class="table table-striped">
          <tr>
                <th>ID</th><th>Nom du Produit</th><th>Prix</th><th>Paiement</th><th>Supprimer</th><th>Modifier</th>
          </tr>
          <c:forEach items="${model.produits}" var="p">
                <tr>
                    <td>${p.idProduit }</td>
                    <td>${p.nomProduit }</td>
                    <td>${p.prix }</td>
                    <td> 
                        <form action="https://gateway-lab.boostcompagny.com/lapas-on-trans/trans/api-payin-request?i_space_key=00EO7GnlD6R8QudSk5PGvJ0Ry6PP50OtlYUGBrqqnIfhrHBMgmTLC81mefculL86zOWmNXCiix3KOo4cNsmUzNBVwkEVefq/FIflT40dv/Fw1CeWqYEajGLNeSa9HrINbM0rCsaUFTmBfBR1NQbGUw&app_space_key=2pm6NfL810NMrfc2EyYeCZ0beJmaYzbzqWxR6qWqkAXN/LxxH2ABGniPY02C8TDb9AcdhX/xejXCmccOOaO8kTlmztbc/h2mIy1AVa7XgWuWSXFr8Olx82S2O9zyl9KdBprb7drH2gD782adhyeU8w&amount=${p.prix}&phonenumber=237672477407&order_id=${p.nomProduit }&prix=${p.prix }" method="post">
			               <button type="submit" class="btn btn-primary">Pay</button>
			          </form> 
                    </td>
			          
			        <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimer.do?id=${p.idProduit }">Supprimer</a></td>
                    <td><a href="editer.do?id=${p.idProduit }">Modifier</a></td>                     
                </tr>          
          </c:forEach>
          </table>
          </div>
        </div>
</div>		   
</body>
</html>