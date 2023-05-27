package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.ConnectionDataBase;
import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao{
	Connection conn = ConnectionDataBase.getConnection();
	
	public ProduitDaoImpl () {//constructeur de produits
		this.conn = ConnectionDataBase.getConnection();
		System.out.println("conn in constructor :"+conn);
	}

	@Override
	public Produit save(Produit produit) {
	  System.out.println("conn :"+conn);
	  try {
		  PreparedStatement ps = conn.prepareStatement("INSERT INTO produits(ID_PRODUIT,NOM_PRODUIT,PRIX) Value(?,?,?)");
		  long count = countLigne();
		  
		   produit.setIdProduit(count);
		  ps.setDouble(1, produit.getIdProduit());
		  ps.setString(2, produit.getNomProduit());
		  ps.setDouble(3, produit.getPrix());
		  System.out.println("produit :"+ produit );
		  ps.executeUpdate();
		  PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_PRODUIT) as MAX_ID FROM produits");
		  ResultSet rs = ps2.executeQuery();
		  if(rs.next()) {
			  produit.setIdProduit(rs.getLong("MAX_ID"));
		  }
		  ps.close();
		  ps2.close();
	  }catch (SQLException e) {
		  e.printStackTrace();
	  }
	  return produit;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		List<Produit> prods = new ArrayList<Produit>();
		try {
			new ProduitDaoImpl();
			System.out.println("conn :"+conn);
			PreparedStatement ps = conn.prepareStatement("SELECT * from produits where (NOM_PRODUIT LIKE ?)");
			System.out.println("Le produit : "+ conn);
			ps.setString(1,"%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit produit = new Produit();
				produit.setIdProduit(rs.getLong("ID_PRODUIT"));
				produit.setNomProduit(rs.getString("NOM_PRODUIT"));
				produit.setPrix(rs.getDouble("PRIX"));
				prods.add(produit);
				
				System.out.println(produit.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	

	@Override
	public Produit getProduit(Long id) {
	    
		   Connection conn=ConnectionDataBase.getConnection();
		    Produit p = new Produit();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from produits where ID_PRODUIT = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				p.setIdProduit(rs.getLong("ID_PRODUIT"));
				p.setNomProduit(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return p;
	}
	@Override
	public Produit updateProduit(Produit p) {
		Connection conn=ConnectionDataBase.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE produits SET NOM_PRODUIT=?,PRIX=? WHERE ID_PRODUIT=?");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix());
			ps.setLong(3, p.getIdProduit());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit deleteProduit(Long id) {
		 Connection conn=ConnectionDataBase.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM produits WHERE ID_PRODUIT = ?");
			ps.setLong(1, id);
			int returnInt = ps.executeUpdate();
			System.out.println("returnInt: "+returnInt);
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	 public int countLigne(){
		 Statement stmt;
		try {
			stmt = conn.createStatement();

	    	 String query = "select count(*) from produits";
	         //Executing the query
	         ResultSet rs = stmt.executeQuery(query);
	         //Retrieving the result
	         rs.next();
	         int count = rs.getInt(1);
	         System.out.println("Le nombre d'éléments présent dans la table produits est : "+count);
	         return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
     }

	
}
