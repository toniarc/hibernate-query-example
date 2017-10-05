/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antoniojunior
 */
@Entity
@Table(name = "DEPARTMENT")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DEPT_NO")
    private String deptNo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DEPARTMENT")
    private String department;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BUDGET")
    private BigDecimal budget;
    
    @Size(max = 15)
    @Column(name = "LOCATION")
    private String location;
    
    @Size(max = 20)
    @Column(name = "PHONE_NO")
    private String phoneNo;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    //private List<Employee> employeeList;
    
    @OneToMany(mappedBy = "headDept", fetch = FetchType.LAZY)
    private List<Department> departmentList;
    
    @JoinColumn(name = "HEAD_DEPT", referencedColumnName = "DEPT_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department headDept;
    
    @JoinColumn(name = "MNGR_NO", referencedColumnName = "EMP_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee mngrNo;

    public Department() {
    }

    public Department(String deptNo) {
        this.deptNo = deptNo;
    }

    public Department(String deptNo, String department) {
        this.deptNo = deptNo;
        this.department = department;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /*
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }*/

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Department getHeadDept() {
        return headDept;
    }

    public void setHeadDept(Department headDept) {
        this.headDept = headDept;
    }

    public Employee getMngrNo() {
        return mngrNo;
    }

    public void setMngrNo(Employee mngrNo) {
        this.mngrNo = mngrNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptNo != null ? deptNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.deptNo == null && other.deptNo != null) || (this.deptNo != null && !this.deptNo.equals(other.deptNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.Department[ deptNo=" + deptNo + " ]";
    }
    
}
