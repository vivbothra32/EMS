package com.cg.cli;

/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.beans.Department;
import com.cg.beans.Employee;
import com.cg.beans.Grade;
import com.cg.beans.User;
import com.cg.service.DepartmentService;
import com.cg.service.DepartmentServiceImpl;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;
import com.cg.service.GradeService;
import com.cg.service.GradeServiceImpl;
import com.cg.service.UserService;
import com.cg.service.UserServiceimpl;

public class EMSApplication {
	/**
	 * Static objects defined
	 */
	private static Scanner scanner;
	private static UserService uservice;
	private static EmployeeService eservice;
	private static DepartmentService dservice;
	private static GradeService gservice;

	/**
	 * Static block, implements even before the main method
	 */
	static {
		scanner = new Scanner(System.in);
		uservice = new UserServiceimpl();
		eservice = new EmployeeServiceImpl();
		dservice = new DepartmentServiceImpl();
		gservice = new GradeServiceImpl();
	}

	/**
	 * @description main method of Employee Maintenance System Client Interface
	 * @author Group 2.
	 */
	public static void main(String[] args) {
		int userTypeChoice;
		System.out.println("WELCOME TO EMPLOYEE MAINTENANCE SYSTEM.");
		do {
			System.out.println("==============================================");
			System.out.println("Enter 1 to Sign In.");
			System.out.println("Enter 0 to Exit.");
			System.out.println("==============================================");
			userTypeChoice = scanner.nextInt();
			switch (userTypeChoice) {
			case 1:
				signIn();
			case 0:
				System.out.println("TERMINATED !");
				System.exit(0);
			default:
				System.out.println("Invalid choice entered.\nProvide a valid input.");
			}
		} while (true);

	}

	/**
	 * @description performs the sign in operation when user chooses option 1.
	 * @author Vivek
	 */
	public static void signIn() {
		System.out.println("==============================================");
		System.out.println("Sign In: ");
		User user = new User();
		String userId;
		String userName;
		String userType;
		String password;
		System.out.print("Enter User ID : ");
		userId = scanner.next();
		System.out.print("Enter your User Name : ");
		userName = scanner.next();
		System.out.print("Enter your Password : ");
		password = scanner.next();

		// Checking the user type entered. Should be either Admin/Employee
		while (true) {
			System.out.print("Enter user type : Admin/Employee ");
			userType = scanner.next();

			// ignore case will be better here because I would like to type like EmPlOyEe
			// Mah lyf mah rulezz :p

			if (userType.equalsIgnoreCase("Admin") || userType.equalsIgnoreCase("Employee")) {
				break;
			} else {
				continue;
			}
		}

		user.setUserId(userId);
		user.setPassword(password);
		user.setUserName(userName);
		user.setUserType(userType);

		/**
		 * User object is passed to service method validateUser to check if the user
		 * information is present in user_master database table. If user is found,
		 * Admin/Employee specific functions are provided.
		 */
		User flag = uservice.validateUser(user);
		if (flag == null) {
			System.out.println("No user found. Login unsuccessful.");
		} else {
			System.out.println("User Found. logged in as " + flag.getUserType());
			if (flag.getUserType().equalsIgnoreCase("Admin")) {
				adminLogin(flag);
			} else {
				employeeLogin(flag);
			}
		}
	}

	private static void employeeLogin(User flag) {
		// TODO Auto-generated method stub
		eservice.fetchEmployeeFilter(ID, First Name, Last Name, department, Grade, Marital Status);
		
	}

