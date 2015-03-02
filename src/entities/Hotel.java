/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ammar
 */
@Entity
@Table(name = "hotel", catalog = "hotel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")})
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "image_id")
    private Integer imageId;
    @Column(name = "stars")
    private Boolean stars;
    @Column(name = "address")
    private String address;
    @Column(name = "map")
    private String map;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "website")
    private String website;
    @Column(name = "email")
    private String email;
    @Column(name = "total_rooms")
    private Short totalRooms;
    @Column(name = "country")
    private Short country;
    @Column(name = "city")
    private Integer city;
    @Column(name = "state")
    private Integer state;
    @Column(name = "activity")
    private Boolean activity;
    @Column(name = "activity_start_date")
    @Temporal(TemporalType.DATE)
    private Date activityStartDate;
    @Column(name = "activity_end_date")
    @Temporal(TemporalType.DATE)
    private Date activityEndDate;
    @Column(name = "agreement")
    private Boolean agreement;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hotelId", fetch = FetchType.LAZY)
    private HotelDetails hotelDetails;

    public Hotel() {
    }

    public Hotel(Integer id) {
        this.id = id;
    }

    public Hotel(Integer id, String name) {
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

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Boolean getStars() {
        return stars;
    }

    public void setStars(Boolean stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Short totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Short getCountry() {
        return country;
    }

    public void setCountry(Short country) {
        this.country = country;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public Date getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

    public Date getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    public Boolean getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean agreement) {
        this.agreement = agreement;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
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
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hotel[ id=" + id + " ]";
    }
    
}
