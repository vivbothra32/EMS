package com.cg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;

import oracle.jdbc.driver.OracleDriver;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, "anurag", "oracle");
		return conn;
	}

	public boolean checkManagerId(String mgrId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee fetchEmployee(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyEmployee(Employee employee) {
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(updateEmployee);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setDate(3, Date.valueOf(employee.getDateOfBirth()));
			stmt.setDate(4, Date.valueOf(employee.getDateOfJoining()));
			stmt.setInt(5, employee.getEmpDeptId());
			stmt.setString(6, employee.getGradeCode());
			stmt.setString(7, employee.getGradeDescription());
			stmt.setDouble(8, employee.getBasic());
			stmt.setString(9, employee.getGender());
			stmt.setString(10, employee.getMaritalStatus());
			stmt.setString(11, employee.getHomeAddress());
			stmt.setString(12, employee.getContactNo());
			stmt.setString(13, employee.getMgrId());
			stmt.setString(14, employee.getEmpId());

			stmt.executeUpdate();
			ResultSet rs = conn.createStatement();
			if (rs.next())
				return Integer.toString(rs.getInt(1));
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		Connection conn = null;
		Employee e = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(fetchAllEmployee);
			ResultSet rs = stmt.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				e = new Employee();
				e.setEmpId(rs.getString(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setDateOfBirth(rs.getDate(4));
				e.setDateOfJoining(rs.getDate(5));
				e.setEmpDeptId(rs.getInt(6));
				e.setGradeCode(rs.getString(7));
				e.setGradeDescription(rs.getString(8));
				e.setBasic(rs.getDouble(9));
				e.setGender(rs.getString(10));
				e.setMaritalStatus(rs.getString(11));
				e.setHomeAddress(rs.getString(12));
				e.setContactNo(rs.getString(13));
				e.setMgrId(rs.getString(14));
				list.add(e);
			}
			return list;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}