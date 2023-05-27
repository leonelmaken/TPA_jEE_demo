package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})//remplace le web.xml
public class ControleurServlet extends HttpServlet{
     private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
     IProduitDao metier;
          
     @Override
     public void init() throws ServletException {
    	 metier = new ProduitDaoImpl();//implémentation de la servlet
     }
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String path = request.getServletPath();
    	 if(path.equals("/index.do"))
    	 {
    		 request.getRequestDispatcher("produits.jsp").forward(request, response);//appel la vue .jsp
    	 }
    	 else if (path.equals("/chercher41.do"))
    	 {
    		 String motCle = request.getParameter("motCle");
    		 ProduitModele model = new ProduitModele();//instance de la classe produit
    		 model.setMotCle(motCle);
    		 List<Produit> prods = metier.produitParMC(motCle);//prods est une liste de produits retournée par la méthode produitParMC 
    		 model.setProduits(prods);
    		 request.setAttribute("model", model);
    		 request.getRequestDispatcher("produits.jsp").forward(request, response);
    	 }
    	 else if (path.equals("/saisie.do")  )
 		{
 			request.getRequestDispatcher("saisieProduit.jsp").forward(request,response);
 		}
 		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
 		{
 		    String nom=request.getParameter("nom");
 			double prix = Double.parseDouble(request.getParameter("prix"));
 			Produit p = metier.save(new Produit(nom,prix));
 			request.setAttribute("produit", p);
 			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
 		}
 		else if (path.equals("/supprimer.do"))
 		{
 		    Long id= Long.parseLong(request.getParameter("id"));
 		    metier.deleteProduit(id);
 		    response.sendRedirect("chercher41.do?motCle=");
 					
 			//request.getRequestDispatcher("BibliothequeView.jsp").forward(request,response);
 		}
 		else if (path.equals("/editer.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Produit p = metier.getProduit(id);
		    request.setAttribute("produit", p);
			request.getRequestDispatcher("editerProduit.jsp").forward(request,response);
		}
		else if (path.equals("/update.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 double prix = Double.parseDouble(request.getParameter("prix"));
			 Produit p = new Produit();
			 p.setIdProduit(id);
			 p.setNomProduit(nom);
			 p.setPrix(prix);
			 metier.updateProduit(p);
			 request.setAttribute("produit", p);
			 request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
    	 else if (path.equals("/paiement.do"))
    	 {
    		 int idProduit = Integer.parseInt(request.getParameter("idProduit"));
    		 String nomProduit = request.getParameter("nomProduit");
    		 Double prix = Double.parseDouble(request.getParameter("prix"));
    		 ProduitModele model = new ProduitModele();//instance de la classe produit
    		 model.setidProduit(idProduit);
    		 model.setnomProduit(nomProduit);
    		 model.setPrix(prix);
    		 request.setAttribute("model", model);
    		 request.getRequestDispatcher("Paiement.jsp").forward(request, response);
    	 }
    	 else
 		{
 			response.sendError(Response.SC_NOT_FOUND);		
 		}	
     }
     @Override
 	protected void doPost(HttpServletRequest request, 
 						  HttpServletResponse response) throws ServletException, IOException {
 		doGet(request,response);
 	}
}

