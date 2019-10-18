package com.cg.beans;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
public class User {
	/**
	 * @description Grade Bean
	 * @param code, description, minSalary, maxSalary
	 * @author Vivek
	 */
	private String userId;
	private String userName;
	private String password;
	private String userType;
	
	public User() {
		
	}
	//Parameterized constructor
	public User(String userId, String userName, String password, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	/**
	 * getters and setters are defined
	 */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return returns the called User object in String format
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}
}
