package com.cg.service;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Grade;
import com.cg.dao.GradeDao;
import com.cg.dao.GradeDaoImpl;

public class GradeServiceImpl implements GradeService {
	private GradeDao dao;
	
	public GradeServiceImpl(){
		dao = new GradeDaoImpl();
	}
	@Override
	public Grade findGrade(String grade) {
		return dao.fetchGrade(grade);
	}

}
