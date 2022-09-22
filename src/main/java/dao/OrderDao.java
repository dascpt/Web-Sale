package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;
import model.ProductOrders;

public class OrderDao {
	private Connection conn;
	//insert information of Order to data source, that including list of
	//products in cart (c) and information of buyer  in Orders o
	public void insertOrder(Orders o, Cart c) throws Exception {
		
		conn = DBContext.getConnection();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		
		String sql1 = "insert into shoppingDB.orders (user_mail, order_status, order_date, order_discount_code, order_address) values (?, ?, ?, ?, ?)";
		String sql2 = "insert into shoppingDB.orders_detail (order_id, product_id, amount_product, price_product) values (?, ?, ?, ?)";
		
		int order_id;
		
		try {
			PreparedStatement ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps1.setString(1, o.getUserMail());
			ps1.setInt(2, o.getStatus());
			ps1.setDate(3, date);
			ps1.setString(4, o.getDiscount());
			ps1.setString(5, o.getAddress());
			ps1.executeUpdate();
			
			try(ResultSet generatedKeys = ps1.getGeneratedKeys()) {
				if(generatedKeys.next()) {
					order_id = generatedKeys.getInt(1);					
				}else {
					conn.rollback();
				throw new SQLException("Orders insertion has problem.No order_id return");
				}
			}
			ps1.close();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			for(Product p : c.getItems()) {
				ps2.setInt(1, order_id);
				ps2.setInt(2, p.getId());
				ps2.setInt(3, p.getNumber());
				ps2.setDouble(4, c.getAmount());
			}
			ps2.executeUpdate();
			ps2.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		String sql = "select order_id from shoppingdb.orders limit 1";
		
//		PreparedStatement ps1 = conn.prepareStatement(sql1);
//	
//		ps1.setString(1, o.getUserMail());
//		ps1.setInt(2, o.getStatus());
//		ps1.setDate(3, date);
//		ps1.setString(4, o.getDiscount());
//		ps1.setString(5, o.getAddress());
//		
//		ps1.executeUpdate();
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ResultSet rs = ps.executeQuery();
//		int oid = 0;
//		if(rs.next()) {
//			oid = rs.getInt(1);
//		}
//		
//		PreparedStatement ps2 = conn.prepareStatement(sql2);
//		
//		for(Product x: c.getItems()) {
//			ps2.setInt(1, oid);
//			ps2.setInt(2, x.getId());
//			ps2.setInt(3, x.getNumber());
//			ps2.setDouble(4, c.getAmount());
//		}
//		ps2.executeUpdate();
//		
//		ps1.close();
//		ps2.close();
//		ps.close();
	}
	
	public List<ProductOrders> show(User acc) {
		List<ProductOrders> listOders = new ArrayList<>();
		String sql = "select orders_detail.order_id, orders_detail.product_id, orders_detail.amount_product,orders_detail.price_product  \r\n"
				+ "from \r\n"
				+ "((orders_detail\r\n"
				+ " inner join orders on orders_detail.order_id = orders.order_id)\r\n"
				+ " inner join account on orders.user_mail = account.user_mail) where orders.user_mail = ?";
		try {
			conn = DBContext.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, acc.getEmail());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 listOders.add(new ProductOrders(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getFloat(4)));
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return listOders;
		
	}
	
	public static void main(String[] args) {
		User acc = new User("quytd@fpt.com.vn", "123", 1, "Thái Duy Quý", "Đại học Đà Lạt", "1234567");
		OrderDao dao = new OrderDao();
		ListProductDao listDao = new ListProductDao();
		
		List<Product> listPro = new ArrayList<>();
		
		List<ProductOrders> proOrders = dao.show(acc);
		
		for(ProductOrders pro : proOrders) {
			try {
				listPro.add(listDao.getProduct("" + pro.getProductId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(Product p : listPro) {
			System.out.println(p);
		}
	}
}
