package com.cg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	

	public boolean checkManagerId(String mgrId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String saveEmployee(Employee employee) {
		Connection conn =null;
		
		conn=JdbcUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(addQuery);
		stmt.setString(1,employee.getFirstName());
		stmt.setString(2,employee.getLastName());
		//stmt.setString(3, employee.getDateOfBirth());
		//stmt.setString(4, employee.getDateOfJoining());
		stmt.setInt(5, employee.getEmpDeptId());
		stmt.setString(6, employee.getGradeCode());
		stmt.setString(7, employee.getGradeDescription());
		stmt.setDouble(8,employee.getBasic());
		stmt.setString(9, employee.getGender());
		stmt.setString(10, employee.getMaritalStatus());
		stmt.setString(11, employee.getHomeAddress());
		stmt.setString(12, employee.getContactNo());
		stmt.setString(13, employee.getMgrId());
		
		stmt.executeUpdate();
		ResultSet rs=conn.createStatement().executeQuery(seqQuery);
		if(rs.next()) 
			return rs.getString(1);
		else 
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
		// TODO Auto-generated method stub
		return null;
	}

}
