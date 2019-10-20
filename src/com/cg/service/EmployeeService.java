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

	Employee saveEmployee(Employee employee);

	Employee fetchEmployee(String empId);

	String modifyEmployee(Employee employee);

	List<Employee> fetchAllEmployees();
}