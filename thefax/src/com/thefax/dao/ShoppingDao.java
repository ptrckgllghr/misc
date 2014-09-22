package com.thefax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.thefax.bean.LoginBean;
import com.thefax.bean.ProductBean;
import com.thefax.bean.UserBean;

public class ShoppingDao {

	private Connection newConnection() throws SQLException {
//		old message
//		ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
//		try {
//			// alternate way to register driver (ReflectionC)
//			Class.forName(bundle.getString("driver"));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Connection conn = DriverManager.getConnection(bundle.getString("url"),
//				bundle.getString("user"), bundle.getString("pass"));
//		return conn;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource dataSrc = (DataSource) envCtx.lookup("jdbc/myds");
			return dataSrc.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean persist(UserBean user) {
		String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = newConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getName());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getCity());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getPhone());
			stmt.setString(7, user.getPassword());
			stmt.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean validate(LoginBean login) {
		String sql = "select * from users where userid=? and password=?";
		Connection conn = null;

		try {
			conn = newConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getUserId());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<ProductBean> getCatalog() {
		String sql = "select * from PRODUCTS";
		Connection conn = null;
		ArrayList<ProductBean> catalog = null;

		try {
			conn = newConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			catalog = new ArrayList<ProductBean>();
			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setDescription(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				catalog.add(product);
			}
			return catalog;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ProductBean getProduct(String code) {
		String sql = "select * from PRODUCTS where code=" + code;
		Connection conn = null;
		ProductBean product = null;

		try {
			conn = newConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);

			if (rs.next()) {
				product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setDescription(rs.getString(2));
				product.setPrice(rs.getDouble(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}return product;
	}

}
