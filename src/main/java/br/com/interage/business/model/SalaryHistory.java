/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author antoniojunior
 */
@Entity
@Table(name = "SALARY_HISTORY")
@NamedQueries({
    @NamedQuery(name = "SalaryHistory.findAll", query = "SELECT s FROM SalaryHistory s")})
public class SalaryHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalaryHistoryPK salaryHistoryPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLD_SALARY")
    private BigDecimal oldSalary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCENT_CHANGE")
    private double percentChange;
    @Column(name = "NEW_SALARY")
    private Double newSalary;
    @JoinColumn(name = "EMP_NO", referencedColumnName = "EMP_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public SalaryHistory() {
    }

    public SalaryHistory(SalaryHistoryPK salaryHistoryPK) {
        this.salaryHistoryPK = salaryHistoryPK;
    }

    public SalaryHistory(SalaryHistoryPK salaryHistoryPK, BigDecimal oldSalary, double percentChange) {
        this.salaryHistoryPK = salaryHistoryPK;
        this.oldSalary = oldSalary;
        this.percentChange = percentChange;
    }

    public SalaryHistory(short empNo, Date changeDate, String updaterId) {
        this.salaryHistoryPK = new SalaryHistoryPK(empNo, changeDate, updaterId);
    }

    public SalaryHistoryPK getSalaryHistoryPK() {
        return salaryHistoryPK;
    }

    public void setSalaryHistoryPK(SalaryHistoryPK salaryHistoryPK) {
        this.salaryHistoryPK = salaryHistoryPK;
    }

    public BigDecimal getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(BigDecimal oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public Double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(Double newSalary) {
        this.newSalary = newSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryHistoryPK != null ? salaryHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryHistory)) {
            return false;
        }
        SalaryHistory other = (SalaryHistory) object;
        if ((this.salaryHistoryPK == null && other.salaryHistoryPK != null) || (this.salaryHistoryPK != null && !this.salaryHistoryPK.equals(other.salaryHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.SalaryHistory[ salaryHistoryPK=" + salaryHistoryPK + " ]";
    }
    
}
