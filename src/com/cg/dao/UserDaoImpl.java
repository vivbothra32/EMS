package com.cg.dao;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.beans.User;

import oracle.jdbc.driver.OracleDriver;

public class UserDaoImpl implements UserDao {
	
	private Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, "vivek", "oracle");
		return conn;

	}

	@Override
	public User validateLogin(User user) {
		
		String sql = "select *  from user_master where userid=?  and username = ? and password=? and usertype = ?";
		Connection conn = null;
		User u = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getUserType());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(3));
				u.setPassword(rs.getString(2));
				u.setUserType(rs.getString(4));
			}
			return u;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
