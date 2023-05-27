package web;

import java.util.List;
import java.util.ArrayList;
import metier.entities.Produit;

public class ProduitModele {
  private String motCle;
  @SuppressWarnings("unused")
  private int idProduits;
  @SuppressWarnings("unused")
private String nomProduit;
@SuppressWarnings("unused")
private Double prix;
  List<Produit> produits = new ArrayList<>();
  public String getMotCle() {
	  return motCle;
  }
  public void setMotCle(String motCle) {
	  this.motCle = motCle;
  }
  public List<Produit> getProduits(){
	  return produits;
  }
  public void setProduits(List<Produit> produits) {
	  this.produits = produits;
  }
  public void setidProduit(int idProduit) {
	  this.idProduits = idProduit;
  }
  public void setnomProduit(String nomProduit) {
	  this.nomProduit = nomProduit;
  }
  public void setPrix(Double Prix) {
	  this.prix = Prix;
  }
}
