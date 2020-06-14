package com.esisa.contacts.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The Company entity.
 */
@Entity
@Table(name = "entreprise")
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "coutry")
    private String coutry;

    @OneToMany(mappedBy = "entreprise")
    private Set<Contact> contacts = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Entreprise name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public Entreprise streetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Entreprise postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public Entreprise city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoutry() {
        return coutry;
    }

    public Entreprise coutry(String coutry) {
        this.coutry = coutry;
        return this;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entreprise)) {
            return false;
        }
        return id != null && id.equals(((Entreprise) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", streetNumber='" + getStreetNumber() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", city='" + getCity() + "'" +
            ", coutry='" + getCoutry() + "'" +
            "}";
    }
}
