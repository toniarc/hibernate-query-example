/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author antoniojunior
 */
@Entity
@Table(name = "PHONE_LIST")
@NamedQueries({@NamedQuery(name = "PhoneList.findAll", query = "SELECT p FROM PhoneList p")})
public class PhoneList implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "EMP_NO")
    private Short empNo;
    
    @Size(max = 15)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Size(max = 4)
    @Column(name = "PHONE_EXT")
    private String phoneExt;
    
    @Size(max = 15)
    @Column(name = "LOCATION")
    private String location;

    @Id
    @Size(max = 20)
    @Column(name = "PHONE_NO")
    private String phoneNo;

    public PhoneList() {
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
    
}
