package com.journaldev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.journaldev.model.Product;
import com.journaldev.servlet.RegisterServlet;

public class ProductDAOImpl {

	private Connection con = null;
	//private PreparedStatement ps = null;
	private ResultSet rs = null;
	static Logger logger = Logger.getLogger(RegisterServlet.class);
	
	public ProductDAOImpl() {
		
		
	}
	
	public ProductDAOImpl(Connection con) {
		this.con = con;
		
	}


	public void addProduct(Product product) throws SQLException{
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement("insert into Products(productName,productPrice) values (?,?)");
			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getProductPrice());
			ps.execute();
			ps.close();
		}finally{
			
			
			
		}
			
		System.out.println("Add product: name = "+product.getProductName() + " price = " + product.getProductPrice());
		logger.info("Add product: name = "+product.getProductName() + " price = " + product.getProductPrice());
		
	}
	
	public List<Product> getAllProducts() /*throws SQLException*/{
		/*Statement statement = con.createStatement();
		List<Product> allProducts = new ArrayList<>();
		Product product = null;
		ResultSet rs = null;
		String query = "select * from Products";
		try {
			rs = statement.executeQuery(query);
			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				allProducts.add(product);
			}
			rs.close();
            statement.close();
		}finally {
			if (rs != null)
				rs.close();
			
		}*/
		
		List<Product> productLst = new ArrayList<Product>();
		 	
		productLst.add(new Product("Phone0",2.00, "Phone0 description"));
		productLst.add(new Product("Phone1",10.00,"Phone1 description"));
		productLst.add(new Product("Phone2",20.00,"Phone2 description"));
		productLst.add(new Product("Phone3",30.00,"Phone3 description"));

		return productLst;
	}
}
