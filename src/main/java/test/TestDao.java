package test;

import java.util.List;

import dao.ProduitDaoImpl;
import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		ProduitDaoImpl pdao = new ProduitDaoImpl();
        Produit prod = pdao.save(new Produit("iphone 12 plus",2800));
        System.out.println(prod);
        
        List<Produit> prods = pdao.produitParMC("2");
        for(Produit p : prods) {
        	System.out.println(p);
        }
	}

}
