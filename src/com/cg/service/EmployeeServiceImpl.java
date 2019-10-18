package com.cg.service;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.cg.beans.Department;
import com.cg.beans.Employee;
import com.cg.beans.Grade;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	String nameRule = "[A-Z][a-z]{24}";
	String empIdRule = "[1-9][0-9]{5}";
	String dateRule = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])[0-9]{2})$";
	
	private EmployeeDao dao;
	@Override
	public boolean validateFirstName(String firstName) {
		return firstName.matches(nameRule);
	}

	@Override
	public boolean validateLastName(String lastName) {
		return lastName.matches(nameRule);
	}

	@Override
	public boolean validateEmpId(String empId) {
		return empId.matches(empIdRule);
	}

	@Override
	public boolean validateGender(String gender) {
		if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
			return true;
		else {
			System.out.println("Invalid Input. Enter gender again.");
			return false;
		}
	}

	@Override
	public boolean validateMaritalStatus(String maritalStatus) {
		List<String> marital = Arrays.asList("Single", "Married", "Divorced", "Separated", "Widowed");
		int k = 0;
		for(String flag : marital){
			if(flag.equalsIgnoreCase(maritalStatus)){
				maritalStatus = flag;
				k = -1;
				break;
			}
		} 
		if(k!=-1) {
			System.out.println("Invalid Input. Enter Again");
			return false;
		}else
			return true;
	}

	@Override
	public boolean validateDateOfBirth(String sdob) {
		if(!sdob.matches(dateRule)) {
			System.out.println("Invalid Format. Enter date again.");
			return false;
		}
		return true;
		
	}

	@Override
	public boolean validateDateOfJoining(String sdoj) {
		if(!sdoj.matches(dateRule)) {
			System.out.println("Invalid Format. Enter date again.");
			return false;
		}
		return true;
	}

	@Override
	public boolean validateMgrId(String mgrId) {
		return mgrId.matches(empIdRule);
	}

	@Override
	public boolean checkMgrId(String mgrId) {
		return (new EmployeeDaoImpl().checkManagerId(mgrId));
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Override
	public Employee fetchEmployee(String empId) {
		return dao.fetchEmployee(empId);
	}

	@Override
	public String modifyEmployee(Employee employee) {
		return dao.modifyEmployee(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return dao.fetchAllEmployees();
	}


}
