/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ammar
 */
@Entity
@Table(name = "hotel_details", catalog = "hotel", schema = "")
@NamedQueries({
    @NamedQuery(name = "HotelDetails.findAll", query = "SELECT h FROM HotelDetails h")})
public class HotelDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "check_in_from")
    private String checkInFrom;
    @Column(name = "chech_in_to")
    private String chechInTo;
    @Column(name = "check_out_from")
    private String checkOutFrom;
    @Column(name = "check_out_to")
    private String checkOutTo;
    @Basic(optional = false)
    @Column(name = "internet")
    private String internet;
    @Column(name = "parking")
    private String parking;
    @Column(name = "breakfast")
    private String breakfast;
    @Column(name = "is_pet_allowed")
    private Integer isPetAllowed;
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Hotel hotelId;

    public HotelDetails() {
    }

    public HotelDetails(Integer id) {
        this.id = id;
    }

    public HotelDetails(Integer id, String internet) {
        this.id = id;
        this.internet = internet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckInFrom() {
        return checkInFrom;
    }

    public void setCheckInFrom(String checkInFrom) {
        this.checkInFrom = checkInFrom;
    }

    public String getChechInTo() {
        return chechInTo;
    }

    public void setChechInTo(String chechInTo) {
        this.chechInTo = chechInTo;
    }

    public String getCheckOutFrom() {
        return checkOutFrom;
    }

    public void setCheckOutFrom(String checkOutFrom) {
        this.checkOutFrom = checkOutFrom;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getIsPetAllowed() {
        return isPetAllowed;
    }

    public void setIsPetAllowed(Integer isPetAllowed) {
        this.isPetAllowed = isPetAllowed;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
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
        if (!(object instanceof HotelDetails)) {
            return false;
        }
        HotelDetails other = (HotelDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelDetails[ id=" + id + " ]";
    }
    
}
