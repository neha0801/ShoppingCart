package customTools;

import java.util.List;

import model.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ShoppingCart");

	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
	
	public static List<Product> getAllProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String sql = "select p from Product p";
		System.out.println(sql);
		TypedQuery<Product> query= em.createQuery(sql, Product.class);
		List<Product> productList;
		try{
			productList=query.getResultList();
			if(productList==null||productList.isEmpty())
				productList=null;
		}finally{
			em.close();
		}		
		return productList;
	}
	
	public static Product getSelectedProducts(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String sql = "select p from Product p where p.productid=" + id;
		System.out.println(sql);
		TypedQuery<Product> query= em.createQuery(sql, Product.class);
		Product product;
		try{
			product=query.getSingleResult();
			if(product==null)
				product=null;
		}finally{
			em.close();
		}		
		return product;
	}
}
