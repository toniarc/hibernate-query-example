/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interage.business.model;

import java.io.Serializable;
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
@Table(name = "CUSTOMER")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUST_NO")
    private Integer custNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CUSTOMER")
    private String customer;
    @Size(max = 15)
    @Column(name = "CONTACT_FIRST")
    private String contactFirst;
    @Size(max = 20)
    @Column(name = "CONTACT_LAST")
    private String contactLast;
    @Size(max = 20)
    @Column(name = "PHONE_NO")
    private String phoneNo;
    @Size(max = 30)
    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;
    @Size(max = 30)
    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;
    @Size(max = 25)
    @Column(name = "CITY")
    private String city;
    @Size(max = 15)
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Size(max = 12)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "ON_HOLD")
    private Character onHold;
    @JoinColumn(name = "COUNTRY", referencedColumnName = "COUNTRY")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custNo", fetch = FetchType.LAZY)
    private List<Sales> salesList;

    public Customer() {
    }

    public Customer(Integer custNo) {
        this.custNo = custNo;
    }

    public Customer(Integer custNo, String customer) {
        this.custNo = custNo;
        this.customer = customer;
    }

    public Integer getCustNo() {
        return custNo;
    }

    public void setCustNo(Integer custNo) {
        this.custNo = custNo;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getContactFirst() {
        return contactFirst;
    }

    public void setContactFirst(String contactFirst) {
        this.contactFirst = contactFirst;
    }

    public String getContactLast() {
        return contactLast;
    }

    public void setContactLast(String contactLast) {
        this.contactLast = contactLast;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Character getOnHold() {
        return onHold;
    }

    public void setOnHold(Character onHold) {
        this.onHold = onHold;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custNo != null ? custNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custNo == null && other.custNo != null) || (this.custNo != null && !this.custNo.equals(other.custNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.Customer[ custNo=" + custNo + " ]";
    }
    
}
