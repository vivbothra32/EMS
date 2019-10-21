package com.cg.service;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import java.util.Date;
import java.util.List;

import com.cg.beans.Department;
import com.cg.beans.Employee;
import com.cg.beans.Grade;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.WrongIDException;

public interface EmployeeService {

	boolean validateFirstName(String firstName);

	boolean validateLastName(String lastName);

	boolean validateEmpId(String empId);

	boolean validateGender(String gender);

	boolean validateMaritalStatus(String maritalStatus);

	boolean validateDateOfBirth(String sdob);

	boolean validateDateOfJoining(String sdoj);

	boolean validateMgrId(String empId);

	boolean checkMgrId(String mgrId);

	String saveEmployee(Employee employee);

	Employee fetchEmployeeFilter(int ID, String FirstName, String LastName, int departmentId, String Grade, String MaritalStatus) throws EmployeeNotFoundException;

	Employee fetchEmployee(String empId) throws WrongIDException;
	
	String modifyEmployee(Employee employee);

	List<Employee> fetchAllEmployees();
}