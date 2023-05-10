/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYNH NHU
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByCreatedDate", query = "SELECT b FROM Booking b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "Booking.findByNumAdult", query = "SELECT b FROM Booking b WHERE b.numAdult = :numAdult"),
    @NamedQuery(name = "Booking.findByNumChild", query = "SELECT b FROM Booking b WHERE b.numChild = :numChild"),
    @NamedQuery(name = "Booking.findByNumInfant", query = "SELECT b FROM Booking b WHERE b.numInfant = :numInfant")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 45)
    @Column(name = "num_adult")
    private String numAdult;
    @Size(max = 45)
    @Column(name = "num_child")
    private String numChild;
    @Size(max = 45)
    @Column(name = "num_infant")
    private String numInfant;
    
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tour tourId;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private Set<BookingDetail> bookingDetailSet;

    public Booking() {
        createdDate = new Date();
    }
    
    public Booking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(String numAdult) {
        this.numAdult = numAdult;
    }

    public String getNumChild() {
        return numChild;
    }

    public void setNumChild(String numChild) {
        this.numChild = numChild;
    }

    public String getNumInfant() {
        return numInfant;
    }

    public void setNumInfant(String numInfant) {
        this.numInfant = numInfant;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<BookingDetail> getBookingDetailSet() {
        return bookingDetailSet;
    }

    public void setBookingDetailSet(Set<BookingDetail> bookingDetailSet) {
        this.bookingDetailSet = bookingDetailSet;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hn.pojo.Booking[ id=" + id + " ]";
    }

}
