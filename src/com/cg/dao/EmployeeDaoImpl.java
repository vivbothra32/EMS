package com.cg.dao;
import java.sql.Connection;
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

public class EmployeeDaoImpl implements EmployeeDao{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		Connection conn=null;
		Employee e=null;
		String sql = "SELECT * FROM Employee";
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Employee> list=new ArrayList<Employee>();
			while(rs.next()) {
				e=new Employee();
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
		}
		finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
