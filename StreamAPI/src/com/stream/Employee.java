package com.stream;

public class Employee {
	
	private Integer empId;
	private String empName;
	private String dept;
	private Integer joinedYear;
	private Double salary;
	private String gender;
	
	
	
	public Employee(Integer empId, String empName, String dept, Integer joinedYear, Double salary, String gender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.joinedYear = joinedYear;
		this.salary = salary;
		this.gender = gender;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getJoinedYear() {
		return joinedYear;
	}
	public void setJoinedYear(Integer joinedYear) {
		this.joinedYear = joinedYear;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", joinedYear=" + joinedYear
				+ ", salary=" + salary + ", gender=" + gender + "]";
	}
	
	
	
	
	

}
