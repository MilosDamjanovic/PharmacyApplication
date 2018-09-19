package com.nst.md.pharmacy.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "value_added_tax")
@XmlRootElement
public class ValueAddedTax implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "value_added_taxId", unique = true)
    private long valueAddedTaxId;

    @Basic
    @Column(name = "tax_rate")
    private double taxRate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Medicine.class, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "value_added_taxId")
    private List<Medicine> medicines;

    public ValueAddedTax() {
    }

    public ValueAddedTax(long valueAddedTaxId, double taxRate, List<Medicine> medicines) {
        this.valueAddedTaxId = valueAddedTaxId;
        this.taxRate = taxRate;
       // this.medicines = medicines;
    }

    public long getValueAddedTaxId() {
        return valueAddedTaxId;
    }

    public void setValueAddedTaxId(long valueAddedTaxId) {
        this.valueAddedTaxId = valueAddedTaxId;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueAddedTax that = (ValueAddedTax) o;
        return valueAddedTaxId == that.valueAddedTaxId &&
                Objects.equals(taxRate, that.taxRate);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }
}
