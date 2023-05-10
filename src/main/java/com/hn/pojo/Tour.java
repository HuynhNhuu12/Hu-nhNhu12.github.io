/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HUYNH NHU
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findByName", query = "SELECT t FROM Tour t WHERE t.name = :name"),
    @NamedQuery(name = "Tour.findByDescription", query = "SELECT t FROM Tour t WHERE t.description = :description"),
    @NamedQuery(name = "Tour.findByPriceAdult", query = "SELECT t FROM Tour t WHERE t.priceAdult = :priceAdult"),
    @NamedQuery(name = "Tour.findByPriceChild", query = "SELECT t FROM Tour t WHERE t.priceChild = :priceChild"),
    @NamedQuery(name = "Tour.findByPriceInfant", query = "SELECT t FROM Tour t WHERE t.priceInfant = :priceInfant"),
    @NamedQuery(name = "Tour.findByImage", query = "SELECT t FROM Tour t WHERE t.image = :image"),
    @NamedQuery(name = "Tour.findByStartDate", query = "SELECT t FROM Tour t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Tour.findByActive", query = "SELECT t FROM Tour t WHERE t.active = :active"),
    @NamedQuery(name = "Tour.findByLimit", query = "SELECT t FROM Tour t WHERE t.limit = :limit")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "price_adult")
    private Long priceAdult;
    @Column(name = "price_child")
    private Long priceChild;
    @Column(name = "price_infant")
    private Long priceInfant;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "limit")
    private Integer limit;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private Set<Booking> bookingSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private Set<Comments> commentsSet;
    
    @JoinColumn(name = "categoty_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Category categoryId;
    @JsonIgnore
    @Transient
    private MultipartFile file;

    public Tour() {
        this.id = 0;
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Tour(Integer id, String name) {
        this.id = id;
        this.name = name;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(Long priceAdult) {
        this.priceAdult = priceAdult;
    }

    public Long getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(Long priceChild) {
        this.priceChild = priceChild;
    }

    public Long getPriceInfant() {
        return priceInfant;
    }

    public void setPriceInfant(Long priceInfant) {
        this.priceInfant = priceInfant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @XmlTransient
    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    @XmlTransient
    public Set<Comments> getCommentsSet() {
        return commentsSet;
    }

    public void setCommentsSet(Set<Comments> commentsSet) {
        this.commentsSet = commentsSet;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hn.pojo.Tour[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
