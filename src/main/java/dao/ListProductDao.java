package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDao {
	private Connection conn;

	// return the list of products by product name
	public static List<Product> search(String charidacters) throws Exception {
		List<Product> list = new ArrayList<Product>();

		try {
			Connection conn = DBContext.getConnection();
			
			String sql = "SELECT * FROM shoppingdb.products where product_name like ? " ;

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%" + charidacters + "%");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			conn.close();

		} catch (Exception e) {

			System.out.println(e);

		}

		return list;
	}
	
	public static List<Product> getProduct(int start, int total) throws Exception{
		List<Product> list = new ArrayList<Product>();
		
		try {
			Connection conn = DBContext.getConnection();// mo ket noi voi MySQL 
			
			String sql = "select * from shoppingdb.products limit " + (start - 1) + "," + total;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// get the product
	public static Product getProduct(String character) throws Exception {
		Product p = new Product();
		int id = Integer.parseInt(character);
		
		Connection conn = DBContext.getConnection();
		
		String sql = "select * from ShoppingDB.products where product_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDescription(rs.getString(3));
			p.setPrice(rs.getFloat(4));
			p.setSrc(rs.getString(5));
			p.setType(rs.getString(6));
			p.setBrand(rs.getString(7));
			
		}
		conn.close();
		
		return p;
	}
	
	public static Product getLast() throws Exception {
		
		Connection conn = DBContext.getConnection();
		Product p = new Product();
		
		String SQL = "SELECT * FROM shoppingdb.products\r\n"
				+ "ORDER BY product_id desc limit 1;";
		PreparedStatement ps = conn.prepareStatement(SQL);
				
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDescription(rs.getString(3));
			p.setPrice(rs.getFloat(4));
			p.setSrc(rs.getString(5));
			p.setType(rs.getString(6));
			p.setBrand(rs.getString(7));
			
		}
		conn.close();
		
		return p;
	}
	
	public static void main(String[] args) {
		ListProductDao dao = new ListProductDao();
		try {
			LocalDate date = LocalDate.now();
//			java.util.Date date = new java.util.Date();
			System.out.println(date);
//			Product p = dao.getProduct("" + 1);
			List<Product> list = dao.search("iPhone 6");
//			List<Product> list = dao.getProduct(1, 6);
//			Product p = dao.getLast();
//			System.out.println(p);
			if(list.isEmpty()) {
				System.out.println("khong ton tai");
			}
			for(Product ps : list) {
				System.out.println(ps);
			}
//			System.out.println(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
