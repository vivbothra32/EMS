package com.cg.dao;
/**
 * @project Employee Maintenance System
 * @author Group2(Anurag, Pritam, Ruchi, Vivek, Zeeshan)
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.beans.Department;

import oracle.jdbc.driver.OracleDriver;

public class DepartmentDaoImpl implements DepartmentDao {
	private Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, "anurag", "oracle");
		return conn;

	}
	@Override
	public Department fetchDepartment(String code) {
		String sql = "Select * from Department where Dept_Name = ?";
		Connection conn = null;
		Department d = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				d = new Department();
				d.setId(rs.getInt(1));
				d.setDname(rs.getString(2));
			}
			return d;
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
