package br.com.interage.business.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDto {

	private Short empNo;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneExt;
	
	private Date hireDate;
	
	private BigDecimal salary;
	
	private String fullName;
	
	private String deptNo;
	
	public EmployeeDto(Short empNo, String firstName, String lastName, String phoneExt, Date hireDate, BigDecimal salary, String fullName) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneExt = phoneExt;
		this.hireDate = hireDate;
		this.salary = salary;
		this.fullName = fullName;
	}

	public EmployeeDto() {
	}

	public Short getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Short empNo) {
		this.empNo = empNo;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneExt() {
		return phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneExt="
				+ phoneExt + ", hireDate=" + hireDate + ", salary=" + salary + ", fullName=" + fullName + ", deptNo="
				+ deptNo + "]";
	}
	
}