	/**
	 * @description static function adminLogin. Provides the functions specific to
	 *              Admin type user.
	 * @author Vivek
	 */
	private static void adminLogin(User flag) {
		int choice;
		do {
			System.out.println("==============================================");
			System.out.println("Enter 1 to Add Employee");
			System.out.println("Enter 2 to Modify Employee Details");
			System.out.println("Enter 3 to Display Employee Details");
			System.out.println("Enter 0 to exit.");
			System.out.println("==============================================");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addEmployee(); // Control shifts to addEmployee function on choosing 1.
				break;
			case 2:
				modifyEmployee(); // Control shifts to modifyEmployee function on choosing 2.
				break;
			case 3:
				displayEmployee(); // Control shifts to displayEmployee function on choosing 3.
				break;
			case 0:
				System.exit(0); // Exiting the control when ) is entered.
			default:
				System.out.println("Invalid choice entered"); // Default message when none of 0 - 3 is entered
			}
		} while (true);
	}

	/**
	 * @description 1st privilege of Admin type user. Function to modify the
	 *              employee details.
	 * @author Vivek
	 */
	private static void modifyEmployee() {
		System.out.println("MODIFYING EXISTING EMPLOYEE DETAILS");
		String empId = "", firstName = "", lastName = "", maritalStatus = "", homeAddress = "", contactNo = "",
				gradeDescription = "", gradeCode = "";
		double basic = 0.0;
		int deptId = 0;

		do {
			System.out.print("Enter Employee ID : ");
			empId = scanner.next();
		} while (!eservice.validateEmpId(empId));

		Employee emp = eservice.fetchEmployee(empId);
		if (emp == null) {
			System.out.println("Employee with entered employee ID doesn't exist.");
		} else {
			System.out.println("Existing data for Employee ID : " + empId);
			System.out.println(emp.toModifyEmployee());
			System.out.println("Enter the new details. Enter '-' to keep the record unchanged.");
			do {
				System.out.print("Enter first name : ");
				firstName = scanner.next();
				if (firstName.equals("-")) {
					firstName = emp.getFirstName();
					break;
				}
			} while (eservice.validateFirstName(firstName));

			do {
				System.out.print("Enter last name : ");
				lastName = scanner.next();
				if (lastName.equals("-")) {
					lastName = emp.getLastName();
					break;
				}
			} while (eservice.validateLastName(lastName));

			do {
				System.out.print("Enter the marital status : ");
				System.out.print("Single / Married / Divorced / Separated / Widowed ->");
				maritalStatus = scanner.next();
				if (maritalStatus.equals("-")) {
					maritalStatus = emp.getMaritalStatus();
					break;
				}
			} while (!eservice.validateMaritalStatus(maritalStatus));

			do {
				System.out.print("Enter Home Address : ");
				String address = scanner.next();
				if (address.equals("-")) {
					homeAddress = emp.getHomeAddress();
					break;
				}
			} while (true);

			do {
				System.out.print("Enter Contact No. : ");
				String number = scanner.next();
				if (number.equals("-")) {
					contactNo = emp.getContactNo();
					break;
				}
			} while (true);
			boolean flag = false;
			do {
				System.out.print("Enter Department Name : ");
				String dname = scanner.next();
				if (dname.equals("-")) {
					deptId = emp.getEmpDeptId();
				} else {
					Department d = dservice.findDepartment(dname);
					if (d != null) {
						deptId = d.getId();
						flag = true;
					} else {
						dname = "";
						d = null;
						flag = false;
					}
				}
			} while (flag == false);

			Grade g = null;
			do {
				System.out.print("Enter Grade : ");
				String grade = scanner.next();
				if (grade.contentEquals("-")) {
					gradeDescription = emp.getGradeDescription();
					gradeCode = emp.getGradeCode();
				} else {
					g = gservice.findGrade(grade);
					if (g != null) {
						gradeDescription = g.getDescription();
						gradeCode = g.getCode();
						flag = true;
					} else {
						gradeCode = null;
						g = null;
						flag = false;
					}
				}
			} while (flag == false);

			do {
				System.out.print("Enter Basic salary : ");
				String tempbasic = scanner.next();
				if (tempbasic.equals("-"))
					basic = emp.getBasic();
				else {
					basic = Double.parseDouble(tempbasic);
					if (basic > g.getMinSalary() && basic < g.getMaxSalary())
						flag = true;
					else {
						System.out.println("Basic salary is not per the slab specified. Enter again. ");
						flag = false;
					}
				}
			} while (flag == false);
		}

		Employee employee = new Employee();

		employee.setEmpId(empId);
		employee.setFirstName(firstName);
		employee.setLastname(lastName);
		employee.setDateOfBirth(emp.getDateOfBirth());
		employee.setDateOfJoining(emp.getDateOfJoining());
		employee.setEmpDeptId(deptId);
		employee.setGender(emp.getGender());
		employee.setMaritalStatus(maritalStatus);
		employee.setHomeAddress(homeAddress);
		employee.setContactNo(contactNo);
		employee.setBasic(basic);
		employee.setGradeCode(gradeCode);
		employee.setGradeDescription(gradeDescription);
		employee.setMgrId(emp.getMgrId());

		String k = eservice.modifyEmployee(employee);

		if (k.equals("")) {
			System.out.println("Employee details could not be modified in the database.");
		} else {
			System.out.println("Employee id: " + emp.getEmpId() + " updated.");
		}

	}

	/**
	 * @description 2nd privilege of Admin type user. Function to add new user
	 *              details.
	 * @author Vivek
	 */
	private static void addEmployee() {
		Employee employee = new Employee();
		String empId, firstName, lastName, gender, maritalStatus, homeAddress, contactNo, mgrId = "",
				gradeDescription = "", description, gradeCode;
		Date dateOfBirth = null, dateOfJoining = null;
		double basic;
		int deptId = 0;

		do {
			System.out.print("Enter Employee ID : ");
			empId = scanner.next();
		} while (!eservice.validateEmpId(empId));

		do {
			System.out.print("Enter first name : ");
			firstName = scanner.next();
		} while (eservice.validateFirstName(firstName));

		do {
			System.out.print("Enter last name : ");
			lastName = scanner.next();
		} while (eservice.validateLastName(lastName));
		Date dob = null;
		boolean flag = false;
		do {
			String sdob;
			do {
				System.out.print("Enter date of birth in dd-mm-yyyy format: ");
				sdob = scanner.next();

			} while (!eservice.validateDateOfBirth(sdob));
			try {
				dob = new SimpleDateFormat("dd-MM-yyyy").parse(sdob);
				LocalDate date = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate sysdate = LocalDate.now();
				Period period = date.until(sysdate);
				if (period.get(ChronoUnit.YEARS) < 18 || period.get(ChronoUnit.YEARS) > 58) {
					System.out.println("Age of the employee does not conform to the standards. Enter DOB again.");
					sdob = "";
					dob = null;
					date = null;
					sysdate = null;
					flag = false;
				} else {
					dateOfBirth = dob;
					flag = true;
				}
			} catch (ParseException e) {
				System.out.println("Date format entered was incorrect. Enter again.");
			}
		} while (flag == false);
		flag = false;
		Date doj = null;
		do {
			String sdoj;
			do {
				System.out.print("Enter date of joining in dd-mm-yyyy format: ");
				sdoj = scanner.next();

			} while (!eservice.validateDateOfJoining(sdoj));
			try {
				doj = new SimpleDateFormat("dd-MM-yyyy").parse(sdoj);
				LocalDate jdate = doj.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate bdate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Period period = jdate.until(bdate);
				if (period.get(ChronoUnit.YEARS) > 0) {
					System.out
							.println("DAte of Joining of employee does not conform to the standards. Enter DOJ again.");
					sdoj = "";
					doj = null;
					jdate = null;
					bdate = null;
					flag = false;
				} else {
					dateOfJoining = doj;
					flag = true;
				}
			} catch (ParseException e) {
				System.out.println("Date format entered was incorrect. Enter again.");
			}
		} while (flag == false);

		do {
			System.out.print("Enter Gender : ");
			System.out.print("Male / Female ->");
			gender = scanner.next();
		} while (!eservice.validateGender(gender));

		do {
			System.out.print("Enter the marital status : ");
			System.out.print("Single / Married / Divorced / Separated / Widowed ->");
			maritalStatus = scanner.next();
		} while (!eservice.validateMaritalStatus(maritalStatus));
		flag = true;
		do {
			System.out.println("Home Address is optional. Enter '-' to leave it blank");
			System.out.print("Enter Home Address : ");
			String address = scanner.next();
			if (address.equals("-")) {
				homeAddress = null;
				break;
			} else {
				homeAddress = address;
				break;
			}
		} while (true);
		flag = true;
		do {
			System.out.println("Personal Contact No. is optional. Enter '-' to leave it blank");
			System.out.print("Enter Contact No. : ");
			String number = scanner.next();
			if (number.equals("-")) {
				contactNo = null;
				break;
			} else {
				contactNo = number;
				break;
			}
		} while (true);
		flag = false;
		Department d = null;
		do {
			System.out.print("Enter Department Name : ");
			String dname = scanner.next();
			d = dservice.findDepartment(dname);
			if (d != null) {
				// empDept = d;
				// deptName = d.getDname();
				deptId = d.getId();
				flag = true;
			} else {
				dname = "";
				d = null;
				flag = false;
			}

		} while (flag == false);
		Grade g = null;
		do {
			System.out.print("Enter Grade : ");
			String grade = scanner.next();
			g = gservice.findGrade(grade);
			if (g != null) {
				// empDept = d;
				gradeDescription = g.getDescription();
				gradeCode = g.getCode();
				flag = true;
			} else {
				gradeCode = null;
				g = null;
				flag = false;
			}
		} while (flag == false);
		flag = false;
		do {
			System.out.print("Enter Basic salary : ");
			basic = scanner.nextDouble();
			if (basic > g.getMinSalary() && basic < g.getMaxSalary())
				flag = true;
			else {
				System.out.println("Basic salary is not per the slab specified. Enter again. ");
				flag = false;
			}
		} while (flag == false);

		do {
			do {
				System.out.print("Enter Manager ID : ");
				mgrId = scanner.next();
			} while (!eservice.validateMgrId(mgrId));

			if (mgrId != empId) {
				flag = eservice.checkMgrId(mgrId);
				if (flag == false) {
					System.out.println("Manager ID must be an exixting Employee. Enter ID again.");
					mgrId = "";
				} else {
					flag = true;
					break;
				}
			}
		} while (flag == false);

		employee.setEmpId(empId);
		employee.setFirstName(firstName);
		employee.setLastname(lastName);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDateOfJoining(dateOfJoining);
		employee.setEmpDeptId(deptId);
		employee.setGender(gender);
		employee.setMaritalStatus(maritalStatus);
		employee.setHomeAddress(homeAddress);
		employee.setContactNo(contactNo);
		employee.setBasic(basic);
		employee.setGradeCode(gradeCode);
		employee.setGradeDescription(gradeDescription);
		employee.setMgrId(mgrId);

		String emp = eservice.saveEmployee(employee);

		if (emp == null) {
			System.out.println("Employee details could not be added in the database.");
		} else {
			System.out.println("Employee with id " + employee.getEmpId() + " added.");
		}
	}

	/**
	 * @description 3rd privilege of Admin type user. Function to display the
	 *              employee details.
	 * @author Vivek
	 */
	private static void displayEmployee() {
		List<Employee> employees = eservice.fetchAllEmployees();
		System.out.println("EMPLOYEE DETAILS :- ");
		for (Employee emp : employees) {
			System.out.println("Name\t" + "First Name\t" + "Last Name\t" + "Department\t" + "Grade\t" + "Designation");
			System.out.println(emp.getEmpId() + "\t" + emp.getFirstName() + "\t" + emp.getLastName() + "\t"
					+ emp.getEmpDeptId() + "\t" + emp.getGradeCode() + "\t" + emp.getGradeDescription());
		}
	}
}