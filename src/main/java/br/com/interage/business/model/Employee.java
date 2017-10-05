/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.interage.business.dto.EmployeeDto;
import br.gov.pa.prodepa.domain.Model;

/**
 *
 * @author antoniojunior
 */
@SqlResultSetMappings({
	@SqlResultSetMapping(
		name="EmployeeMapping",
		entities= {
			@EntityResult(
				entityClass=Employee.class,
				fields= {
					@FieldResult(name="empNo", column="emp_no"),
					@FieldResult(name="firtName", column="firt_name"),
					@FieldResult(name="lastName", column="last_name"),
					@FieldResult(name="phoneExt", column="phone_ext"),
					@FieldResult(name="hireDate", column="hire_date"),
					@FieldResult(name="salary", column="salary"),
					@FieldResult(name="fullName", column="full_name")})}
	),
	@SqlResultSetMapping(
			name="EmployeeDtoMapping",
			classes = @ConstructorResult(
					targetClass=EmployeeDto.class,
					columns= {
							@ColumnResult(name="emp_no")}))
})
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Model {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EMP_NO")
	private Short empNo;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Size(max = 4)
	@Column(name = "PHONE_EXT")
	private String phoneExt;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "HIRE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hireDate;
	
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(name = "SALARY")
	private BigDecimal salary;
	
	@Size(max = 37)
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@JsonIgnore
	@JoinColumn(name = "DEPT_NO", referencedColumnName = "DEPT_NO")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Department department;
	
	/*
	@JsonIgnore
	@JoinTable(name = "EMPLOYEE_PROJECT", joinColumns = {
			@JoinColumn(name = "EMP_NO", referencedColumnName = "EMP_NO") }, inverseJoinColumns = {
					@JoinColumn(name = "PROJ_ID", referencedColumnName = "PROJ_ID") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Project> projectList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teamLeader", fetch = FetchType.LAZY)
	private List<Project> projectList1;
	
	@JsonIgnore
	@JoinColumns({ @JoinColumn(name = "JOB_CODE", referencedColumnName = "JOB_CODE"),
			@JoinColumn(name = "JOB_GRADE", referencedColumnName = "JOB_GRADE"),
			@JoinColumn(name = "JOB_COUNTRY", referencedColumnName = "JOB_COUNTRY") })
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Job job;*/

	public Employee() {
	}

	public Employee(Short empNo) {
		this.empNo = empNo;
	}

	public Employee(Short empNo, String firstName, String lastName, Date hireDate, BigDecimal salary) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.salary = salary;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department deptNo) {
		this.department = deptNo;
	}
	/*
	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Project> getProjectList1() {
		return projectList1;
	}

	public void setProjectList1(List<Project> projectList1) {
		this.projectList1 = projectList1;
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}*/

	@Transient
	public Object getId() {
		return empNo;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (empNo != null ? empNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) object;
		if ((this.empNo == null && other.empNo != null) || (this.empNo != null && !this.empNo.equals(other.empNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneExt="
				+ phoneExt + ", hireDate=" + hireDate + ", salary=" + salary + ", fullName=" + fullName + "]";
	}


}
