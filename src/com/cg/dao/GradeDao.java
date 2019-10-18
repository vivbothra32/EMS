package com.cg.dao;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.Grade;

public interface GradeDao {

	Grade fetchGrade(String grade);

}
