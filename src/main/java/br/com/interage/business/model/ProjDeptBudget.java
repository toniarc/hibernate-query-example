/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author antoniojunior
 */
@Entity
@Table(name = "br.com.interage.business.model")
@NamedQueries({
    @NamedQuery(name = "ProjDeptBudget.findAll", query = "SELECT p FROM ProjDeptBudget p")})
public class ProjDeptBudget implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProjDeptBudgetPK projDeptBudgetPK;
    
    @Column(name = "QUART_HEAD_CNT")
    private Integer quartHeadCnt;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROJECTED_BUDGET")
    private BigDecimal projectedBudget;
    
    @JoinColumn(name = "DEPT_NO", referencedColumnName = "DEPT_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department department;
    
    @JoinColumn(name = "PROJ_ID", referencedColumnName = "PROJ_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Project project;

    public ProjDeptBudget() {
    }

    public ProjDeptBudget(ProjDeptBudgetPK projDeptBudgetPK) {
        this.projDeptBudgetPK = projDeptBudgetPK;
    }

    public ProjDeptBudget(int fiscalYear, String projId, String deptNo) {
        this.projDeptBudgetPK = new ProjDeptBudgetPK(fiscalYear, projId, deptNo);
    }

    public ProjDeptBudgetPK getProjDeptBudgetPK() {
        return projDeptBudgetPK;
    }

    public void setProjDeptBudgetPK(ProjDeptBudgetPK projDeptBudgetPK) {
        this.projDeptBudgetPK = projDeptBudgetPK;
    }

    public Integer getQuartHeadCnt() {
        return quartHeadCnt;
    }

    public void setQuartHeadCnt(Integer quartHeadCnt) {
        this.quartHeadCnt = quartHeadCnt;
    }

    public BigDecimal getProjectedBudget() {
        return projectedBudget;
    }

    public void setProjectedBudget(BigDecimal projectedBudget) {
        this.projectedBudget = projectedBudget;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projDeptBudgetPK != null ? projDeptBudgetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjDeptBudget)) {
            return false;
        }
        ProjDeptBudget other = (ProjDeptBudget) object;
        if ((this.projDeptBudgetPK == null && other.projDeptBudgetPK != null) || (this.projDeptBudgetPK != null && !this.projDeptBudgetPK.equals(other.projDeptBudgetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.ProjDeptBudget[ projDeptBudgetPK=" + projDeptBudgetPK + " ]";
    }
    
}
