/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesitiko;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jackson
 */
@Entity
@Table(name = "house", catalog = "db2lab6", schema = "db201")
@NamedQueries({
    @NamedQuery(name = "House.findAll", query = "SELECT h FROM House h"),
    @NamedQuery(name = "House.findByCode", query = "SELECT h FROM House h WHERE h.code = :code"),
    @NamedQuery(name = "House.findByCity", query = "SELECT h FROM House h WHERE h.city = :city"),
    @NamedQuery(name = "House.findByAddress", query = "SELECT h FROM House h WHERE h.address = :address"),
    @NamedQuery(name = "House.findBySqm", query = "SELECT h FROM House h WHERE h.sqm = :sqm"),
    @NamedQuery(name = "House.findByRooms", query = "SELECT h FROM House h WHERE h.rooms = :rooms"),
    @NamedQuery(name = "House.findByFloor", query = "SELECT h FROM House h WHERE h.floor = :floor"),
    @NamedQuery(name = "House.findByYearBuilt", query = "SELECT h FROM House h WHERE h.yearBuilt = :yearBuilt"),
    @NamedQuery(name = "House.findByPriceSale", query = "SELECT h FROM House h WHERE h.priceSale = :priceSale"),
    @NamedQuery(name = "House.findByPriceRent", query = "SELECT h FROM House h WHERE h.priceRent = :priceRent"),
    @NamedQuery(name = "House.findByBrokerCode", query = "SELECT h FROM House h WHERE h.brokerCode = :brokerCode"),
    @NamedQuery(name = "House.findByOwner", query = "SELECT h FROM House h WHERE h.owner = :owner")})
public class House implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "sqm")
    private int sqm;
    @Basic(optional = false)
    @Column(name = "rooms")
    private int rooms;
    @Basic(optional = false)
    @Column(name = "floor")
    private int floor;
    @Column(name = "year_built")
    private Integer yearBuilt;
    @Column(name = "price_sale")
    private Integer priceSale;
    @Column(name = "price_rent")
    private Integer priceRent;
    @Column(name = "broker_code")
    private Integer brokerCode;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "owner")
    private String owner;

    public House() {
    }

    public House(Integer code) {
        this.code = code;
    }

    public House(Integer code, int sqm, int rooms, int floor) {
        this.code = code;
        this.sqm = sqm;
        this.rooms = rooms;
        this.floor = floor;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        Integer oldCode = this.code;
        this.code = code;
        changeSupport.firePropertyChange("code", oldCode, code);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public int getSqm() {
        return sqm;
    }

    public void setSqm(int sqm) {
        int oldSqm = this.sqm;
        this.sqm = sqm;
        changeSupport.firePropertyChange("sqm", oldSqm, sqm);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        int oldRooms = this.rooms;
        this.rooms = rooms;
        changeSupport.firePropertyChange("rooms", oldRooms, rooms);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        int oldFloor = this.floor;
        this.floor = floor;
        changeSupport.firePropertyChange("floor", oldFloor, floor);
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        Integer oldYearBuilt = this.yearBuilt;
        this.yearBuilt = yearBuilt;
        changeSupport.firePropertyChange("yearBuilt", oldYearBuilt, yearBuilt);
    }

    public Integer getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Integer priceSale) {
        Integer oldPriceSale = this.priceSale;
        this.priceSale = priceSale;
        changeSupport.firePropertyChange("priceSale", oldPriceSale, priceSale);
    }

    public Integer getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(Integer priceRent) {
        Integer oldPriceRent = this.priceRent;
        this.priceRent = priceRent;
        changeSupport.firePropertyChange("priceRent", oldPriceRent, priceRent);
    }

    public Integer getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(Integer brokerCode) {
        Integer oldBrokerCode = this.brokerCode;
        this.brokerCode = brokerCode;
        changeSupport.firePropertyChange("brokerCode", oldBrokerCode, brokerCode);
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        byte[] oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        String oldOwner = this.owner;
        this.owner = owner;
        changeSupport.firePropertyChange("owner", oldOwner, owner);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof House)) {
            return false;
        }
        House other = (House) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mesitiko.House[ code=" + code + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
