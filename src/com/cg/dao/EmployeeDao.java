package com.cg.dao;
import java.util.List;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Employee;

public interface EmployeeDao {
	public boolean checkManagerId(String mgrId);

	public Employee saveEmployee(Employee employee);

	public Employee fetchEmployee(String empId);

	public String modifyEmployee(Employee employee);

	public List<Employee> fetchAllEmployees();
}
