package com.cg.dao;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;

public interface EmployeeDao {
	
	String fetchAllEmployee = "SELECT * FROM Employee";
	
	String updateEmployee = "UPDATE Employee set Emp_First_Name = ?, Emp_Last_Name = ?,Emp_Date_of_Birth = ?,"
			+ "Emp_Date_of_Joining = ?, Emp_Dept_ID = ?, Emp_Grade = ?, Emp_Designation = ?,"
			+ "Emp_Basic = ?, Emp_Gender = ?, Emp_Marital_Status = ?, Emp_Home_Address = ?,"
			+ "Emp_Contact_Num = ?, Mgr_Id = ? where Emp_ID = ?";
	  
	
			//select * from person where(name = 'Polo' OR 'Polo' is null) AND (age = null or null is null);		
	
	public boolean checkManagerId(String mgrId);

	public Employee saveEmployee(Employee employee);

	public Employee fetchEmployee(String empId);

	public String modifyEmployee(Employee employee);

	public List<Employee> fetchAllEmployees();
}