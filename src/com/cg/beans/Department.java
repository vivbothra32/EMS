package com.cg.beans;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */

public class Department {
	
	/**
	 * @description Department bean
	 * @param id, dname 
	 * @author Vivek
	 */
	private int id;
	private String dname;
	public Department() {
		
	}
	
	public Department(int id, String dname) {
		this.id = id;
		this.dname = dname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	//add toString() method	
}
