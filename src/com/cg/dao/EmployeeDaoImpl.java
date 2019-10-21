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
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.WrongIDException;

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
	public String saveEmployee(Employee employee) {
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(addQuery);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			// stmt.setString(3, employee.getDateOfBirth());
			// stmt.setString(4, employee.getDateOfJoining());
			stmt.setInt(5, employee.getEmpDeptId());
			stmt.setString(6, employee.getGradeCode());
			stmt.setString(7, employee.getGradeDescription());
			stmt.setDouble(8, employee.getBasic());
			stmt.setString(9, employee.getGender());
			stmt.setString(10, employee.getMaritalStatus());
			stmt.setString(11, employee.getHomeAddress());
			stmt.setString(12, employee.getContactNo());
			stmt.setString(13, employee.getMgrId());

			stmt.executeUpdate();
			ResultSet rs = conn.createStatement().executeQuery(seqQuery);
			if (rs.next())
				return rs.getString(1);
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
			ResultSet rs = conn.createStatement().executeQuery();
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

	@Override
	public Employee fetchEmployeeFilter(int ID, String FirstName, String LastName, int departmentId, String Grade,
			String MaritalStatus) throws EmployeeNotFoundException {
		Connection conn = null;
		Employee e = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(searchQueryAny);

			stmt.setInt(1, ID);
			stmt.setInt(2, ID);
			stmt.setString(3, FirstName);
			stmt.setString(4, FirstName);
			stmt.setString(5, LastName);
			stmt.setString(6, LastName);
			stmt.setInt(9, departmentId);
			stmt.setInt(10, departmentId);
			stmt.setString(7, Grade);
			stmt.setString(8, Grade);
			stmt.setString(11, MaritalStatus);
			stmt.setString(12, MaritalStatus);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
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
			} else
				throw new EmployeeNotFoundException("Can't find this Employee");
			return e;
		} catch (SQLException e1) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e12) {
				e12.printStackTrace();
			}
		}
	}

	@Override
	public Employee fetchEmployee(String id) throws WrongIDException {
		Connection conn = null;
		Employee e = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(getQuery);
			stmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
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
			} else
				throw new WrongIDException("Employee does not exist.");
			return e;
		} catch (SQLException e1) {
			throw new WrongIDException(e1.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}