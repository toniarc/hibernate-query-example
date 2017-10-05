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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antoniojunior
 */
@Entity
@Table(name = "SALES")
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PO_NUMBER")
    private String poNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "SHIP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Column(name = "DATE_NEEDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNeeded;
    @Column(name = "PAID")
    private Character paid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTY_ORDERED")
    private int qtyOrdered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_VALUE")
    private BigDecimal totalValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNT")
    private double discount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Column(name = "AGED")
    private BigDecimal aged;
    @JoinColumn(name = "CUST_NO", referencedColumnName = "CUST_NO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer custNo;
    @JoinColumn(name = "SALES_REP", referencedColumnName = "EMP_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee salesRep;

    public Sales() {
    }

    public Sales(String poNumber) {
        this.poNumber = poNumber;
    }

    public Sales(String poNumber, String orderStatus, Date orderDate, int qtyOrdered, BigDecimal totalValue, double discount, String itemType) {
        this.poNumber = poNumber;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.qtyOrdered = qtyOrdered;
        this.totalValue = totalValue;
        this.discount = discount;
        this.itemType = itemType;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(Date dateNeeded) {
        this.dateNeeded = dateNeeded;
    }

    public Character getPaid() {
        return paid;
    }

    public void setPaid(Character paid) {
        this.paid = paid;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getAged() {
        return aged;
    }

    public void setAged(BigDecimal aged) {
        this.aged = aged;
    }

    public Customer getCustNo() {
        return custNo;
    }

    public void setCustNo(Customer custNo) {
        this.custNo = custNo;
    }

    public Employee getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Employee salesRep) {
        this.salesRep = salesRep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poNumber != null ? poNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.poNumber == null && other.poNumber != null) || (this.poNumber != null && !this.poNumber.equals(other.poNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interage.business.model.Sales[ poNumber=" + poNumber + " ]";
    }
    
}
