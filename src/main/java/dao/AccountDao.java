package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;
import context.DBContext;

public class AccountDao {
	private Connection conn;
	
	public User login(String user, String password) {
		String sql = "select * from shoppingdb.account where user_mail = ? and password = ?";
		
		try {
			conn = DBContext.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setString(1, user);
			
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User Exist(String email, String username) {
		String sql ="SELECT * FROM shoppingdb.account where user_mail = ? or user_name = ?";		
		try {
			conn = DBContext.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public void signup(String email, String password, String username) {
		String sql = "insert into shoppingdb.account (user_mail, password, account_role, user_name) values\r\n"
				+ "(?, ?, 1, ?)";
		
		try {
			conn = DBContext.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ps.setString(2, password);
			
			ps.setString(3, username);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
