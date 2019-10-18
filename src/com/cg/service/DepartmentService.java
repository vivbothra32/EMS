package com.cg.service;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Department;

public interface DepartmentService {

	Department findDepartment(String dname);

}
