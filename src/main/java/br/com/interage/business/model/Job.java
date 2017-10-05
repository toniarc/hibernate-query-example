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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "JOB")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected JobPK jobPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIN_SALARY")
    private BigDecimal minSalary;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAX_SALARY")
    private BigDecimal maxSalary;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "JOB_REQUIREMENT")
    private String jobRequirement;
    
    @Size(max = 15)
    @Column(name = "LANGUAGE_REQ")
    private String languageReq;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    //private List<Employee> employeeList;
    
    @JoinColumn(name = "JOB_COUNTRY", referencedColumnName = "COUNTRY", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;

    public Job() {
    }

    public Job(JobPK jobPK) {
        this.jobPK = jobPK;
    }

    public Job(JobPK jobPK, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
        this.jobPK = jobPK;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Job(String jobCode, short jobGrade, String jobCountry) {
        this.jobPK = new JobPK(jobCode, jobGrade, jobCountry);
    }

    public JobPK getJobPK() {
        return jobPK;
    }

    public void setJobPK(JobPK jobPK) {
        this.jobPK = jobPK;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement;
    }

    public String getLanguageReq() {
        return languageReq;
    }

    public void setLanguageReq(String languageReq) {
        this.languageReq = languageReq;
    }

    /*
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }*/

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobPK != null ? jobPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobPK == null && other.jobPK != null) || (this.jobPK != null && !this.jobPK.equals(other.jobPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.Job[ jobPK=" + jobPK + " ]";
    }
    
}
