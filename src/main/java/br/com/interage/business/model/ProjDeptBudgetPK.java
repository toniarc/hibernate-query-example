/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antoniojunior
 */
@Embeddable
public class ProjDeptBudgetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FISCAL_YEAR")
    private int fiscalYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PROJ_ID")
    private String projId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DEPT_NO")
    private String deptNo;

    public ProjDeptBudgetPK() {
    }

    public ProjDeptBudgetPK(int fiscalYear, String projId, String deptNo) {
        this.fiscalYear = fiscalYear;
        this.projId = projId;
        this.deptNo = deptNo;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fiscalYear;
        hash += (projId != null ? projId.hashCode() : 0);
        hash += (deptNo != null ? deptNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjDeptBudgetPK)) {
            return false;
        }
        ProjDeptBudgetPK other = (ProjDeptBudgetPK) object;
        if (this.fiscalYear != other.fiscalYear) {
            return false;
        }
        if ((this.projId == null && other.projId != null) || (this.projId != null && !this.projId.equals(other.projId))) {
            return false;
        }
        if ((this.deptNo == null && other.deptNo != null) || (this.deptNo != null && !this.deptNo.equals(other.deptNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.ProjDeptBudgetPK[ fiscalYear=" + fiscalYear + ", projId=" + projId + ", deptNo=" + deptNo + " ]";
    }
    
}
