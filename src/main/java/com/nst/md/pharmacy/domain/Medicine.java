package com.nst.md.pharmacy.domain;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "medicine")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Medicine.findAll", query = "select m from Medicine m"),
        @NamedQuery(name = "Medicine.findByName", query = "select m from Medicine m where m.name=:name"),
        @NamedQuery(name="Medicine.findByManufacturer", query = "select m from Medicine m where m.manufacturer=:manufacturer"),
})
public class Medicine implements Serializable{

    private static final long serialVersionUID = 5L;

    private Long medicineId;
    private String name;
    private String manufacturer;
    private String composition;
    private String packing;
    private int quantity;
    private double price;
    private Date expirationDate;
    private Date productionDate;

    /*
    @ManyToOne
    @JoinColumn(name = "value_added_taxId")
    private ValueAddedTax valueAddedTax;
    */

    public Medicine() {

    }
    public Medicine(Long medicineId,
                    String name,
                    String manufacturer,
                    String composition,
                    String packing,
                    int quantity,
                    double price,
                    Date expirationDate,
                    Date productionDate) {

        this.medicineId = medicineId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.composition = composition;
        this.packing = packing;
        this.quantity = quantity;
        this.price = price;
        this.expirationDate = expirationDate;
        this.productionDate = productionDate;
    }

    @Id
    @Column(name = "medicine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getmedicineId() {
        return medicineId;
    }

    public void setmedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    @Basic(optional = false)
    @Column(name = "name")
    @Size(max = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional = false)
    @Size(max = 150)
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic(optional = false)
    @Column(name = "composition")
    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    @Basic(optional = false)
    @Column(name = "packing")
    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Basic(optional = false)
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic(optional = false)
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic(optional = false)
    @Column(name = "production_date")
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", composition='" + composition + '\'' +
                ", packing='" + packing + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                ", productionDate=" + productionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return medicineId == medicine.medicineId &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(manufacturer, medicine.manufacturer) &&
                Objects.equals(composition, medicine.composition) &&
                Objects.equals(packing, medicine.packing) &&
                Objects.equals(quantity, medicine.quantity) &&
                Objects.equals(price, medicine.price) &&
                Objects.equals(expirationDate, medicine.expirationDate) &&
                Objects.equals(productionDate, medicine.productionDate);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.composition);
        hash = 97 * hash + Objects.hashCode(this.manufacturer);
        hash = 97 * hash + Objects.hashCode(this.packing);
        return hash;
    }

}
