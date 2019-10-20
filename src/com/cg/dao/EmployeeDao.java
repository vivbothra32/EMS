package com.cg.dao;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;

public interface EmployeeDao {
	
	String addQuery="insert into Employees values (seq_emp.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String seqQuery="select seq_emp.currval from dual";
	public boolean checkManagerId(String mgrId);

	public String saveEmployee(Employee employee);

	public Employee fetchEmployee(String empId);

	public String modifyEmployee(Employee employee);

	public List<Employee> fetchAllEmployees();
}
