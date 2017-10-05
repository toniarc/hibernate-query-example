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
public class JobPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "JOB_CODE")
    private String jobCode;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOB_GRADE")
    private short jobGrade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "JOB_COUNTRY")
    private String jobCountry;

    public JobPK() {
    }

    public JobPK(String jobCode, short jobGrade, String jobCountry) {
        this.jobCode = jobCode;
        this.jobGrade = jobGrade;
        this.jobCountry = jobCountry;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public short getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(short jobGrade) {
        this.jobGrade = jobGrade;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobCode != null ? jobCode.hashCode() : 0);
        hash += (int) jobGrade;
        hash += (jobCountry != null ? jobCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPK)) {
            return false;
        }
        JobPK other = (JobPK) object;
        if ((this.jobCode == null && other.jobCode != null) || (this.jobCode != null && !this.jobCode.equals(other.jobCode))) {
            return false;
        }
        if (this.jobGrade != other.jobGrade) {
            return false;
        }
        if ((this.jobCountry == null && other.jobCountry != null) || (this.jobCountry != null && !this.jobCountry.equals(other.jobCountry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.JobPK[ jobCode=" + jobCode + ", jobGrade=" + jobGrade + ", jobCountry=" + jobCountry + " ]";
    }
    
}
