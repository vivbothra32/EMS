package com.cg.beans;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
public class Grade {
	/**
	 * @description Grade Bean
	 * @param code, description, minSalary, maxSalary
	 * @author Vivek
	 */
	private String code;
	private String description;
	private double minSalary;
	private double maxSalary;
	
	public Grade() {
		
	}
	
	//parameterized constructor
	public Grade(String code, String description, double minSalary, double maxSalary) {
		this.code = code;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	/**
	 * getters and setters defined 
	 */
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	
}
