/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesitiko;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jackson
 */
@Entity
@Table(name = "CLIENT", catalog = "", schema = "DBLAB_151")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByCode", query = "SELECT c FROM Client c WHERE c.code = :code"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findBySurname", query = "SELECT c FROM Client c WHERE c.surname = :surname"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByInterest", query = "SELECT c FROM Client c WHERE c.interest = :interest"),
    @NamedQuery(name = "Client.findByRent", query = "SELECT c FROM Client c WHERE c.rent = :rent"),
    @NamedQuery(name = "Client.findByBuy", query = "SELECT c FROM Client c WHERE c.buy = :buy")})
public class Client implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CODE")
    private long code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TELEPHONE")
    private BigDecimal telephone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "INTEREST")
    private Long interest;
    @Column(name = "RENT")
    private Long rent;
    @Column(name = "BUY")
    private Long buy;

    public Client() {
    }

    public Client(BigDecimal telephone) {
        this.telephone = telephone;
    }

    public Client(BigDecimal telephone, long code) {
        this.telephone = telephone;
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        long oldCode = this.code;
        this.code = code;
        changeSupport.firePropertyChange("code", oldCode, code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        changeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public BigDecimal getTelephone() {
        return telephone;
    }

    public void setTelephone(BigDecimal telephone) {
        BigDecimal oldTelephone = this.telephone;
        this.telephone = telephone;
        changeSupport.firePropertyChange("telephone", oldTelephone, telephone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        Long oldInterest = this.interest;
        this.interest = interest;
        changeSupport.firePropertyChange("interest", oldInterest, interest);
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        Long oldRent = this.rent;
        this.rent = rent;
        changeSupport.firePropertyChange("rent", oldRent, rent);
    }

    public Long getBuy() {
        return buy;
    }

    public void setBuy(Long buy) {
        Long oldBuy = this.buy;
        this.buy = buy;
        changeSupport.firePropertyChange("buy", oldBuy, buy);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telephone != null ? telephone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.telephone == null && other.telephone != null) || (this.telephone != null && !this.telephone.equals(other.telephone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mesitiko.Client[ telephone=" + telephone + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
