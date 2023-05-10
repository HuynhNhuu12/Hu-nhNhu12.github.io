/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "booking_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b"),
    @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BookingDetail.findByCustomerName", query = "SELECT b FROM BookingDetail b WHERE b.customerName = :customerName"),
    @NamedQuery(name = "BookingDetail.findByCustomerPhone", query = "SELECT b FROM BookingDetail b WHERE b.customerPhone = :customerPhone"),
    @NamedQuery(name = "BookingDetail.findByIsPayment", query = "SELECT b FROM BookingDetail b WHERE b.isPayment = :isPayment")})
public class BookingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "customer_name")
    private String customerName;
    @Size(max = 45)
    @Column(name = "customer_phone")
    private String customerPhone;
    @Size(max = 45)
    @Column(name = "is_payment")
    private String isPayment;
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Booking bookingId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User customerId;

    public BookingDetail() {
    }

    public BookingDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(String isPayment) {
        this.isPayment = isPayment;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetail)) {
            return false;
        }
        BookingDetail other = (BookingDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hn.pojo.BookingDetail[ id=" + id + " ]";
    }
    
}
