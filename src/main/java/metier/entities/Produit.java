package metier.entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maken
 *
 */
@SuppressWarnings("serial")
public class Produit implements Serializable{

	 private static final AtomicInteger ID_FACTORY = new AtomicInteger(0); 
	 private Long idProduit;
     private String nomProduit;
     private double prix;
     
     public Produit() {
    	 super();
     }
     public Produit(String nomProduit, double prix) {
    	 super();
    	 idProduit = (long) ID_FACTORY.getAndIncrement();
    	 this.nomProduit = nomProduit;
    	 this.prix = prix;
     }
     public Long getIdProduit() {
    	 return idProduit;
     }
     public void setIdProduit(long idProduit) {
    	 this.idProduit = idProduit;
     }
     public String getNomProduit() {
    	 return nomProduit;
     }
     public void setNomProduit(String nomProduit) {
    	 this.nomProduit = nomProduit;
     }
     public double getPrix() {
    	 return prix;
     }
     public void setPrix(double prix) {
    	 this.prix = prix;
     }
     public String toString() {//pour afficher les valeur du produits dans le terminal
    	 return "idProduit " + this.idProduit +
    			  " Nom Produit : " + this.nomProduit +
    			  ", montant " + this.prix;
     }
     
   }