package com.cg.dao;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.WrongIDException;

public interface EmployeeDao {
	
	String addQuery="insert into Employees values (seq_emp.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String seqQuery="select seq_emp.currval from dual";
	
	String getQuery = "select * from Employee where code = ?";
	
	String fetchAllEmployee = "SELECT * FROM Emp_ID = ?";
	
	String updateEmployee = "UPDATE Employee set Emp_First_Name = ?, Emp_Last_Name = ?,Emp_Date_of_Birth = ?,"
			+ "Emp_Date_of_Joining = ?, Emp_Dept_ID = ?, Emp_Grade = ?, Emp_Designation = ?,"
			+ "Emp_Basic = ?, Emp_Gender = ?, Emp_Marital_Status = ?, Emp_Home_Address = ?,"
			+ "Emp_Contact_Num = ?, Mgr_Id = ? where Emp_ID = ?";
	  
	String searchQueryAny = "SELECT * FROM Employee where (Emp_ID = ? or  ? is null) AND (Emp_First_Name = '?' or ? is null) "
			+ "AND (Emp_Last_Name = '?' or  ? is null) AND (Emp_Grade = '?' or  ? is null) "
			+ "AND (Emp_Dept_ID = '?' or  ? is null) AND (Emp_Marital_Status = '?' or  ? is null)";
			//select * from person where(name = 'Polo' OR 'Polo' is null) AND (age = null or null is null);		
	
	public boolean checkManagerId(String mgrId);

	public String saveEmployee(Employee employee);

	public Employee fetchEmployeeFilter(int ID, String FirstName, String LastName, int departmentId, String Grade, String MaritalStatus) throws EmployeeNotFoundException;

	public String modifyEmployee(Employee employee);

	public List<Employee> fetchAllEmployees();

	public Employee fetchEmployee(String id) throws WrongIDException;
}
