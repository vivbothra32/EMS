package com.cg.service;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Department;
import com.cg.dao.DepartmentDao;
import com.cg.dao.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao dao;
	
	public DepartmentServiceImpl() {
		dao = new DepartmentDaoImpl();
	}
	@Override
	public Department findDepartment(String dname) {
		return dao.fetchDepartment(dname);
	}
	

}
