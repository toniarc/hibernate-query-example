/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antoniojunior
 */
@Embeddable
public class SalaryHistoryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_NO")
    private short empNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHANGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UPDATER_ID")
    private String updaterId;

    public SalaryHistoryPK() {
    }

    public SalaryHistoryPK(short empNo, Date changeDate, String updaterId) {
        this.empNo = empNo;
        this.changeDate = changeDate;
        this.updaterId = updaterId;
    }

    public short getEmpNo() {
        return empNo;
    }

    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNo;
        hash += (changeDate != null ? changeDate.hashCode() : 0);
        hash += (updaterId != null ? updaterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryHistoryPK)) {
            return false;
        }
        SalaryHistoryPK other = (SalaryHistoryPK) object;
        if (this.empNo != other.empNo) {
            return false;
        }
        if ((this.changeDate == null && other.changeDate != null) || (this.changeDate != null && !this.changeDate.equals(other.changeDate))) {
            return false;
        }
        if ((this.updaterId == null && other.updaterId != null) || (this.updaterId != null && !this.updaterId.equals(other.updaterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.SalaryHistoryPK[ empNo=" + empNo + ", changeDate=" + changeDate + ", updaterId=" + updaterId + " ]";
    }
    
}
