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

import com.cg.beans.Department;
import com.cg.beans.Grade;

import oracle.jdbc.driver.OracleDriver;

public class GradeDaoImpl implements GradeDao {

	private Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, "vivek", "oracle");
		return conn;

	}
	@Override
	public Grade fetchGrade(String grade) {
		String sql = "Select * from Grade_Master where Grade_Code = ?";
		Connection conn = null;
		Grade g = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, grade);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				g = new Grade();
				g.setCode(rs.getString(1));
				g.setDescription(rs.getString(2));
				g.setMinSalary(rs.getDouble(3));
				g.setMaxSalary(rs.getDouble(4));
			}
			return g;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}

