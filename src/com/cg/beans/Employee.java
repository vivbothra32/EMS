package com.cg.beans;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import java.util.Date;

public class Employee {
	/**
	 * @description Employee bean
	 * @param id, dname 
	 * @author Vivek
	 */
	private String empId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private int empDeptId;
	private String gradeCode;
	private String gradeDescription;
	private double basic;
	private String gender;
	private String maritalStatus;
	private String homeAddress;
	private String contactNo;
	private String mgrId;
	
	public Employee() {
		
	}
	
	//parameterized constructor
	public Employee(String empId, String firstName, String lastName, Date dateOfBirth, Date dateOfJoining,
			int empDeptId, String gradeCode, String gradeDescription, double basic, String gender, String maritalStatus,
			String homeAddress, String contactNo, String mgrId) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.empDeptId = empDeptId;
		this.gradeCode = gradeCode;
		this.gradeDescription = gradeDescription;
		this.basic = basic;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.homeAddress = homeAddress;
		this.contactNo = contactNo;
		this.mgrId = mgrId;
	}
	
	/**
	 * @description getters and setters defined
	 */
	
	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeDescription() {
		return gradeDescription;
	}

	public void setGradeDescription(String gradeDescription) {
		this.gradeDescription = gradeDescription;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDept(int empDeptId) {
		this.empDeptId = empDeptId;
	}

	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMgrId() {
		return mgrId;
	}
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}
	
	/**
	 * @description 
	 * @return returns the modifiable entries of the Employee object in String form
	 */

	public String toModifyEmployee() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", empDeptId=" + empDeptId
				+ ", gradeCode=" + gradeCode + ", gradeDescription=" + gradeDescription + ", basic=" + basic
				+ ", maritalStatus=" + maritalStatus + ", homeAddress=" + homeAddress + ", contactNo=" + contactNo
				+ "]";
	}


	
}
