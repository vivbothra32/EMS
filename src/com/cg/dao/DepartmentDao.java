package com.cg.dao;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Department;

public interface DepartmentDao {
	
	Department fetchDepartment(String deptName);

}
